package com.kalix.enrolment.question.biz;

import com.kalix.admin.core.api.biz.IRoleBeanService;
import com.kalix.admin.core.entities.RoleBean;
import com.kalix.enrolment.question.api.biz.*;
import com.kalix.enrolment.question.dto.model.BaseQuestionDTO;
import com.kalix.enrolment.question.dto.model.CompareQuestionDTO;
import com.kalix.enrolment.question.dto.model.RepeatedCountDTO;
import com.kalix.enrolment.question.entities.BaseQuestionEntity;
import com.kalix.enrolment.question.entities.QuestionRepeatedBean;
import com.kalix.enrolment.question.entities.QuestionSettingBean;
import com.kalix.enrolment.system.dict.api.biz.IEnrolmentDictBeanService;
import com.kalix.enrolment.system.dict.entities.EnrolmentDictBean;
import com.kalix.framework.core.api.dao.IGenericDao;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.util.ConfigUtil;
import com.kalix.framework.core.util.SerializeUtil;
import com.kalix.framework.core.util.StringUtils;
import com.kalix.framework.extend.impl.biz.LogicDeleteGenericBizServiceImpl;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.xm.Similarity;

import javax.transaction.Transactional;
import java.io.BufferedWriter;
import java.io.File;
import java.io.StringWriter;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by hqj at 2018-10-31
 */
