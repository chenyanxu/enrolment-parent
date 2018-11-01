package com.kalix.enrolment.question.biz;

import com.kalix.admin.core.api.biz.IRoleBeanService;
import com.kalix.admin.core.entities.RoleBean;
import com.kalix.enrolment.question.api.biz.*;
import com.kalix.enrolment.question.dto.model.RepeatedCountDTO;
import com.kalix.enrolment.question.dto.model.RepeatedDTO;
import com.kalix.enrolment.question.entities.BaseQuestionEntity;
import com.kalix.enrolment.question.entities.QuestionSettingBean;
import com.kalix.framework.core.api.dao.IGenericDao;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.util.ConfigUtil;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by hqj at 2018-10-31
 */
public abstract class QuestionGenericBizServiceImpl<T extends IGenericDao, TP extends BaseQuestionEntity>
        extends LogicDeleteGenericBizServiceImpl<T, TP>
        implements IQuestionService<TP>, IQuestionAuditService, IRepeatedService, ITestPaperService {

    private IRoleBeanService roleBeanService;
    private IQuestionSettingBeanService questionSettingBeanService;

    @Override
    public JsonData getAllEntityByQuery(Integer page, Integer limit, String jsonStr, String sort) {
        if (StringUtils.isEmpty(sort)) {
            sort = "[{'property': 'delFlag', 'direction': 'ASC'},{'property': 'updateDate', 'direction': 'DESC'}]";
        }
        return super.getAllEntityByQuery(page, limit, jsonStr, sort);
    }

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

    @Override
    public JsonData getSingleRepeates(String subType) {
        JsonData jsonData = new JsonData();
        List<RepeatedCountDTO> repeateList = new ArrayList<RepeatedCountDTO>();
        List<Object> referenceList = new ArrayList<Object>();
        String sql = "";
        if (StringUtils.isEmpty(subType)) {
            sql = "select t.* from " + dao.getTableName() + " t "
                    + " where t.delFlag = '0'"
                    + " and t.repeatedFlag = '0'";
        } else {
            sql = "select t.* from " + dao.getTableName() + " t "
                    + " where t.delFlag = '0'"
                    + " and t.repeatedFlag = '0'"
                    + " and t.subType = '" + subType + "'";
        }
        /*Class cls = null;
        try {
            cls = Class.forName(this.entityClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        List<BaseQuestionEntity> list = dao.findByNativeSql(sql, BaseQuestionEntity.class);
        referenceList.addAll(list);
        double defaultCilinSimilarity = 0.5d;
        QuestionSettingBean questionSettingBean = questionSettingBeanService.getEntity(1L);
        if (questionSettingBean != null) {
            defaultCilinSimilarity = questionSettingBean.getCilinSimilarity().doubleValue();
        }
        String firstStem = "";
        String ids = "";
        int count = 1;
        for (int i = 0; i < referenceList.size(); i++) {
            String repeaFlag = "";
            RepeatedCountDTO repeatedCountDTO = new RepeatedCountDTO();
            BaseQuestionEntity firstEntity = (BaseQuestionEntity) referenceList.get(i);
            List<RepeatedDTO> dtoList = new ArrayList<RepeatedDTO>();
            firstStem = firstEntity.getStem();
            for (int j = 0; j < referenceList.size(); j++) {
                BaseQuestionEntity secondEntity = (BaseQuestionEntity) referenceList.get(j);
                if (secondEntity.getId() != firstEntity.getId()) {
                    String secondStem = secondEntity.getStem();
                    //短语相似度
                    // double result1 = Similarity.phraseSimilarity(firstStem, secondStem);
                    //词形词序句子相似度值
                    // double morphoSimilarityResult = Similarity.morphoSimilarity(firstStem, secondStem);
                    //词林相似度
                    double result = Similarity.cilinSimilarity(firstStem, secondStem);
                    if (result > defaultCilinSimilarity) {
                        repeaFlag = "0";
                        if (StringUtils.isNotEmpty(ids)) {
                            if (ids.indexOf(String.valueOf(firstEntity.getId())) < 0) {
                                RepeatedDTO repeatedDTO = new RepeatedDTO();
                                repeatedDTO.setQuestionId(firstEntity.getId());
                                repeatedDTO.setStem(firstEntity.getStem());
                                // repeatedDTO.setSimilarity("短语相似度-->" + new DecimalFormat("0.00").format(result1) + "；词林相似度" + new DecimalFormat("0.00").format(result));
                                repeatedDTO.setSimilarity("词林相似度" + new DecimalFormat("0.00").format(result));
//                                repeatedDTO.setQuestionType("CompletionBean");
                                dtoList.add(repeatedDTO);
                                ids += firstEntity.getId() + ",";
                            }
                        } else {
                            RepeatedDTO repeatedDTO = new RepeatedDTO();
                            repeatedDTO.setQuestionId(firstEntity.getId());
                            repeatedDTO.setStem(firstEntity.getStem());
                            repeatedDTO.setSimilarity("词林相似度" + new DecimalFormat("0.00").format(result));
//                            repeatedDTO.setQuestionType("CompletionBean");
                            dtoList.add(repeatedDTO);
                            ids += firstEntity.getId() + ",";
                        }

                        RepeatedDTO repeatedDTO = new RepeatedDTO();
                        repeatedDTO.setQuestionId(secondEntity.getId());
                        repeatedDTO.setStem(secondEntity.getStem());
                        repeatedDTO.setSimilarity("词林相似度" + new DecimalFormat("0.00").format(result));
//                        repeatedDTO.setQuestionType("CompletionBean");
                        dtoList.add(repeatedDTO);

                        referenceList.remove(secondEntity);
                    }
                }
            }
            if (dtoList != null && dtoList.size() > 0) {
                repeatedCountDTO.setName("题目" + (count++));
                repeatedCountDTO.setRepeateList(dtoList);
                repeateList.add(repeatedCountDTO);
            }

            if (StringUtils.isEmpty(repeaFlag)) {
                firstEntity.setRepeatedFlag("1");
                this.dao.save(firstEntity);
            }
            referenceList.remove(firstEntity);
        }
        jsonData.setData(repeateList);
        return jsonData;
    }

    @Override
    @Transactional
    public JsonStatus doSaveRepeate(Long questionId) {
        JsonStatus jsonStatus = new JsonStatus();
        TP entity = (TP) this.dao.get(questionId);
        entity.setRepeatedFlag("1");
        this.dao.save(entity);
        jsonStatus.setSuccess(true);
        jsonStatus.setMsg("试题保留成功！");
        return jsonStatus;
    }

    @Override
    @Transactional
    public JsonStatus doDeleteRepeate(Long questionId) {
        JsonStatus jsonStatus = new JsonStatus();
        TP entity = (TP) this.dao.get(questionId);
        entity.setDelFlag("1");
        entity.setRepeatedFlag("1");
        entity.setUpdateBy(shiroService.getCurrentUserLoginName());
        entity.setUpdateById(shiroService.getCurrentUserId());
        this.dao.save(entity);
        jsonStatus.setSuccess(true);
        jsonStatus.setMsg("试题删除成功！");
        return jsonStatus;
    }

    @Override
    public JsonData validateRepeates(RepeatedDTO repeatedDTO) {
        JsonData jsonData = new JsonData();
        String stem = repeatedDTO.getStem();
        String subType = repeatedDTO.getSubType();
        Long questionid = repeatedDTO.getQuestionId();
        List<RepeatedCountDTO> repeateList = new ArrayList<RepeatedCountDTO>();
        List<Object> referenceList = new ArrayList<Object>();
        String sql = "";
        if (StringUtils.isEmpty(subType)) {
            if (questionid != null && questionid > 0) {
                sql = "select t.* from " + dao.getTableName() + " t "
                        + " where t.delFlag = '0' and t.id <> " + questionid;
            } else {
                sql = "select t.* from " + dao.getTableName() + " t "
                        + " where t.delFlag = '0'";
            }
        } else {
            if (questionid != null && questionid > 0) {
                sql = "select t.* from " + dao.getTableName() + " t "
                        + " where t.delFlag = '0' and t.subType = '" + subType + "' and t.id <> " + questionid;
            } else {
                sql = "select t.* from " + dao.getTableName() + " t "
                        + " where t.delFlag = '0' and t.subType = '" + subType + "'";
            }
        }
        /*Class cls = null;
        try {
            cls = Class.forName(this.entityClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        List<BaseQuestionEntity> list = dao.findByNativeSql(sql, BaseQuestionEntity.class);
        referenceList.addAll(list);
        double defaultCilinSimilarity = 0.5d;
        QuestionSettingBean questionSettingBean = questionSettingBeanService.getEntity(1L);
        if (questionSettingBean != null) {
            defaultCilinSimilarity = questionSettingBean.getCilinSimilarity().doubleValue();
        }
        int count = 1;
        RepeatedCountDTO repeatedCountDTO = new RepeatedCountDTO();
        List<RepeatedDTO> dtoList = new ArrayList<RepeatedDTO>();
        String str_stem = "";
        for (int j = 0; j < referenceList.size(); j++) {
            BaseQuestionEntity questionEntity = (BaseQuestionEntity) referenceList.get(j);
            str_stem = questionEntity.getStem();
            //短语相似度
            // double result1 = Similarity.phraseSimilarity(stem, str_stem);
            //词形词序句子相似度值
            // double morphoSimilarityResult = Similarity.morphoSimilarity(stem, str_stem);
            //词林相似度
            double result = Similarity.cilinSimilarity(stem, str_stem);
            if (result > defaultCilinSimilarity) {
                RepeatedDTO obj = new RepeatedDTO();
                obj.setQuestionId(questionEntity.getId());
                obj.setStem(str_stem);
                //obj.setSimilarity("短语相似度-->" + new DecimalFormat("0.00").format(result1) + "；词林相似度" + new DecimalFormat("0.00").format(result));
                obj.setSimilarity("词林相似度" + new DecimalFormat("0.00").format(result));
//                obj.setQuestionType(type);
                dtoList.add(repeatedDTO);
            }
        }
        if (dtoList != null && dtoList.size() > 0) {
            repeatedCountDTO.setName("题目" + (count++));
            repeatedCountDTO.setRepeateList(dtoList);
            repeateList.add(repeatedCountDTO);
        }
        jsonData.setData(repeateList);
        return jsonData;
    }

    @Override
    public String createSinglePreview(Map tempMap, String subType) {

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

    public void setRoleBeanService(IRoleBeanService roleBeanService) {
        this.roleBeanService = roleBeanService;
    }

    public void setQuestionSettingBeanService(IQuestionSettingBeanService questionSettingBeanService) {
        this.questionSettingBeanService = questionSettingBeanService;
    }
}
