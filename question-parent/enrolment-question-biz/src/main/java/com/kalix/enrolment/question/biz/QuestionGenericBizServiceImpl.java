package com.kalix.enrolment.question.biz;

import com.kalix.admin.core.api.biz.IRoleBeanService;
import com.kalix.admin.core.entities.RoleBean;
import com.kalix.admin.duty.api.biz.IDataAuthBeanService;
import com.kalix.admin.duty.entities.DataAuthBean;
import com.kalix.enrolment.question.api.biz.*;
import com.kalix.enrolment.question.api.dao.IQuestionRepeatedBeanDao;
import com.kalix.enrolment.question.dto.model.CompareQuestionDTO;
import com.kalix.enrolment.question.dto.model.QuestionAuditDTO;
import com.kalix.enrolment.question.dto.model.QuestionDTO;
import com.kalix.enrolment.question.dto.model.RepeatedTestingDTO;
import com.kalix.enrolment.question.entities.BaseQuestionEntity;
import com.kalix.enrolment.question.entities.QuestionRepeatedBean;
import com.kalix.enrolment.question.entities.QuestionSettingBean;
import com.kalix.enrolment.system.dict.api.biz.IEnrolmentDictBeanService;
import com.kalix.enrolment.system.dict.entities.EnrolmentDictBean;
import com.kalix.framework.core.api.dao.IGenericDao;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.api.security.model.EnumDataAuth;
import com.kalix.framework.core.api.web.model.QueryDTO;
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
    protected static String DICT_TYPE = "类别";
    protected IEnrolmentDictBeanService enrolmentDictBeanService;
    protected IRoleBeanService roleBeanService;
    protected IQuestionSettingBeanService questionSettingBeanService;
    protected IQuestionRepeatedBeanDao questionRepeatedBeanDao;
    protected IQuestionRepeatedBeanService questionRepeatedBeanService;
    protected IDataAuthBeanService dataAuthBeanService;

    protected static double DEFAULT_SIMILARITY = 0.7;

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
     * 重写试题数据权限
     *
     * @param queryDTO
     * @return
     */
    @Override
    public QueryDTO addDataAuthQueryDTO(QueryDTO queryDTO) {
        try {
            Map<String, String> jsonMap = queryDTO.getJsonMap();
            if (jsonMap == null) {
                jsonMap = new HashMap<String, String>();
            }
            // 增加数据权限,默认为只能查看自己建立的数据
            EnumDataAuth enumDataAuth = EnumDataAuth.SELF;
            Long userId = shiroService.getCurrentUserId();
            // 根据appName查询具体的数据权限
            String appName = "enrolment";
            String menuIdToLower = "completionMenu";
            DataAuthBean authBean = dataAuthBeanService.getDataAuthBean(userId, appName, menuIdToLower);
            if (authBean == null) {
                enumDataAuth = EnumDataAuth.SELF;
            } else {
                enumDataAuth = EnumDataAuth.values()[authBean.getType()];
            }
            switch (enumDataAuth) {
                // 本人数据
                case SELF:
                    jsonMap.put("createById", String.valueOf(userId));
                    break;
                // 所有数据
                case ALL:
                    break;
            }
            queryDTO.setJsonMap(jsonMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return queryDTO;
    }

    /**
     * 单条试题新增保存成功后，进行排重比对
     *
     * @param entity
     * @param status
     */
    @Override
    public void afterSaveEntity(TP entity, JsonStatus status) {
        super.afterSaveEntity(entity, status);
        String questionType = this.getQuestionType();
        String subType = entity.getSubType();
        if (!(questionType.equals("6") && subType.equals("1")))
            this.compareSingleSimilarity(entity, status);
    }

    /**
     * 单条试题编辑保存成功前，进行排重比对
     *
     * @param entity
     * @param status
     */
    @Override
    public void beforeUpdateEntity(TP entity, JsonStatus status) {
        super.beforeUpdateEntity(entity, status);
        TP oldEntity = this.getEntity(entity.getId());
        // 改变题干需要进行比对
        if (!oldEntity.getStem().equals(entity.getStem())) {
            String questionType = this.getQuestionType();
            String subType = entity.getSubType();
            if (!(questionType.equals("6") && subType.equals("1")))
                this.compareSingleSimilarity(entity, status);
        }
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
     * 获取题型类型名称
     *
     * @param type
     * @return
     */
    @Override
    public String getTypeName(String type) {
        String typeName = "";
        if (StringUtils.isEmpty(type)) {
            typeName = "";
        } else {
            EnrolmentDictBean enrolmentDictBean = enrolmentDictBeanService.getDictBeanByTypeAndValue(DICT_TYPE, type);
            typeName = enrolmentDictBean.getLabel();
        }
        return typeName;
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
     * 获取试题审核角色名称
     *
     * @param type
     * @param subType
     * @return
     */
    @Override
    public String getAuditRoleName(String type, String subType) {
        String auditRoleName = "";
        if (!StringUtils.isEmpty(type)) {
            auditRoleName = this.getTypeName(type);
        }

        auditRoleName += this.getAuditRoleName(subType);

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
    public JsonData getAllAuditEntityByQuery(Integer page, Integer limit, String jsonStr, String subType) {
        Map queryMap = SerializeUtil.json2Map(jsonStr);
        String type = (String) queryMap.get("type");

        String questionType = this.getQuestionType();
        if (questionType.equals("1") || questionType.equals("2")) {
            if (StringUtils.isEmpty(type)) {
                return new JsonData();
            }
        }

        String appendType = "";
        if (!StringUtils.isEmpty(type)) {
            appendType = " and type = '" + type + "'";
        }

        // 获取审核人角色名称
        // String roleName = this.getAuditRoleName(subType);
        // 获取审核人角色名称
        String roleName = this.getAuditRoleName(type, subType);

        // 获取当前登录人ID
        Long currentUserId = this.shiroService.getCurrentUserId();
        // 1.该类型试题未审核总数
        int total = 0;
        String countSql = "";

        if (StringUtils.isEmpty(subType)) {
            countSql = "select count(1) from " + dao.getTableName()
                    + " where delFlag = '0'"
                    + " and checkFlag = '0'"
                    + appendType
                    + " and (to_char(creationdate,'yyyy') = to_char(now(),'yyyy'))";
        } else {
            countSql = "select count(1) from " + dao.getTableName()
                    + " where delFlag = '0'"
                    + " and checkFlag = '0'"
                    + appendType
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

        if (perCnt == 0) {
            offset = 0;
            perCnt = 1;
        }

        // 6.分配未审核试题并查询分配结果（包括已经审核试题）
        String sql = "";
        if (StringUtils.isEmpty(subType)) {
            sql = "(select * from " + dao.getTableName()
                    + " where delFlag = '0' and checkFlag = '0'"
                    + appendType
                    + " and (to_char(creationdate,'yyyy') = to_char(now(),'yyyy'))"
                    + " order by updateDate desc limit " + perCnt + " offset " + offset
                    + ") union all ("
                    + "select * from " + dao.getTableName()
                    + " where delFlag = '0' and checkFlag != '0'"
                    + appendType
                    + " and (to_char(creationdate,'yyyy') = to_char(now(),'yyyy'))"
                    + " and checkerId = " + currentUserId
                    + " order by updateDate desc)";
        } else {
            sql = "(select * from " + dao.getTableName()
                    + " where delFlag = '0' and checkFlag = '0'"
                    + appendType
                    + " and (to_char(creationdate,'yyyy') = to_char(now(),'yyyy'))"
                    + " and subType = '" + subType + "'"
                    + " order by updateDate desc limit " + perCnt + " offset " + offset
                    + ") union all ("
                    + "select * from " + dao.getTableName()
                    + " where delFlag = '0' and checkFlag != '0'"
                    + appendType
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
     * 获取审核进度信息
     * @return
     */
    @Override
    public QuestionAuditDTO getAuditProgress(String jsonStr) {
        QuestionAuditDTO questionAuditDTO = new QuestionAuditDTO();
        Map queryMap = SerializeUtil.json2Map(jsonStr);
        String type = (String) queryMap.get("type");
        String subType = (String) queryMap.get("subType");

        String questionType = this.getQuestionType();
        if (questionType.equals("1") || questionType.equals("2")) {
            if (StringUtils.isEmpty(type)) {
                return questionAuditDTO;
            }
        }

        String appendType = "";
        if (!StringUtils.isEmpty(type)) {
            appendType = " and type = '" + type + "'";
        }

        // ----------审核人数量
        // 获取审核人角色名称
        String roleName = this.getAuditRoleName(type, subType);
        // 获取当前登录人ID
        Long currentUserId = this.shiroService.getCurrentUserId();
        // 根据该试题的角色查找审核该试题的人员
        int persons = 0;
        List userIdList = new ArrayList();
        RoleBean roleBean = roleBeanService.queryByRoleName(roleName);
        if (roleBean != null) {
            userIdList = roleBeanService.getUserIdsByRoleId(roleBean.getId());
            persons = userIdList.size();
        }
        // 判断当前登录人是否是审核人
        if (!userIdList.contains(currentUserId)) {
            return questionAuditDTO;
        }
        questionAuditDTO.setAuditorNum(persons);

        String questionNumSql = "";
        String completNumSql = "";
        String completTotalSql = "";
        if (StringUtils.isEmpty(subType)) {
            questionNumSql = "select count(1) from " + dao.getTableName()
                    + " where delFlag = '0'"
                    + appendType
                    + " and (to_char(creationdate,'yyyy') = to_char(now(),'yyyy'))";
            completNumSql = "select count(1) from " + dao.getTableName()
                    + " where delFlag = '0' and checkFlag != '0'"
                    + appendType
                    + " and (to_char(creationdate,'yyyy') = to_char(now(),'yyyy'))"
                    + " and checkerId = " + currentUserId;
            completTotalSql = "select count(1) from " + dao.getTableName()
                    + " where delFlag = '0' and checkFlag != '0'"
                    + appendType
                    + " and (to_char(creationdate,'yyyy') = to_char(now(),'yyyy'))";
        } else {
            questionNumSql = "select count(1) from " + dao.getTableName()
                    + " where delFlag = '0'"
                    + appendType
                    + " and (to_char(creationdate,'yyyy') = to_char(now(),'yyyy'))"
                    + " and subType = '" + subType + "'";
            completNumSql = "select count(1) from " + dao.getTableName()
                    + " where delFlag = '0' and checkFlag != '0'"
                    + appendType
                    + " and (to_char(creationdate,'yyyy') = to_char(now(),'yyyy'))"
                    + " and subType = '" + subType + "'"
                    + " and checkerId = " + currentUserId;
            completTotalSql = "select count(1) from " + dao.getTableName()
                    + " where delFlag = '0' and checkFlag != '0'"
                    + appendType
                    + " and (to_char(creationdate,'yyyy') = to_char(now(),'yyyy'))"
                    + " and subType = '" + subType + "'";
        }

        // ----------审核试题数量
        int questionNum = 0;
        List list = dao.findByNativeSql(questionNumSql, Integer.class);
        if (list != null && list.get(0) != null) {
            questionNum = (Integer) list.get(0);
        }
        questionAuditDTO.setQuestionNum(questionNum);

        // ----------审核完成数量
        int completNum = 0;
        list = dao.findByNativeSql(completNumSql, Integer.class);
        if (list != null && list.get(0) != null) {
            completNum = (Integer) list.get(0);
        }
        questionAuditDTO.setCompleteNum(completNum);

        // ----------审核完成总量
        int completTotal = 0;
        list = dao.findByNativeSql(completTotalSql, Integer.class);
        if (list != null && list.get(0) != null) {
            completTotal = (Integer) list.get(0);
        }
        questionAuditDTO.setCompleteTotal(completTotal);

        return questionAuditDTO;
    }

    /**
     * 试题排重比较相似度
     *
     * @return
     */
    @Override
    public JsonStatus compareAllSimilarity(String subType) {
        long sss = System.currentTimeMillis();
        System.out.println("=====start===" + new Date() + "=====" + sss);
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
                System.out.println("=====end====" + new Date() + "====" + msg);
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
            List<TP> listAll = dao.findByNativeSql(sqlAll, cls);
            // 是否需要排重，默认1无重复
            final String[] repeatedFlag = {"1"};
            double similarity = this.getSimilarity();
            for (int i = 0; i < list.size(); i++) {
                repeatedFlag[0] = "1";
                TP firstEntity = (TP) list.get(i);
                long firstId = firstEntity.getId();
                String firstStem = firstEntity.getStem();
                List<QuestionRepeatedBean> rtn = new ArrayList<QuestionRepeatedBean>();

                listAll.stream().parallel().filter(n -> n.getId() != firstId).forEach(secondEntity -> {
                    long secondId = secondEntity.getId();
                    String secondStem = secondEntity.getStem();
                    long sss1 = System.currentTimeMillis();
                    double result = Similarity.morphoSimilarity(firstStem, secondStem);
                    long sss2 = System.currentTimeMillis() - sss1;
                    System.out.print("===compare===" + sss2);
                    if (result > DEFAULT_SIMILARITY) {
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
                        rtn.add(questionRepeatedBean);
                        if (result > similarity) {
                            repeatedFlag[0] = "0";
                        }
                    }
                });
                for (int j = 0; j < rtn.size(); j++) {
                    QuestionRepeatedBean questionRepeatedBean = rtn.get(j);
                    questionRepeatedBeanService.saveSimilarity(questionRepeatedBean);
                }
                this.updateCompareFlag(firstEntity.getId(), "1", repeatedFlag[0]);
            }
            jsonStatus.setSuccess(true);
            // 比对成功，修改比对参数设置，可以进行下一次比对
            this.updateCompareStatus(1L, false);
        } catch (Exception e) {
            e.printStackTrace();
            jsonStatus.setSuccess(false);
            jsonStatus.setMsg(e.getMessage());
        }
        System.out.println("=====end=====" + new Date());
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
    public int updateCompareFlag(Long id, String compareFlag, String repeatedFlag) {
        String sql = "update " + this.dao.getTableName() + " set compareFlag = '" +
                compareFlag + "', repeatedFlag = '" + repeatedFlag + "' where id = " + id;
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
            entity.setOpFlag("1");
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
            entity.setOpFlag("2");
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

    /**
     * 查询试题排重比对情况
     *
     * @param page
     * @param limit
     * @param jsonStr
     * @param sort
     * @return
     */
    @Override
    public JsonData getAllQuestionRepeateds(Integer page, Integer limit, String jsonStr, String sort) {
        JsonData jsonData = new JsonData();
        try {
            Map queryMap = SerializeUtil.json2Map(jsonStr);
            String similarity = (String) queryMap.get("similarity");
            if (StringUtils.isEmpty(similarity)) {
                return jsonData;
            }
            String subType = (String) queryMap.get("subType");
            String type = (String) queryMap.get("type");
            StringBuilder whereStrB = new StringBuilder();
            if (StringUtils.isNotEmpty(subType)) {
                whereStrB.append(" and y.subtype = '" + subType + "' ");
            }
            if (StringUtils.isNotEmpty(type)) {
                whereStrB.append(" and y.type = '" + type + "' ");
            }
            String questionType = this.getQuestionType();
            /*String sql = "select y.* from " + this.dao.getTableName() + " y " +
                    " where y.id in (select distinct r.firstquestionid from " + this.questionRepeatedBeanDao.getTableName() + " r " +
                    " where r.questiontype = '" + questionType + "' and r.similarity > " + similarity + ") " +
                    " order by y.subType, y.id";
            Class cls = null;
            try {
                cls = Class.forName(this.entityClassName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            jsonData = this.dao.findByNativeSql(sql, page, limit, cls);*/
            String questionTypeName = this.getQuestionTypeName();
            String questionBeans = this.getQuestionBeans();
            String subTypeDictType = this.getSubTypeDictType();
            StringBuilder sqlStrB = new StringBuilder();
            String selectStr = "select '" + questionType + "' as questiontype, '" + questionTypeName +
                    "' as questiontypename, '" + questionBeans + "' as questionbeans, y.subtype, y.id, y.id as questionId, " +
                    " y.stem, y.analysis, y.checkflag, y.checkerid, y.checker, y.checkdate, y.checkreason, y.repeatedflag, " +
                    " y.delflag, y.reason, y.compareFlag, y.createby, y.creationdate, y.updateby, y.updatedate, " +
                    " d.label as typename ";
            sqlStrB.append(selectStr);
            if (StringUtils.isNotEmpty(subTypeDictType)) {
                sqlStrB.append(", d2.label as subtypename ");
            }
            sqlStrB.append("from " + this.dao.getTableName() + " y ");
            sqlStrB.append("left join enrolment_dict d on d.type = '" + DICT_TYPE + "' and d.value = y.type ");
            if (StringUtils.isNotEmpty(subTypeDictType)) {
                sqlStrB.append("left join enrolment_dict d2 on d2.type = '" + subTypeDictType + "' and d2.value = y.subtype ");
            }
            if (whereStrB.length() > 0) {
                sqlStrB.append("where 1=1 " + whereStrB.toString() + " and ");
            } else {
                sqlStrB.append("where ");
            }
            sqlStrB.append("y.id in (select distinct r.firstquestionid from " + this.questionRepeatedBeanDao.getTableName() + " r " +
                    " where r.questiontype = '" + questionType + "' and r.similarity > " + similarity + ") ");
            sqlStrB.append("order by y.subType, y.type, y.id");
            String sql = sqlStrB.toString();
            jsonData = this.dao.findByNativeSql(sql, page, limit, QuestionDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonData;
    }

    /**
     * 获取比对后有重复的试题
     *
     * @param page
     * @param limit
     * @param jsonStr
     * @param sort
     * @return
     */
    @Override
    public JsonData getFirstQuestions(Integer page, Integer limit, String jsonStr, String sort) {
        JsonData jsonData = new JsonData();
        try {
            // 增加数据权限,默认为只能查看自己建立的数据
            EnumDataAuth enumDataAuth = EnumDataAuth.SELF;
            Long userId = shiroService.getCurrentUserId();
            // 根据appName查询具体的数据权限
            String appName = "enrolment";
            String menuIdToLower = "questionsRepeatedMenu";
            DataAuthBean authBean = dataAuthBeanService.getDataAuthBean(userId, appName, menuIdToLower);
            if (authBean == null) {
                enumDataAuth = EnumDataAuth.SELF;
            } else {
                enumDataAuth = EnumDataAuth.values()[authBean.getType()];
            }
            StringBuilder dataAuthStrB = new StringBuilder();
            switch (enumDataAuth) {
                // 本人数据
                case SELF:
                    /*sql = "select y.* from " + this.dao.getTableName() + " y " +
                            " where y.delflag = '0' and y.repeatedflag = '0' and y.compareflag = '1' and y.createbyid = " + userId +
                            " and y.id in (select distinct r.firstquestionid from " + this.questionRepeatedBeanDao.getTableName() + " r " +
                            " where r.questiontype = '" + questionType + "' and r.similarity > " +
                            " (select s.similarity from enrolment_question_setting s where s.id = 1)) " +
                            " order by y.subType, y.id";*/
                    dataAuthStrB.append(" and y.createbyid = " + userId);
                    break;
                // 所有数据
                case ALL:
                    /*sql = "select y.* from " + this.dao.getTableName() + " y " +
                            " where y.delflag = '0' and y.repeatedflag = '0' and y.compareflag = '1'" +
                            " and y.id in (select distinct r.firstquestionid from " + this.questionRepeatedBeanDao.getTableName() + " r " +
                            " where r.questiontype = '" + questionType + "' and r.similarity > " +
                            " (select s.similarity from enrolment_question_setting s where s.id = 1)) " +
                            " order by y.subType, y.id";*/
                    break;
            }
            // 解析jsonStr参数
            Map queryMap = SerializeUtil.json2Map(jsonStr);
            String subType = (String) queryMap.get("subType");
            String type = (String) queryMap.get("type");
            StringBuilder jsonStrB = new StringBuilder();
            if (StringUtils.isNotEmpty(subType)) {
                jsonStrB.append(" and y.subtype = '" + subType + "' ");
            }
            if (StringUtils.isNotEmpty(type)) {
                jsonStrB.append(" and y.type = '" + type + "' ");
            }
            // 合成sql语句
            String sql = this.getFirstQuestionsSQL(jsonStrB, dataAuthStrB);
            /*Class cls = null;
            try {
                cls = Class.forName(this.entityClassName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            jsonData = this.dao.findByNativeSql(sql, page, limit, cls);*/
            jsonData = this.dao.findByNativeSql(sql, page, limit, QuestionDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonData;
    }

    /**
     * 选择一道试题后，获取和该试题重复的所有试题
     *
     * @param page
     * @param limit
     * @param jsonStr
     * @param sort
     * @return
     */
    @Override
    public JsonData getSecondQuestions(Integer page, Integer limit, String jsonStr, String sort) {
        JsonData jsonData = new JsonData();
        try {
            Map queryMap = SerializeUtil.json2Map(jsonStr);
            String firstQuestionId = (String) queryMap.get("firstQuestionId");
            if (StringUtils.isEmpty(firstQuestionId)) {
                return jsonData;
            }
            /*String sql = "select y.* from " + this.dao.getTableName() + " y " +
                    " where y.delflag = '0' and " +
                    " y.id in (select r.secondquestionid from " + this.questionRepeatedBeanDao.getTableName() + " r " +
                    " where r.questiontype = '" + questionType + "' and r.firstquestionid = " + firstQuestionId +
                    " and r.similarity > (select s.similarity from enrolment_question_setting s where s.id = 1) " +
                    " order by r.similarity desc)";*/
            Long id = Long.parseLong(firstQuestionId);
            // 合成sql语句
            String sql = this.getSecondQuestionsSQL(id);
            /*Class cls = null;
            try {
                cls = Class.forName(this.entityClassName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            jsonData = this.dao.findByNativeSql(sql, page, limit, cls);*/
            jsonData = this.dao.findByNativeSql(sql, page, limit, QuestionDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonData;
    }

    /**
     * 获取题干相同的试题
     *
     * @return
     */
    @Override
    public JsonData getTheSameStem(String jsonStr) {
        JsonData jsonData = new JsonData();
        try {
            Map queryMap = SerializeUtil.json2Map(jsonStr);
            String subType = (String) queryMap.get("subType");
            StringBuilder whereStrB = new StringBuilder();
            if (StringUtils.isNotEmpty(subType)) {
                whereStrB.append(" and y.subtype = '" + subType + "' ");
            }
            String questionType = this.getQuestionType();
            String questionTypeName = this.getQuestionTypeName();
            String questionBeans = this.getQuestionBeans();
            String subTypeName = this.getSubTypeName(subType);
            StringBuilder sqlStrB = new StringBuilder();
            String selectStr = "select '" + questionType + "' as questiontype, '" + questionTypeName +
                    "' as questiontypename, '" + questionBeans + "' as questionbeans, '" + subTypeName +
                    "' as subtypename, t.subtype, t.repeatedCount, t.stem from " +
                    "(select count(1) as repeatedCount, trim(y.stem) as stem, y.subtype from " + this.dao.getTableName() +
                    " y where y.delflag='0'";
            sqlStrB.append(selectStr);
            if (whereStrB.length() > 0) {
                sqlStrB.append(whereStrB.toString());
            }
            sqlStrB.append("group by trim(y.stem),y.subtype having count(1) > 1) t ");
            sqlStrB.append("order by t.subType, t.stem");
            String sql = sqlStrB.toString();
            List<RepeatedTestingDTO> list = this.dao.findByNativeSql(sql, RepeatedTestingDTO.class);
            jsonData.setData(list);
            jsonData.setTotalCount((long) list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonData;
    }

    protected double getSimilarity() {
        double defaultSimilarity = DEFAULT_SIMILARITY;
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
                if (p1.getSimilarity() < p2.getSimilarity()) {
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
        long sss = System.currentTimeMillis();
        System.out.println("=====start===" + new Date() + "=====" + sss);
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
            List<TP> listAll = dao.findByNativeSql(sqlAll, cls);
            long firstId = entity.getId();
            String firstStem = entity.getStem();
            // 是否需要排重，默认1无重复
            final String[] repeatedFlag = {"1"};
            double similarity = this.getSimilarity();
            /*for (int j = 0; j < listAll.size(); j++) {
                TP secondEntity = (TP) listAll.get(j);
                long secondId = secondEntity.getId();
                String secondStem = secondEntity.getStem();
                long sss1 = System.currentTimeMillis();
                double result = Similarity.morphoSimilarity(firstStem, secondStem);
                long sss2 = System.currentTimeMillis() - sss1;
                if (sss2 > 400) {
                    System.out.println("===compare===" + sss2);
                    System.out.println("firstid=" + firstId + ",secondid=" + secondId);
                    System.out.println(result);
                }
                if (result > DEFAULT_SIMILARITY) {
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
                    if (result > similarity) {
                        repeatedFlag = "0";
                    }
                }
            }*/
            List<QuestionRepeatedBean> rtn = new ArrayList<QuestionRepeatedBean>();
            listAll.stream().parallel().forEach(secondEntity -> {
                long secondId = secondEntity.getId();
                String secondStem = secondEntity.getStem();
                long sss1 = System.currentTimeMillis();
                double result = Similarity.morphoSimilarity(firstStem, secondStem);
                long sss2 = System.currentTimeMillis() - sss1;
                if (sss2 > 400) {
                    System.out.println("===compare===" + sss2);
                    System.out.println("firstid=" + firstId + ",secondid=" + secondId);
                    System.out.println(result);
                }
                if (result > DEFAULT_SIMILARITY) {
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
                    //questionRepeatedBeanService.saveSimilarity(questionRepeatedBean);
                    rtn.add(questionRepeatedBean);
                    if (result > similarity) {
                        repeatedFlag[0] = "0";
                    }
                }
            });
            for (int i = 0; i < rtn.size(); i++) {
                QuestionRepeatedBean questionRepeatedBean = rtn.get(i);
                questionRepeatedBeanService.saveSimilarity(questionRepeatedBean);
            }
            this.updateCompareFlag(entity.getId(), "1", repeatedFlag[0]);
            jsonStatus.setSuccess(true);
            jsonStatus.setMsg("试题排重比对完成,保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            jsonStatus.setSuccess(false);
            jsonStatus.setMsg(e.getMessage());
        }
        System.out.println("=====end=====" + new Date());
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

    protected String getFirstQuestionsSQL(StringBuilder jsonStrB, StringBuilder dataAuthStrB) {
        StringBuilder sqlStrB = new StringBuilder();
        String questionType = this.getQuestionType();
        String questionTypeName = this.getQuestionTypeName();
        String questionBeans = this.getQuestionBeans();
        String subTypeDictType = this.getSubTypeDictType();
        String selectStr = "select '" + questionType + "' as questiontype, '" + questionTypeName +
                "' as questiontypename, '" + questionBeans + "' as questionbeans, y.subtype, y.id, y.id as questionId, " +
                " y.stem, y.analysis, y.checkflag, y.checkerid, y.checker, y.checkdate, y.checkreason, y.repeatedflag, " +
                " y.delflag, y.reason, y.compareFlag, y.createby, y.creationdate, y.updateby, y.updatedate, " +
                " d.label as typename ";
        sqlStrB.append(selectStr);
        if (StringUtils.isNotEmpty(subTypeDictType)) {
            sqlStrB.append(", d2.label as subtypename ");
        }
        sqlStrB.append("from " + this.dao.getTableName() + " y ");
        sqlStrB.append("left join enrolment_dict d on d.type = '" + DICT_TYPE + "' and d.value = y.type ");
        if (StringUtils.isNotEmpty(subTypeDictType)) {
            sqlStrB.append("left join enrolment_dict d2 on d2.type = '" + subTypeDictType + "' and d2.value = y.subtype ");
        }
        sqlStrB.append("where y.delflag = '0' and y.checkflag <> '2' and y.repeatedflag = '0' and y.compareflag = '1' ");
        if (jsonStrB.length() > 0) {
            sqlStrB.append(jsonStrB.toString());
        }
        if (dataAuthStrB.length() > 0) {
            sqlStrB.append(dataAuthStrB.toString());
        }
        sqlStrB.append(" and y.id in (select distinct r.firstquestionid from " + this.questionRepeatedBeanDao.getTableName() + " r " +
                "where r.questiontype = '" + questionType + "' and r.similarity > " +
                "(select s.similarity from enrolment_question_setting s where s.id = 1)) ");
        sqlStrB.append("order by y.subType, y.type, y.id");
        return sqlStrB.toString();
    }

    protected String getSecondQuestionsSQL(Long firstQuestionId) {
        StringBuilder sqlStrB = new StringBuilder();
        String questionType = this.getQuestionType();
        String questionTypeName = this.getQuestionTypeName();
        String questionBeans = this.getQuestionBeans();
        String subTypeDictType = this.getSubTypeDictType();
        String selectStr = "select '" + questionType + "' as questiontype, '" + questionTypeName +
                "' as questiontypename, '" + questionBeans + "' as questionbeans, y.subtype, y.id, y.id as questionId, " +
                " y.stem, y.analysis, y.checkflag, y.checkerid, y.checker, y.checkdate, y.checkreason, y.repeatedflag, " +
                " y.delflag, y.reason, y.compareFlag, y.createby, y.creationdate, y.updateby, y.updatedate, " +
                " r.similarity, r.similaritydesc, d.label as typename ";
        sqlStrB.append(selectStr);
        if (StringUtils.isNotEmpty(subTypeDictType)) {
            sqlStrB.append(", d2.label as subtypename ");
        }
        sqlStrB.append("from " + this.dao.getTableName() + " y ");
        sqlStrB.append("left join enrolment_dict d on d.type = '" + DICT_TYPE + "' and d.value = y.type ");
        if (StringUtils.isNotEmpty(subTypeDictType)) {
            sqlStrB.append("left join enrolment_dict d2 on d2.type = '" + subTypeDictType + "' and d2.value = y.subtype ");
        }
        sqlStrB.append(", " + this.questionRepeatedBeanDao.getTableName() + " r ");
        sqlStrB.append("where y.delflag = '0' and y.checkflag <> '2' and y.id = r.secondquestionid and r.questiontype = '" + questionType +
                "' and r.firstquestionid = " + firstQuestionId + " and r.similarity > " +
                "(select s.similarity from enrolment_question_setting s where s.id = 1) ");
        sqlStrB.append("order by r.similarity desc, y.subtype, y.type, y.id");
        return sqlStrB.toString();
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

    public void setQuestionRepeatedBeanDao(IQuestionRepeatedBeanDao questionRepeatedBeanDao) {
        this.questionRepeatedBeanDao = questionRepeatedBeanDao;
    }

    public void setQuestionRepeatedBeanService(IQuestionRepeatedBeanService questionRepeatedBeanService) {
        this.questionRepeatedBeanService = questionRepeatedBeanService;
    }

    public void setDataAuthBeanService(IDataAuthBeanService dataAuthBeanService) {
        this.dataAuthBeanService = dataAuthBeanService;
    }
}
