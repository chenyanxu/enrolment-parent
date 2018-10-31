package com.kalix.enrolment.question.biz;

import com.kalix.admin.core.api.biz.IRoleBeanService;
import com.kalix.admin.core.entities.RoleBean;
import com.kalix.enrolment.question.api.biz.IPaperBeanService;
import com.kalix.enrolment.question.api.biz.IQuestionAuditService;
import com.kalix.enrolment.question.api.biz.IRuleBeanService;
import com.kalix.enrolment.question.api.biz.ITestPaperService;
import com.kalix.enrolment.question.api.model.QuestionType;
import com.kalix.enrolment.question.entities.BaseQuestionBean;
import com.kalix.enrolment.question.entities.PaperBean;
import com.kalix.enrolment.question.entities.RuleBean;
import com.kalix.framework.core.api.biz.IDownloadService;
import com.kalix.framework.core.api.dao.IGenericDao;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.util.ConfigUtil;
import com.kalix.framework.core.util.JNDIHelper;
import com.kalix.framework.core.util.StringUtils;
import com.kalix.framework.extend.impl.biz.LogicDeleteGenericBizServiceImpl;
import freemarker.template.Configuration;
import freemarker.template.Template;

import javax.transaction.Transactional;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zangyanming at 2018-09-13
 */
public abstract class QuestionGenericBizServiceImpl<T extends IGenericDao, TP extends BaseQuestionBean>
        extends LogicDeleteGenericBizServiceImpl<T, TP>
        implements IQuestionAuditService, IDownloadService, ITestPaperService {

    private IRoleBeanService roleBeanService;
    private ITestPaperService testPaperService;
    private IPaperBeanService paperBeanService;
    private IRuleBeanService  ruleBeanService;

    public IRoleBeanService getRoleBeanService() {
        return roleBeanService;
    }

    public ITestPaperService getTestPaperService() {
        return testPaperService;
    }

    public void setTestPaperService(ITestPaperService testPaperService) {
        this.testPaperService = testPaperService;
    }

    public IPaperBeanService getPaperBeanService() {
        return paperBeanService;
    }

    public void setPaperBeanService(IPaperBeanService paperBeanService) {
        this.paperBeanService = paperBeanService;
    }

    public IRuleBeanService getRuleBeanService() {
        return ruleBeanService;
    }

    public void setRuleBeanService(IRuleBeanService ruleBeanService) {
        this.ruleBeanService = ruleBeanService;
    }

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

    @Override
    public JsonStatus createTestPaper(Long paperId) {
        JsonStatus jsonStatus = new JsonStatus();
        try {
            Map tempMap = new HashMap<>();
            paperBeanService = JNDIHelper.getJNDIServiceForName(IPaperBeanService.class.getName());
            ruleBeanService = JNDIHelper.getJNDIServiceForName(IRuleBeanService.class.getName());
            PaperBean paperBean=paperBeanService.getEntity(paperId);
            List list_rule=ruleBeanService.findByPaperId(paperId);
            List<Map> test = new ArrayList<Map>();

          //  RuleBean ruleBean = new RuleBean();
            int questionTypeCount = 0;
//            List<String> list = new ArrayList<String>();
//            list.add("1");
//            list.add("2");
//            list.add("3");
            for (int i = 0; i < list_rule.size(); i++) {
                RuleBean ruleBean=(RuleBean)list_rule.get(i);
                String beanName = this.getBeanName(ruleBean.getQuesType());
                Map paper_map =new HashMap();
                paper_map.put("score",ruleBean.getQuesScore());
                paper_map.put("totalscore",ruleBean.getQuesTotalscore());
                paper_map.put("desc",ruleBean.getQuesDesc());
                paper_map.put("titlenum",ruleBean.getTitleNum());
                paper_map.put("paperid",ruleBean.getPaperId());
                Map<String, String> map = new HashMap<String, String>();
                map.put("beanName", beanName);
                testPaperService = JNDIHelper.getJNDIServiceForName(ITestPaperService.class.getName(), map);
                Map singleTestPaper = testPaperService.createSingleTestPaper(paper_map);
                test.add(singleTestPaper);
            }
            tempMap.put("quesList", test);
            aaa("testPaper.ftl", tempMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonStatus;
    }

    private String getBeanName(String quesType) {
        String beanName = "";
        switch (quesType) {
            case QuestionType.COMPLETION:
                beanName = "Completion";
                break;
            case QuestionType.CHOICE:
                beanName = "Choice";
                break;
            case QuestionType.VERSE:
                beanName = "";
                break;
        }
        return beanName;
    }

    private JsonStatus aaa(String fileName, Map tempMap) {
        JsonStatus jsonStatus = new JsonStatus();

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
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String testPaperName = sdf.format(new Date());

            File outFile = new File("d:\\" + testPaperName + ".doc");
            Writer out = null;
            FileOutputStream fos = null;
            fos = new FileOutputStream(outFile);
            OutputStreamWriter oWriter = new OutputStreamWriter(fos, "UTF-8");
            //这个地方对流的编码不可或缺，使用main（）单独调用时，应该可以，但是如果是web请求导出时导出后word文档就会打不开，并且包XML文件错误。主要是编码格式不正确，无法解析。
            //out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
            out = new BufferedWriter(oWriter);
            t.process(tempMap, out);
            out.close();
            fos.close();
        } catch (Exception e) {
            //logger.error("导出出错", e);
            e.printStackTrace();
            // throw new BusinessException(CommonResultEnum.COMMON_ERROR_637);
        }
        return jsonStatus;
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
}
