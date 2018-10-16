package com.kalix.enrolment.question.biz;

import com.kalix.admin.core.api.biz.IRoleBeanService;
import com.kalix.admin.core.entities.RoleBean;
import com.kalix.enrolment.question.api.biz.IFreemarkerService;
import com.kalix.enrolment.question.api.biz.ISubjectBeanService;
import com.kalix.enrolment.question.api.dao.ISubjectBeanDao;
import com.kalix.enrolment.question.entities.SubjectBean;
import com.kalix.framework.core.api.biz.IDownloadService;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.util.ConfigUtil;
import com.kalix.framework.core.util.StringUtils;
import com.kalix.framework.extend.impl.biz.LogicDeleteGenericBizServiceImpl;
import freemarker.template.Configuration;
import freemarker.template.Template;

import javax.transaction.Transactional;
import java.io.BufferedWriter;
import java.io.File;
import java.io.StringWriter;
import java.util.*;

/**
 * Created by zangyanming at 2018-09-13
 */
public class SubjectBeanServiceImpl extends LogicDeleteGenericBizServiceImpl<ISubjectBeanDao, SubjectBean> implements ISubjectBeanService, IDownloadService, IFreemarkerService {
    private IRoleBeanService roleBeanService;

    @Override
    public JsonData getAllEntityByQuery(Integer page, Integer limit, String jsonStr, String sort) {
        if (StringUtils.isEmpty(sort)) {
            sort = "[{'property': 'delFlag', 'direction': 'ASC'},{'property': 'updateDate', 'direction': 'DESC'}]";
        }
        return super.getAllEntityByQuery(page, limit, jsonStr, sort);
    }

    @Override
    public String createDoc(String fileName,Map tempMap)
    {
        String htmlStr="";

        Configuration configuration = new Configuration();

        //dataMap 要填入模本的数据文件
        //设置模本装置方法和路径,
        Template t=null;
        try {

            String realPath = (String) ConfigUtil.getConfigProp("word.review.realpath", "ConfigOpenOffice");
            if (realPath.charAt(realPath.length() - 1) != '/') {
                realPath += "/";
            }
            String reviewBaseDir = realPath + "questionfiles";
            configuration.setDirectoryForTemplateLoading(new File(reviewBaseDir));
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
    public String[] createDownloadFile(Long entityId, String fileType) {

        SubjectBean subjectBean = this.getEntity(entityId);

        Map dataMap = new HashMap();
        Map tempMap= new HashMap();
        dataMap.put("stem",subjectBean.getStem());

        tempMap = new HashMap<>();
        tempMap.put("title","主观题");
        tempMap.put("question",dataMap);
        String[] str = new String[2];
        str[0] = "123";
        str[1] = this.createDoc("subject.ftl",tempMap);
        return str;
    }

    @Override
    public JsonData getAllCheckEntityByQuery(String subjectType, Integer page, Integer limit) {
        // 当前登录人ID
        Long currentUserId = shiroService.getCurrentUserId();
        String roleName = this.getRoleName(subjectType);

        // 1.该类型试题总数
        String countSql = "select count(1) from " + dao.getTableName()
                + " where delFlag = '0'"
                + " and (substr(to_char(creationdate,'yyyy-mm-dd hh:mi:ss'),1,4) = to_char(now(),'yyyy-mm-dd hh:mi:ss'))"
                + " and subjectType = '" + subjectType + "'";

        List list = dao.findByNativeSql(countSql, Integer.class);
        int total = 0;
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

        // 5.该类型试题当前人已经审核总数
        int checkedTotal = 0;
        countSql = "select count(1) from " + dao.getTableName()
                + " where delFlag = '0'"
                + " and (substr(to_char(creationdate,'yyyy-mm-dd hh:mi:ss'),1,4) = to_char(now(),'yyyy-mm-dd hh:mi:ss'))"
                + " and subjectType = '" + subjectType + "' and checkerId = " + currentUserId;

        list = dao.findByNativeSql(countSql, Integer.class);
        if (list != null && list.get(0) != null) {
            checkedTotal = (Integer) list.get(0);
        }

        // 6.获取需要分配未审核试题数量
        int syCount = perCnt - checkedTotal;
        String sql = "";
        if (syCount > 0) {
            // 获取偏移量，即数据库指针位置
            int offset = 0;
            for (int i = 0; i < userIdList.size(); i++) {
                if (userIdList.get(i).equals(currentUserId)) {
                    if (i < ys) {
                        offset = i * perCnt;
                    } else {
                        offset = (perCnt + 1) * i + (i - ys) * perCnt;
                    }
                    break;
                }
            }

            // 分配未审核试题及已经审核试题
            sql = "(select * from " + dao.getTableName()
                    + " where checkFlag = '0' and delFlag = '0'"
                    + " and (substr(to_char(creationdate,'yyyy-mm-dd hh:mi:ss'),1,4) = to_char(now(),'yyyy-mm-dd hh:mi:ss'))"
                    + " and subjectType = '" + subjectType + "'"
                    + " order by updateDate desc limit " + syCount + " offset " + (offset - checkedTotal)

                    + ") union all ("
                    + "select * from " + dao.getTableName()
                    + " where checkFlag = '1' and delFlag = '0'"
                    + " and (substr(to_char(creationdate,'yyyy-mm-dd hh:mi:ss'),1,4) = to_char(now(),'yyyy-mm-dd hh:mi:ss'))"
                    + " and subjectType = '" + subjectType + "' and checkerId = " + currentUserId
                    + " order by updateDate desc)";
        } else {
            // 已经审核试题
            sql = "select * from " + dao.getTableName()
                    + " where checkFlag = '1' and delFlag = '0'"
                    + " and (substr(to_char(creationdate,'yyyy-mm-dd hh:mi:ss'),1,4) = to_char(now(),'yyyy-mm-dd hh:mi:ss'))"
                    + " and subjectType = '" + subjectType + "' and checkerId = " + currentUserId
                    + " order by updateDate desc";
        }

        return dao.findByNativeSql(sql, page, limit, SubjectBean.class);
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

        SubjectBean subjectBean = null;
        for (int i = 0; i < ids.length; i++) {
            subjectBean = this.dao.get(Long.parseLong(ids[i]));
            subjectBean.setCheckFlag(checkFlag);
            subjectBean.setReason(reason);
            subjectBean.setCheckerId(this.shiroService.getCurrentUserId());
            subjectBean.setChecker(this.shiroService.getCurrentUserRealName());
            subjectBean.setCheckDate(new Date());

            this.updateEntity(subjectBean);
        }

        jsonStatus.setSuccess(true);
        jsonStatus.setMsg("试题审核成功");

        return jsonStatus;
    }

    public void setRoleBeanService(IRoleBeanService roleBeanService) {
        this.roleBeanService = roleBeanService;
    }

    public String getRoleName(String subjectType) {
        String roleName = "主观题出题人";
        if (subjectType.equals("1"))
            roleName = "简答题出题人";
        if (subjectType.equals("2"))
            roleName = "论述题出题人";
        if (subjectType.equals("3"))
            roleName = "评述题出题人";
        if (subjectType.equals("4"))
            roleName = "故事编写出题人";
        if (subjectType.equals("5"))
            roleName = "故事续写出题人";
        if (subjectType.equals("6"))
            roleName = "微小说编写出题人";
        if (subjectType.equals("7"))
            roleName = "摄影作品分析出题人";
        if (subjectType.equals("8"))
            roleName = "影片声音分析出题人";
        if (subjectType.equals("9"))
            roleName = "影像作品分析出题人";

        return roleName;
    }
}
