package com.kalix.enrolment.question.biz;

import com.kalix.admin.core.api.biz.IRoleBeanService;
import com.kalix.admin.core.entities.RoleBean;
import com.kalix.enrolment.question.api.biz.IFreemarkerService;
import com.kalix.enrolment.question.api.biz.IQuestionAuditService;
import com.kalix.enrolment.question.api.model.QuestionType;
import com.kalix.enrolment.question.entities.BaseQuestionBean;
import com.kalix.enrolment.question.entities.SubjectBean;
import com.kalix.framework.core.api.biz.IDownloadService;
import com.kalix.framework.core.api.dao.IGenericDao;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.util.ConfigUtil;
import com.kalix.framework.core.util.DateUtil;
import com.kalix.framework.core.util.StringUtils;
import com.kalix.framework.extend.impl.biz.LogicDeleteGenericBizServiceImpl;
import freemarker.template.Configuration;
import freemarker.template.Template;

import javax.transaction.Transactional;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by zangyanming at 2018-09-13
 */
public abstract class QuestionGenericBizServiceImpl<T extends IGenericDao, TP extends BaseQuestionBean>
        extends LogicDeleteGenericBizServiceImpl<T, TP>
        implements IQuestionAuditService, IDownloadService, IFreemarkerService {

    private IRoleBeanService roleBeanService;

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
        // 获取试题分类
        String questionType = this.getQuestionType();
        // 获取审核人角色名称
        String roleName = this.getAuditRoleName(subType);
        // 获取试题子类 subType

        // 1.该类型试题未审核总数
        int total = 0;
        String countSql = "";
        if (StringUtils.isEmpty(subType)) {
            countSql = "select count(1) from " + dao.getTableName()
                    + " where delFlag = '0'"
                    + " and checkFlag = '0'"
                    + " and (to_char(creationdate,'yyyy') = to_char(now(),'yyyy'))";
        } else {
            if (questionType.equals(QuestionType.SUBJECT)) {
                countSql = "select count(1) from " + dao.getTableName()
                        + " where delFlag = '0'"
                        + " and checkFlag = '0'"
                        + " and (to_char(creationdate,'yyyy') = to_char(now(),'yyyy'))"
                        + " and subjectType = '" + subType + "'";
            } else if (questionType.equals(QuestionType.INTERVIEW)) {
                countSql = "select count(1) from " + dao.getTableName()
                        + " where delFlag = '0'"
                        + " and checkFlag = '0'"
                        + " and (to_char(creationdate,'yyyy') = to_char(now(),'yyyy'))"
                        + " and interviewType = '" + subType + "'";
            }
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
//        if (questionType.equals(QuestionType.COMPLETION) || questionType.equals(QuestionType.CHOICE) ||
//                questionType.equals(QuestionType.VERSE) || questionType.equals(QuestionType.MUSIC))
//            checkCountSql = "select count(1) from " + dao.getTableName()
//                    + " where delFlag = '0' "
//                    + " and checkFlag != '0'"
//                    + " and (to_char(creationdate,'yyyy') = to_char(now(),'yyyy'))"
//                    + " and checkerId = " + currentUserId;
//        else if (questionType.equals(QuestionType.SUBJECT)) {
//            checkCountSql = "select count(1) from " + dao.getTableName()
//                    + " where delFlag = '0' "
//                    + " and checkFlag != '0'"
//                    + " and (to_char(creationdate,'yyyy') = to_char(now(),'yyyy'))"
//                    + " and subjectType = '" + questionSubType
//                    + "' and checkerId = " + currentUserId;
//        } else if (questionType.equals(QuestionType.INTERVIEW)) {
//            checkCountSql = "select count(1) from " + dao.getTableName()
//                    + " where delFlag = '0' "
//                    + " and checkFlag != '0'"
//                    + " and (to_char(creationdate,'yyyy') = to_char(now(),'yyyy'))"
//                    + " and interviewType = '" + questionSubType
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
            if (questionType.equals(QuestionType.SUBJECT)) {
                sql = "(select * from " + dao.getTableName()
                        + " where delFlag = '0' and checkFlag = '0'"
                        + " and (to_char(creationdate,'yyyy') = to_char(now(),'yyyy'))"
                        + " and subjectType = '" + subType + "'"
                        + " order by updateDate desc limit " + perCnt + " offset " + offset
                        + ") union all ("
                        + "select * from " + dao.getTableName()
                        + " where delFlag = '0' and checkFlag != '0'"
                        + " and (to_char(creationdate,'yyyy') = to_char(now(),'yyyy'))"
                        + " and subjectType = '" + subType + "'"
                        + " and checkerId = " + currentUserId
                        + " order by updateDate desc)";

            } else if (questionType.equals(QuestionType.INTERVIEW)) {
                sql = "(select * from " + dao.getTableName()
                        + " where delFlag = '0' and checkFlag = '0'"
                        + " and (to_char(creationdate,'yyyy') = to_char(now(),'yyyy'))"
                        + " and interviewType = '" + subType + "'"
                        + " order by updateDate desc limit " + perCnt + " offset " + offset
                        + ") union all ("
                        + "select * from " + dao.getTableName()
                        + " where delFlag = '0' and checkFlag != '0'"
                        + " and (to_char(creationdate,'yyyy') = to_char(now(),'yyyy'))"
                        + " and interviewType = '" + subType + "'"
                        + " and checkerId = " + currentUserId
                        + " order by updateDate desc)";
            }
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
            entity.setReason(reason);
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
    public String createDoc(String fileName, Map tempMap) {
        String htmlStr = "";

        Configuration configuration = new Configuration();

        //dataMap 要填入模本的数据文件
        //设置模本装置方法和路径,
        Template t = null;
        try {

            String realPath = (String) ConfigUtil.getConfigProp("word.review.realpath", "ConfigOpenOffice");
            if (realPath.charAt(realPath.length() - 1) != '/') {
                realPath += "/";
            }
            String reviewBaseDir = realPath + "questionfiles";
            configuration.setDirectoryForTemplateLoading(new File(reviewBaseDir));
            //test.ftl为要装载的模板
            t = configuration.getTemplate(fileName, "utf-8");
            //输出文档路径及名称
//            File outFile = new File("d:\\ddd.doc");
//            Writer out = null;
//            FileOutputStream fos=null;
//            fos = new FileOutputStream(outFile);
//            OutputStreamWriter oWriter = new OutputStreamWriter(fos,"UTF-8");
//            //这个地方对流的编码不可或缺，使用main（）单独调用时，应该可以，但是如果是web请求导出时导出后word文档就会打不开，并且包XML文件错误。主要是编码格式不正确，无法解析。
//            //out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
//            out = new BufferedWriter(oWriter);
//            t.process(tempMap, out);
//            out.close();
//            fos.close();
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

    public void setRoleBeanService(IRoleBeanService roleBeanService) {
        this.roleBeanService = roleBeanService;
    }


}