public abstract class QuestionGenericBizServiceImpl<T extends IGenericDao, TP extends BaseQuestionEntity>
        extends LogicDeleteGenericBizServiceImpl<T, TP>
        implements IQuestionService<TP>, IQuestionAuditService, IRepeatedService {

    protected static String DICT_QUESTIONTYPE = "题型";
    protected IEnrolmentDictBeanService enrolmentDictBeanService;
    protected IRoleBeanService roleBeanService;
    protected IQuestionSettingBeanService questionSettingBeanService;
    protected IQuestionRepeatedBeanService questionRepeatedBeanService;

    protected static int MAX_REPEATED_RECORD = 1;

    /**
     * 查询试题默认排序
     *
     * @param page
     * @param limit
     * @param jsonStr
     * @param sort
     * @return
     */
    @Override
    public JsonData getAllEntityByQuery(Integer page, Integer limit, String jsonStr, String sort) {
        if (StringUtils.isEmpty(sort)) {
            sort = "[{'property': 'delFlag', 'direction': 'ASC'},{'property': 'updateDate', 'direction': 'DESC'}]";
        }
        return super.getAllEntityByQuery(page, limit, jsonStr, sort);
    }

    /**
     * 单条试题保存成功后，进行排重比对
     *
     * @param entity
     * @param status
     */
    @Override
    public void afterSaveEntity(TP entity, JsonStatus status) {
        super.afterSaveEntity(entity, status);
        this.compareSingleSimilarity(entity, status);
    }

    /**
     * 获取题型名称
     *
     * @return
     */
    @Override
    public String getQuestionTypeName() {
        String questionType = this.getQuestionType();
        EnrolmentDictBean enrolmentDictBean = enrolmentDictBeanService.getDictBeanByTypeAndValue(DICT_QUESTIONTYPE, questionType);
        return enrolmentDictBean.getLabel();
    }

    /**
     * 获取题型beans
     *
     * @return
     */
    @Override
    public String getQuestionBeans() {
        String questionType = this.getQuestionType();
        EnrolmentDictBean enrolmentDictBean = enrolmentDictBeanService.getDictBeanByTypeAndValue(DICT_QUESTIONTYPE, questionType);
        return enrolmentDictBean.getDescription() == null ? "" : enrolmentDictBean.getDescription().toLowerCase() + "s";
    }

    /**
     * 获取题型子类名称
     *
     * @param subType
     * @return
     */
    @Override
    public String getSubTypeName(String subType) {
        String subTypeName = "";
        if (StringUtils.isEmpty(subType)) {
            subTypeName = "";
        } else {
            EnrolmentDictBean enrolmentDictBean = enrolmentDictBeanService.getDictBeanByTypeAndValue(this.getSubTypeDictType(), subType);
            subTypeName = enrolmentDictBean.getLabel();
        }
        return subTypeName;
    }

    /**
     * 获取试题审核角色名称
     *
     * @param subType
     * @return
     */
    @Override
    public String getAuditRoleName(String subType) {
        String auditRoleName = "";
        if (StringUtils.isEmpty(subType)) {
            auditRoleName = this.getQuestionTypeName() + "审核人";
        } else {
            auditRoleName = this.getSubTypeName(subType) + "审核人";
        }
        return auditRoleName;
    }

    /**
     * 试题审核查询
     *
     * @param page
     * @param limit
     * @param subType
     * @return
     */
    @Override
    public JsonData getAllAuditEntityByQuery(Integer page, Integer limit, String subType) {

        // 获取当前登录人ID
        Long currentUserId = this.shiroService.getCurrentUserId();
        // 获取审核人角色名称
        String roleName = this.getAuditRoleName(subType);

        // 1.该类型试题未审核总数
        int total = 0;
        String countSql = "";
        if (StringUtils.isEmpty(subType)) {
            countSql = "select count(1) from " + dao.getTableName()
                    + " where delFlag = '0'"
                    + " and checkFlag = '0'"
                    + " and (to_char(creationdate,'yyyy') = to_char(now(),'yyyy'))";
        } else {
            countSql = "select count(1) from " + dao.getTableName()
                    + " where delFlag = '0'"
                    + " and checkFlag = '0'"
                    + " and (to_char(creationdate,'yyyy') = to_char(now(),'yyyy'))"
                    + " and subType = '" + subType + "'";
        }
        List list = dao.findByNativeSql(countSql, Integer.class);
        if (list != null && list.get(0) != null) {
            total = (Integer) list.get(0);
        }

        // 2.根据该试题的角色查找审核该试题的人员
        int persons = 0;
        List userIdList = new ArrayList();
        RoleBean roleBean = roleBeanService.queryByRoleName(roleName);
        if (roleBean != null) {
            userIdList = roleBeanService.getUserIdsByRoleId(roleBean.getId());
            persons = userIdList.size();
        }
        // 判断当前登录人是否是审核人;
        if (!userIdList.contains(currentUserId)) {
            return new JsonData();
        }

        // 3.平均分给每个人的试题数
        int perCnt = 0;
        int ys = 0;
        if (persons != 0) {
            perCnt = total / persons;
            ys = total % persons;
        }

        // 4.根据平均数、余数调整当前登录人的试题数
        for (int i = 0; i < userIdList.size(); i++) {
            if (userIdList.get(i).equals(currentUserId)) {
                if (i < ys) {
                    perCnt = perCnt + 1;
                    break;
                }
            }
        }

//        // 5.该类型试题当前人已经审核总数
//        int checkedTotal = 0;
//        String checkCountSql = "";
//        if (StringUtils.isEmpty(subType)) {
//            checkCountSql = "select count(1) from " + dao.getTableName()
//                    + " where delFlag = '0' "
//                    + " and checkFlag != '0'"
//                    + " and (to_char(creationdate,'yyyy') = to_char(now(),'yyyy'))"
//                    + " and checkerId = " + currentUserId;
//        } else {
//            checkCountSql = "select count(1) from " + dao.getTableName()
//                    + " where delFlag = '0' "
//                    + " and checkFlag != '0'"
//                    + " and (to_char(creationdate,'yyyy') = to_char(now(),'yyyy'))"
//                    + " and subType = '" + subType
//                    + "' and checkerId = " + currentUserId;
//        }
//        List checkList = dao.findByNativeSql(checkCountSql, Integer.class);
//        if (checkList != null && checkList.get(0) != null) {
//            checkedTotal = (Integer) list.get(0);
//        }

        // 5.获取偏移量，即数据库指针位置
        int offset = 0;
        for (int i = 0; i < userIdList.size(); i++) {
            if (userIdList.get(i).equals(currentUserId)) {
                if (i < ys) {
                    offset = i * perCnt;
                } else {
                    offset = i * perCnt + ys; //等同于(perCnt + 1) * ys + (i - ys) * perCnt;
                }
                break;
            }
        }

        // 6.分配未审核试题并查询分配结果（包括已经审核试题）
        String sql = "";
        if (StringUtils.isEmpty(subType)) {
            sql = "(select * from " + dao.getTableName()
                    + " where delFlag = '0' and checkFlag = '0'"
                    + " and (to_char(creationdate,'yyyy') = to_char(now(),'yyyy'))"
                    + " order by updateDate desc limit " + perCnt + " offset " + offset
                    + ") union all ("
                    + "select * from " + dao.getTableName()
                    + " where delFlag = '0' and checkFlag != '0'"
                    + " and (to_char(creationdate,'yyyy') = to_char(now(),'yyyy'))"
                    + " and checkerId = " + currentUserId
                    + " order by updateDate desc)";
        } else {
            sql = "(select * from " + dao.getTableName()
                    + " where delFlag = '0' and checkFlag = '0'"
                    + " and (to_char(creationdate,'yyyy') = to_char(now(),'yyyy'))"
                    + " and subType = '" + subType + "'"
                    + " order by updateDate desc limit " + perCnt + " offset " + offset
                    + ") union all ("
                    + "select * from " + dao.getTableName()
                    + " where delFlag = '0' and checkFlag != '0'"
                    + " and (to_char(creationdate,'yyyy') = to_char(now(),'yyyy'))"
                    + " and subType = '" + subType + "'"
                    + " and checkerId = " + currentUserId
                    + " order by updateDate desc)";
        }

        Class cls = null;
        try {
            cls = Class.forName(this.entityClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dao.findByNativeSql(sql, page, limit, cls);
    }

    /**
     * 试题审核结果批量处理
     *
     * @param entityIds
     * @param checkFlag
     * @param reason
     * @return
     */
    @Override
    @Transactional
    public JsonStatus batchAudit(String entityIds, String checkFlag, String reason) {

        JsonStatus jsonStatus = new JsonStatus();

        if (entityIds.isEmpty()) {
            jsonStatus.setSuccess(false);
            jsonStatus.setMsg("试题审核失败, 原因：entityIds 不能为空");
            return jsonStatus;
        }

        String[] ids = entityIds.split(",");
        for (int i = 0; i < ids.length; i++) {
            TP entity = (TP) this.dao.get(Long.parseLong(ids[i]));
            entity.setCheckFlag(checkFlag);
            entity.setCheckReason(reason);
            entity.setCheckerId(this.shiroService.getCurrentUserId());
            entity.setChecker(this.shiroService.getCurrentUserRealName());
            entity.setCheckDate(new Date());
            this.updateEntity(entity);
        }

        jsonStatus.setSuccess(true);
        jsonStatus.setMsg("试题审核成功");

        return jsonStatus;
    }

    /**
     * 试题排重比较相似度
     *
     * @return
     */
    @Override
    public JsonStatus compareAllSimilarity(String subType) {
        System.out.println("=====start");
        System.out.println(new Date());
        JsonStatus jsonStatus = new JsonStatus();
        try {
            String questionType = this.getQuestionType();
            String questionTypeName = this.getQuestionTypeName();
            String questionBeans = this.getQuestionBeans();
            String subTypeName = this.getSubTypeName(subType);
            System.out.println(questionTypeName + "-" + subTypeName);
            // 获取比对参数设置
            boolean compareStatus = this.getCompareStatus();
            if (compareStatus) {
                String msg = questionTypeName + "-" + subTypeName + "排重比对数据进行中,请等待!";
                System.out.println(msg);
                System.out.println(new Date());
                System.out.println("=====end");
                jsonStatus.setSuccess(false);
                jsonStatus.setMsg(msg);
                return jsonStatus;
            }
            // 修改比对参数设置，防止多次并发执行
            this.updateCompareStatus(1L, true);
            // 开始排重比对数据
            String sql = "";
            String sqlAll = "";
            if (StringUtils.isEmpty(subType)) {
                sql = "select t.* from " + dao.getTableName() + " t "
                        + " where t.delFlag = '0' and t.checkFlag <> '2' and t.compareFlag = '0'";
                sqlAll = "select t.* from " + dao.getTableName() + " t "
                        + " where t.delFlag = '0' and t.checkFlag <> '2'";
            } else {
                sql = "select t.* from " + dao.getTableName() + " t "
                        + " where t.delFlag = '0' and t.checkFlag <> '2' and t.compareFlag = '0'"
                        + " and t.subType = '" + subType + "'";
                sqlAll = "select t.* from " + dao.getTableName() + " t "
                        + " where t.delFlag = '0' and t.checkFlag <> '2'"
                        + " and t.subType = '" + subType + "'";
            }
            Class cls = null;
            try {
                cls = Class.forName(this.entityClassName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            List list = dao.findByNativeSql(sql, cls);
            List listAll = dao.findByNativeSql(sqlAll, cls);
            for (int i = 0; i < list.size(); i++) {
                TP firstEntity = (TP) list.get(i);
                long firstId = firstEntity.getId();
                String firstStem = firstEntity.getStem();
                for (int j = 0; j < listAll.size(); j++) {
                    TP secondEntity = (TP) listAll.get(j);
                    long secondId = secondEntity.getId();
                    if (firstId != secondId) {
                        String secondStem = secondEntity.getStem();
                        double result = Similarity.morphoSimilarity(firstStem, secondStem);
                        if (result > 0.7) {
                            String resultDesc = "词形词序句子相似度" + new DecimalFormat("0.0000").format(result);

                            QuestionRepeatedBean questionRepeatedBean = new QuestionRepeatedBean();
                            questionRepeatedBean.setQuestionType(questionType);
                            questionRepeatedBean.setQuestionTypeName(questionTypeName);
                            questionRepeatedBean.setQuestionBeans(questionBeans);
                            questionRepeatedBean.setSubType(subType);
                            questionRepeatedBean.setSubTypeName(subTypeName);
                            questionRepeatedBean.setFirstQuestionId(firstId);
                            questionRepeatedBean.setSecondQuestionId(secondId);
                            questionRepeatedBean.setSimilarity(result);
                            questionRepeatedBean.setSimilarityDesc(resultDesc);
                            questionRepeatedBeanService.saveSimilarity(questionRepeatedBean);
                        }
                    }
                    System.out.print(".");
                }
                this.updateCompareFlag(firstEntity.getId(), "1");
            }
            jsonStatus.setSuccess(true);
            // 比对成功，修改比对参数设置，可以进行下一次比对
            this.updateCompareStatus(1L, false);
        } catch (Exception e) {
            jsonStatus.setSuccess(false);
            jsonStatus.setMsg(e.getMessage());
        }
        System.out.println(new Date());
        System.out.println("=====end");
        return jsonStatus;
    }

    /**
     * 更新试题排重比较相似度结果状态（0未比较，1比较完成）
     *
     * @param id
     * @param compareFlag
     * @return
     */
    @Override
    @Transactional
    public int updateCompareFlag(Long id, String compareFlag) {
        String sql = "update " + this.dao.getTableName() + " set compareFlag = " + compareFlag + " where id = " + id;
        return this.dao.updateNativeQuery(sql);
    }

    /**
     * 新增或编辑题型数据时验证排重(前台需要传递题干)
     *
     * @param compareQuestionDTO
     * @return
     */
    @Override
    public JsonData validateRepeates(CompareQuestionDTO compareQuestionDTO) {
        JsonData jsonData = new JsonData();
        Long questionId = compareQuestionDTO.getQuestionId() == null ? 0 : compareQuestionDTO.getQuestionId();
        String stem = compareQuestionDTO.getStem();
        String subType = compareQuestionDTO.getSubType();
        String sql = "";
        if (StringUtils.isEmpty(subType)) {
            if (questionId > 0) {
                sql = "select t.* from " + dao.getTableName() + " t " +
                        " where t.delFlag = '0' and t.checkFlag <> '2' and t.id <> " + questionId;
            } else {
                sql = "select t.* from " + dao.getTableName() + " t " +
                        " where t.delFlag = '0' and t.checkFlag <> '2'";
            }
        } else {
            if (questionId > 0) {
                sql = "select t.* from " + dao.getTableName() + " t " +
                        " where t.delFlag = '0' and t.checkFlag <> '2' " +
                        " and t.subType = '" + subType + "' and t.id <> " + questionId;
            } else {
                sql = "select t.* from " + dao.getTableName() + " t " +
                        " where t.delFlag = '0' and t.checkFlag <> '2' " +
                        " and t.subType = '" + subType + "'";
            }
        }
        Class cls = null;
        try {
            cls = Class.forName(this.entityClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        List list = dao.findByNativeSql(sql, cls);
        double similarity = this.getSimilarity();
        List repeateList = this.doRepeat(stem, list, similarity);

        jsonData.setData(repeateList);
        jsonData.setTotalCount((long) repeateList.size());
        return jsonData;
    }

    /**
     * 保留重复
     *
     * @param questionId
     * @return
     */
    @Override
    @Transactional
    public JsonStatus doSaveRepeate(Long questionId) {
        JsonStatus jsonStatus = new JsonStatus();
        try {
            TP entity = (TP) this.dao.get(questionId);
            entity.setRepeatedFlag("1");
            entity.setUpdateBy(shiroService.getCurrentUserLoginName());
            entity.setUpdateById(shiroService.getCurrentUserId());
            this.dao.save(entity);
            jsonStatus.setSuccess(true);
            jsonStatus.setMsg("试题保留成功！");
        } catch (Exception e) {
            jsonStatus.setSuccess(false);
            jsonStatus.setMsg(e.getMessage());
        }
        return jsonStatus;
    }

    /**
     * 删除重复
     *
     * @param questionId
     * @return
     */
    @Override
    @Transactional
    public JsonStatus doDeleteRepeate(Long questionId) {
        JsonStatus jsonStatus = new JsonStatus();
        try {
            TP entity = (TP) this.dao.get(questionId);
            entity.setDelFlag("1");
            entity.setRepeatedFlag("1");
            entity.setUpdateBy(shiroService.getCurrentUserLoginName());
            entity.setUpdateById(shiroService.getCurrentUserId());
            this.dao.save(entity);
            jsonStatus.setSuccess(true);
            jsonStatus.setMsg("试题删除成功！");
        } catch (Exception e) {
            jsonStatus.setSuccess(false);
            jsonStatus.setMsg(e.getMessage());
        }
        return jsonStatus;
    }

    @Override
    public JsonStatus compareSingleSimilarity(Long questionId) {
        JsonStatus jsonStatus = new JsonStatus();
        // 获取比对参数设置
        boolean compareStatus = this.getCompareStatus();
        if (compareStatus) {
            String msg = "排重比对进行中,请等待!";
            jsonStatus.setSuccess(false);
            jsonStatus.setMsg(msg);
            return jsonStatus;
        }
        // 修改比对参数设置，防止多次并发执行
        this.updateCompareStatus(1L, true);
        // 开始排重比对数据
        TP entity = this.getEntity(questionId);
        this.compareSingleSimilarity(entity, jsonStatus);
        // 比对成功，修改比对参数设置，可以进行下一次比对
        this.updateCompareStatus(1L, false);
        return jsonStatus;
    }

    protected double getSimilarity() {
        double defaultSimilarity = 0.5d;
        QuestionSettingBean questionSettingBean = questionSettingBeanService.getEntity(1L);
        if (questionSettingBean != null) {
            defaultSimilarity = questionSettingBean.getSimilarity() == null ?
                    defaultSimilarity : questionSettingBean.getSimilarity().doubleValue();
        }
        return defaultSimilarity;
    }

    protected List doRepeat(String compareStem, List<TP> list, double similarity) {
        List rtn = new ArrayList<>();
        list.stream().parallel().forEach(n -> {
            String stem = n.getStem();
            // 词林相似度
            // double result = Similarity.cilinSimilarity(compareStem, stem);
            // 短语相似度
            // double result = Similarity.phraseSimilarity(compareStem, stem);
            // 词形词序句子相似度
            double result = Similarity.morphoSimilarity(compareStem, stem);
            System.out.print(".");
            // 优化的编辑距离句子相似度
            // double result = Similarity.editDistanceSimilarity(compareStem, stem);
            // 标准编辑距离句子相似度
            // double result = Similarity.standardEditDistanceSimilarity(compareStem, stem);
            // gregor编辑距离句子相似度
            // double result = Similarity.gregorEditDistanceSimilarity(compareStem, stem);
            // 拼音相似度
            // double result = Similarity.pinyinSimilarity(compareStem, stem);
            // 概念相似度
            // double result = Similarity.conceptSimilarity(compareStem, stem);
            // 字面相似度
            // double result = Similarity.charBasedSimilarity(compareStem, stem);
            // double result = 0.7;
            if (result > similarity) {
                String similarityDesc = "词形词序句子相似度" + new DecimalFormat("0.00").format(result);
                n.setSimilarity(result);
                n.setSimilarityDesc(similarityDesc);
                rtn.add(n);
            }
        });
//        for (int i = 0; i < list.size(); i++) {
//            TP entity = list.get(i);
//            String stem = entity.getStem();
//            // 词林相似度
//            // double result = Similarity.cilinSimilarity(compareStem, stem);
//            // 短语相似度
//            // double result = Similarity.phraseSimilarity(compareStem, stem);
//            // 词形词序句子相似度
//            double result = Similarity.morphoSimilarity(compareStem, stem);
//            // 优化的编辑距离句子相似度
//            // double result = Similarity.editDistanceSimilarity(compareStem, stem);
//            // 标准编辑距离句子相似度
//            // double result = Similarity.standardEditDistanceSimilarity(compareStem, stem);
//            // gregor编辑距离句子相似度
//            // double result = Similarity.gregorEditDistanceSimilarity(compareStem, stem);
//            // 拼音相似度
//            // double result = Similarity.pinyinSimilarity(compareStem, stem);
//            // 概念相似度
//            // double result = Similarity.conceptSimilarity(compareStem, stem);
//            // 字面相似度
//            // double result = Similarity.charBasedSimilarity(compareStem, stem);
//            // double result = 0.7;
//            if (result > similarity) {
//                String similarityDesc = "词形词序句子相似度" + new DecimalFormat("0.00").format(result);
//                entity.setSimilarity(result);
//                entity.setSimilarityDesc(similarityDesc);
//                rtn.add(entity);
//            }
//        }
        // 排序
        Collections.sort(rtn, new Comparator<TP>() {
            public int compare(TP p1, TP p2) {
                if (p1.getSimilarity() > p2.getSimilarity()) {
                    return 1;
                }
                if (p1.getSimilarity() == p2.getSimilarity()) {
                    return 0;
                }
                return -1;
            }
        });
        return rtn;
    }

    protected void compareSingleSimilarity(TP entity, JsonStatus jsonStatus) {
        System.out.println("=====start");
        System.out.println(new Date());
        try {
            String subType = entity.getSubType();
            String questionType = this.getQuestionType();
            String questionTypeName = this.getQuestionTypeName();
            String questionBeans = this.getQuestionBeans();
            String subTypeName = this.getSubTypeName(subType);
            // 开始排重比对数据
            String sqlAll = "";
            if (StringUtils.isEmpty(subType)) {
                sqlAll = "select t.* from " + dao.getTableName() + " t "
                        + " where t.delFlag = '0' and t.checkFlag <> '2' and id <>" + entity.getId();
            } else {
                sqlAll = "select t.* from " + dao.getTableName() + " t "
                        + " where t.delFlag = '0' and t.checkFlag <> '2'"
                        + " and t.subType = '" + subType + "' and id <>" + entity.getId();
            }
            Class cls = null;
            try {
                cls = Class.forName(this.entityClassName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            List listAll = dao.findByNativeSql(sqlAll, cls);
            long firstId = entity.getId();
            String firstStem = entity.getStem();
            for (int j = 0; j < listAll.size(); j++) {
                TP secondEntity = (TP) listAll.get(j);
                long secondId = secondEntity.getId();
                String secondStem = secondEntity.getStem();
                double result = Similarity.morphoSimilarity(firstStem, secondStem);
                if (result > 0.7) {
                    String resultDesc = "词形词序句子相似度" + new DecimalFormat("0.0000").format(result);

                    QuestionRepeatedBean questionRepeatedBean = new QuestionRepeatedBean();
                    questionRepeatedBean.setQuestionType(questionType);
                    questionRepeatedBean.setQuestionTypeName(questionTypeName);
                    questionRepeatedBean.setQuestionBeans(questionBeans);
                    questionRepeatedBean.setSubType(subType);
                    questionRepeatedBean.setSubTypeName(subTypeName);
                    questionRepeatedBean.setFirstQuestionId(firstId);
                    questionRepeatedBean.setSecondQuestionId(secondId);
                    questionRepeatedBean.setSimilarity(result);
                    questionRepeatedBean.setSimilarityDesc(resultDesc);
                    questionRepeatedBeanService.saveSimilarity(questionRepeatedBean);
                }
                System.out.print(".");
            }
            this.updateCompareFlag(entity.getId(), "1");
            jsonStatus.setSuccess(true);
        } catch (Exception e) {
            jsonStatus.setSuccess(false);
            jsonStatus.setMsg(e.getMessage());
        }
        System.out.println(new Date());
        System.out.println("=====end");
    }

    /**
     * 生成题库单项题型预览结果
     *
     * @param tempMap
     * @param subType
     * @return
     */
    protected String createSinglePreview(Map tempMap, String subType) {

        String htmlStr = "";

        Configuration configuration = new Configuration();

        // dataMap 要填入模本的数据文件
        // 设置模本装置方法和路径,
        Template t = null;
        try {
            String realPath = (String) ConfigUtil.getConfigProp("word.review.realpath", "ConfigOpenOffice");
            if (realPath.charAt(realPath.length() - 1) != '/') {
                realPath += "/";
            }
            String reviewBaseDir = realPath + "reviewfiles";
            String ftlPath = reviewBaseDir + "/ftl";
            initReviewDir(reviewBaseDir, "ftl", "");
            configuration.setDirectoryForTemplateLoading(new File(ftlPath));
            // 获取要装载的模板
            String fileName = this.getTempName(subType);
            t = configuration.getTemplate(fileName, "utf-8");
            StringWriter stringWriter = new StringWriter();
            BufferedWriter writer = new BufferedWriter(stringWriter);
            t.setEncoding("UTF-8");
            t.process(tempMap, writer);
            htmlStr = stringWriter.toString();

            writer.flush();
            writer.close();

        } catch (Exception e) {
            //logger.error("导出出错", e);
            e.printStackTrace();
            // throw new BusinessException(CommonResultEnum.COMMON_ERROR_637);
        }
        return htmlStr;
    }

    /**
     * 初始化预览文件夹
     * 不存在则创建文件夹
     *
     * @param reviewBaseDir
     * @param fileTypeFolder
     * @param folderName
     * @return
     */
    private void initReviewDir(String reviewBaseDir, String fileTypeFolder, String folderName) {
        String fileTypePath = reviewBaseDir + "/" + fileTypeFolder;
        String filePath = "";
        if (folderName.equals("")) {
            filePath = fileTypePath;
        } else {
            filePath = fileTypePath + "/" + folderName;
        }
        File fileBaseDir = new File(reviewBaseDir);
        if (!fileBaseDir.exists()) {
            fileBaseDir.mkdir();
        }
        File fileTypeDir = new File(fileTypePath);
        if (!fileTypeDir.exists()) {
            fileTypeDir.mkdir();
        }
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    public void setEnrolmentDictBeanService(IEnrolmentDictBeanService enrolmentDictBeanService) {
        this.enrolmentDictBeanService = enrolmentDictBeanService;
    }

    public void setRoleBeanService(IRoleBeanService roleBeanService) {
        this.roleBeanService = roleBeanService;
    }

    public void setQuestionSettingBeanService(IQuestionSettingBeanService questionSettingBeanService) {
        this.questionSettingBeanService = questionSettingBeanService;
    }

    public void setQuestionRepeatedBeanService(IQuestionRepeatedBeanService questionRepeatedBeanService) {
        this.questionRepeatedBeanService = questionRepeatedBeanService;
    }

    @Override
    public JsonData getRepeates(String jsonStr, boolean isAll) {
        System.out.println("=====start");
        System.out.println("=====isall:" + isAll);
        System.out.println(new Date().toString());
        JsonData jsonData = new JsonData();
        try {
            if (StringUtils.isEmpty(jsonStr)) {
                return jsonData;
            }
            Map queryMap = SerializeUtil.json2Map(jsonStr);
            String questionType = (String) queryMap.get("questionType");
            if (StringUtils.isEmpty(questionType)) {
                return jsonData;
            }

            List<RepeatedCountDTO> repeateList = new ArrayList<RepeatedCountDTO>();
            String questionTypeName = this.getQuestionTypeName();
            String questionBeans = this.getQuestionBeans();
            String subTypeName = "";
            String subTypeDictType = this.getSubTypeDictType();
            String subType = "";
            String sql = "";
            String sqlAll = "";
            Class cls = Class.forName(this.entityClassName);
            double similarity = this.getSimilarity();
            if (StringUtils.isEmpty(subTypeDictType)) {
                sql = "select t.* from " + dao.getTableName() + " t "
                        + " where t.delFlag = '0' and t.repeatedFlag = '0' and t.checkFlag <> '2'";
                sqlAll = "select t.* from " + dao.getTableName() + " t "
                        + " where t.delFlag = '0' and t.checkFlag <> '2'";
                List<TP> list = dao.findByNativeSql(sql, cls);
                List<TP> referenceList = dao.findByNativeSql(sqlAll, cls);

                int count = 0; // 记录比对重复结果个数
                for (int i = 0; i < list.size(); i++) {
                    RepeatedCountDTO repeatedCountDTO = new RepeatedCountDTO();
                    TP entity = (TP) list.get(i);
                    System.out.println(i + "id:=" + entity.getId());
                    List<BaseQuestionDTO> dtoList = this.doRepeat(entity, referenceList, similarity, subType);
                    if (dtoList != null && dtoList.size() > 0) { // 有重复
                        BaseQuestionDTO baseQuestionDTO = new BaseQuestionDTO();
                        baseQuestionDTO.setQuestionId(entity.getId());
                        baseQuestionDTO.setStem(entity.getStem());
                        baseQuestionDTO.setSimilarity("");

                        baseQuestionDTO.setQuestionType(questionType);
                        baseQuestionDTO.setQuestionTypeName(questionTypeName);
                        baseQuestionDTO.setQuestionBeans(questionBeans);
                        baseQuestionDTO.setSubType(subType);
                        baseQuestionDTO.setSubTypeName(subTypeName);

                        baseQuestionDTO.setAnalysis(entity.getAnalysis());
                        baseQuestionDTO.setCheckFlag(entity.getCheckFlag());
                        baseQuestionDTO.setCheckerId(entity.getCheckerId());
                        baseQuestionDTO.setChecker(entity.getChecker());
                        baseQuestionDTO.setCheckDate(entity.getCheckDate());
                        baseQuestionDTO.setCreateBy(entity.getCreateBy());
                        baseQuestionDTO.setCreationDate(entity.getCreationDate());
                        dtoList.add(0, baseQuestionDTO);
                        count++;

                        String name = questionTypeName + "题目" + count;
                        repeatedCountDTO.setName(name);
                        repeatedCountDTO.setRepeateList(dtoList);
                        repeateList.add(repeatedCountDTO);
                    }
                    if (!isAll) {
                        if (count >= MAX_REPEATED_RECORD) {
                            break;
                        }
                    }
                }
            } else {
                List<EnrolmentDictBean> subDictBeans = enrolmentDictBeanService.getDictBeanByType(subTypeDictType);
                for (int n = 0; n < subDictBeans.size(); n++) {
                    EnrolmentDictBean subDictBean = subDictBeans.get(n);
                    subType = subDictBean.getValue();
                    subTypeName = subDictBean.getLabel();
                    sql = "select t.* from " + dao.getTableName() + " t "
                            + " where t.delFlag = '0' and t.repeatedFlag = '0' and t.checkFlag <> '2'"
                            + " and t.subType = '" + subType + "'";
                    sqlAll = "select t.* from " + dao.getTableName() + " t "
                            + " where t.delFlag = '0' and t.checkFlag <> '2'"
                            + " and t.subType = '" + subType + "'";
                    List<TP> list = dao.findByNativeSql(sql, cls);
                    List<TP> referenceList = dao.findByNativeSql(sqlAll, cls);

                    int count = 0; // 记录比对重复结果个数
                    for (int i = 0; i < list.size(); i++) {
                        RepeatedCountDTO repeatedCountDTO = new RepeatedCountDTO();
                        TP entity = (TP) list.get(i);
                        System.out.println(i + "id:=" + entity.getId());
                        List<BaseQuestionDTO> dtoList = this.doRepeat(entity, referenceList, similarity, subType);
                        if (dtoList != null && dtoList.size() > 0) { // 有重复
                            BaseQuestionDTO baseQuestionDTO = new BaseQuestionDTO();
                            baseQuestionDTO.setQuestionId(entity.getId());
                            baseQuestionDTO.setStem(entity.getStem());
                            baseQuestionDTO.setSimilarity("");

                            baseQuestionDTO.setQuestionType(questionType);
                            baseQuestionDTO.setQuestionTypeName(questionTypeName);
                            baseQuestionDTO.setQuestionBeans(questionBeans);
                            baseQuestionDTO.setSubType(subType);
                            baseQuestionDTO.setSubTypeName(subTypeName);

                            baseQuestionDTO.setAnalysis(entity.getAnalysis());
                            baseQuestionDTO.setCheckFlag(entity.getCheckFlag());
                            baseQuestionDTO.setCheckerId(entity.getCheckerId());
                            baseQuestionDTO.setChecker(entity.getChecker());
                            baseQuestionDTO.setCheckDate(entity.getCheckDate());
                            baseQuestionDTO.setCreateBy(entity.getCreateBy());
                            baseQuestionDTO.setCreationDate(entity.getCreationDate());
                            dtoList.add(0, baseQuestionDTO);
                            count++;

                            String name = questionTypeName + "-" + subTypeName + "题目" + count;
                            repeatedCountDTO.setName(name);
                            repeatedCountDTO.setRepeateList(dtoList);
                            repeateList.add(repeatedCountDTO);
                        }
                        if (!isAll) {
                            if (count >= MAX_REPEATED_RECORD) {
                                break;
                            }
                        }
                    }
                }
            }
            jsonData.setData(repeateList);
            jsonData.setTotalCount((long) repeateList.size());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(new Date().toString());
        System.out.println("=====end");
        return jsonData;
    }

    @Override
    public JsonData getRepeates(Long questionId) {
        JsonData jsonData = new JsonData();
        List<BaseQuestionDTO> list = new ArrayList<BaseQuestionDTO>();
        if (questionId == null || questionId < 1) {
            return jsonData;
        }
        try {
            TP entity = (TP) this.dao.get(questionId);
            String subType = entity.getSubType();

            Class cls = null;
            try {
                cls = Class.forName(this.entityClassName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            String sql = "";
            if (StringUtils.isEmpty(subType)) {
                sql = "select t.* from " + dao.getTableName() + " t "
                        + " where t.delFlag = '0' and t.checkFlag <> '2' and t.id <> " + entity.getId();
            } else {
                sql = "select t.* from " + dao.getTableName() + " t "
                        + " where t.delFlag = '0' and t.checkFlag <> '2' and t.subType = '" + subType + "' and t.id <> " + entity.getId();
            }
            List result = dao.findByNativeSql(sql, cls);
            List<TP> referenceList = new ArrayList<TP>();
            referenceList.addAll(result);

            double similarity = this.getSimilarity();
            list = this.doRepeat(entity, referenceList, similarity, subType);

            jsonData.setData(list);
            jsonData.setTotalCount((long) list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonData;
    }

    private List doRepeat(TP entity, List<TP> list, double similarity, String subType) {
        long id = entity.getId();
        String stem = entity.getStem();
        String questionType = this.getQuestionType();
        String questionTypeName = this.getQuestionTypeName();
        String questionBeans = this.getQuestionBeans();
        String subTypeName = this.getSubTypeName(subType);
        List<BaseQuestionDTO> dtoList = new ArrayList<BaseQuestionDTO>();
        list.stream().parallel().filter(n -> n.getId() != id).forEach(questionEntity -> {
            long questionId = questionEntity.getId();
            String questionStem = questionEntity.getStem();
            // 词林相似度
            // double result = Similarity.cilinSimilarity(stem, questionStem);
            // 短语相似度
            // double result = Similarity.phraseSimilarity(stem, questionStem);
            // 词形词序句子相似度
            System.out.print(".");
            double result = Similarity.morphoSimilarity(stem, questionStem);
            System.out.print(".");
            // 优化的编辑距离句子相似度
            // double result = Similarity.editDistanceSimilarity(stem, questionStem);
            // 标准编辑距离句子相似度
            // double result = Similarity.standardEditDistanceSimilarity(stem, questionStem);
            // gregor编辑距离句子相似度
            // double result = Similarity.gregorEditDistanceSimilarity(stem, questionStem);
            // 拼音相似度
            // double result = Similarity.pinyinSimilarity(stem, questionStem);
            // 概念相似度
            // double result = Similarity.conceptSimilarity(stem, questionStem);
            // 字面相似度
            // double result = Similarity.charBasedSimilarity(stem, questionStem);
            // double result = 0.7;
            if (result > similarity) {
                BaseQuestionDTO baseQuestionDTO = new BaseQuestionDTO();
                baseQuestionDTO.setQuestionId(questionId);
                baseQuestionDTO.setStem(questionStem);
                // baseQuestionDTO.setSimilarity("词林相似度" + new DecimalFormat("0.00").format(result));
                baseQuestionDTO.setSimilarity("词形词序句子相似度" + new DecimalFormat("0.00").format(result));

                baseQuestionDTO.setQuestionType(questionType);
                baseQuestionDTO.setQuestionTypeName(questionTypeName);
                baseQuestionDTO.setQuestionBeans(questionBeans);
                baseQuestionDTO.setSubType(subType);
                baseQuestionDTO.setSubTypeName(subTypeName);

                baseQuestionDTO.setAnalysis(questionEntity.getAnalysis());
                baseQuestionDTO.setCheckFlag(questionEntity.getCheckFlag());
                baseQuestionDTO.setCheckerId(questionEntity.getCheckerId());
                baseQuestionDTO.setChecker(questionEntity.getChecker());
                baseQuestionDTO.setCheckDate(questionEntity.getCheckDate());
                baseQuestionDTO.setCreateBy(questionEntity.getCreateBy());
                baseQuestionDTO.setCreationDate(questionEntity.getCreationDate());
                baseQuestionDTO.setRepeatedFlag(questionEntity.getRepeatedFlag());

                dtoList.add(baseQuestionDTO);
            }
        });
//        for (int i = 0; i < list.size(); i++) {
//            TP questionEntity = list.get(i);
//            long questionId = questionEntity.getId();
//            if (questionId != id) {
//                String questionStem = questionEntity.getStem();
//                // 词林相似度
//                // double result = Similarity.cilinSimilarity(stem, questionStem);
//                // 短语相似度
//                // double result = Similarity.phraseSimilarity(stem, questionStem);
//                // 词形词序句子相似度
//                double result = Similarity.morphoSimilarity(stem, questionStem);
//                // 优化的编辑距离句子相似度
//                // double result = Similarity.editDistanceSimilarity(stem, questionStem);
//                // 标准编辑距离句子相似度
//                // double result = Similarity.standardEditDistanceSimilarity(stem, questionStem);
//                // gregor编辑距离句子相似度
//                // double result = Similarity.gregorEditDistanceSimilarity(stem, questionStem);
//                // 拼音相似度
//                // double result = Similarity.pinyinSimilarity(stem, questionStem);
//                // 概念相似度
//                // double result = Similarity.conceptSimilarity(stem, questionStem);
//                // 字面相似度
//                // double result = Similarity.charBasedSimilarity(stem, questionStem);
//                // double result = 0.7;
//                if (result > similarity) {
//                    BaseQuestionDTO baseQuestionDTO = new BaseQuestionDTO();
//                    baseQuestionDTO.setQuestionId(questionId);
//                    baseQuestionDTO.setStem(questionStem);
//                    // baseQuestionDTO.setSimilarity("词林相似度" + new DecimalFormat("0.00").format(result));
//                    baseQuestionDTO.setSimilarity("词形词序句子相似度" + new DecimalFormat("0.00").format(result));
//
//                    baseQuestionDTO.setQuestionType(questionType);
//                    baseQuestionDTO.setQuestionTypeName(questionTypeName);
//                    baseQuestionDTO.setQuestionBeans(questionBeans);
//                    baseQuestionDTO.setSubType(subType);
//                    baseQuestionDTO.setSubTypeName(subTypeName);
//
//                    baseQuestionDTO.setAnalysis(questionEntity.getAnalysis());
//                    baseQuestionDTO.setCheckFlag(questionEntity.getCheckFlag());
//                    baseQuestionDTO.setCheckerId(questionEntity.getCheckerId());
//                    baseQuestionDTO.setChecker(questionEntity.getChecker());
//                    baseQuestionDTO.setCheckDate(questionEntity.getCheckDate());
//                    baseQuestionDTO.setCreateBy(questionEntity.getCreateBy());
//                    baseQuestionDTO.setCreationDate(questionEntity.getCreationDate());
//
//                    dtoList.add(baseQuestionDTO);
//                }
//            }
//        }
        // 排序
//        Collections.sort(dtoList, new Comparator<BaseQuestionDTO>(){
//            public int compare(BaseQuestionDTO p1, BaseQuestionDTO p2) {
//                if(p1.getSimilarity() > p2.getSimilarity()){
//                    return 1;
//                }
//                if(p1.getAge() == p2.getAge()){
//                    return 0;
//                }
//                return -1;
//            }
//        });
        return dtoList;
    }
}
