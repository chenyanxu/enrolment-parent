package com.kalix.enrolment.question.biz;

import com.kalix.admin.core.api.biz.IRoleBeanService;
import com.kalix.admin.core.entities.RoleBean;
import com.kalix.enrolment.question.api.biz.IFreemarkerService;
import com.kalix.enrolment.question.api.biz.IVerseBeanService;
import com.kalix.enrolment.question.api.dao.IVerseBeanDao;
import com.kalix.enrolment.question.entities.VerseBean;
import com.kalix.framework.core.api.biz.IDownloadService;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.util.ConfigUtil;
import com.kalix.framework.core.util.SerializeUtil;
import com.kalix.framework.core.util.StringUtils;
import com.kalix.framework.extend.impl.biz.LogicDeleteGenericBizServiceImpl;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.BufferedWriter;
import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zangyanming at 2018-09-13
 */
public class VerseBeanServiceImpl extends LogicDeleteGenericBizServiceImpl<IVerseBeanDao, VerseBean> implements IVerseBeanService, IDownloadService, IFreemarkerService {
    private IRoleBeanService roleBeanService;
    private static String rolename = "补全诗句审核人";

    @Override
    public JsonData getAllEntityByQuery(Integer page, Integer limit, String jsonStr, String sort) {
        if (StringUtils.isEmpty(sort)) {
            sort = "[{'property': 'delFlag', 'direction': 'ASC'},{'property': 'updateDate', 'direction': 'DESC'}]";
        }
        return super.getAllEntityByQuery(page, limit, jsonStr, sort);
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

        VerseBean verseBean = this.getEntity(entityId);

        Map dataMap = new HashMap();
        Map tempMap = new HashMap();
        dataMap.put("stem", verseBean.getStem());

        tempMap = new HashMap<>();
        tempMap.put("title", "补全诗句");
        tempMap.put("question", dataMap);
        String[] str = new String[2];
        str[0] = "123";
        str[1] = this.createDoc("choice.ftl", tempMap);
        return str;
    }

    @Override
    public JsonData getAllCheckEntityByQuery(Integer page, Integer limit, String jsonStr, String sort) {
        // 未审核试题总数
        String countSql = "select count(1) from " + dao.getTableName()
                + " where checkFlag = '0' and delFlag = '0'"
                + " and (substr(to_char(creationdate,'yyyy-mm-dd hh:mi:ss'),1,4) = to_char(now(),'yyyy-mm-dd hh:mi:ss'))";
        List list = dao.findByNativeSql(countSql, Integer.class);
        int total = 0;
        if (list != null && list.get(0) != null) {
            total = (Integer) list.get(0);
        }

        // 根据该试题的角色查找审核该试题的人员
        int persons = 0;
        List userIdList = new ArrayList();
        RoleBean roleBean = roleBeanService.queryByRoleName(rolename);
        if (roleBean != null) {
            userIdList = roleBeanService.getUserIdsByRoleId(roleBean.getId());
            persons = userIdList.size();
        }

        // 分给每个人的试题数
        int perCnt = 0;
        int ys = 0;
        if (persons != 0) {
            perCnt = total / persons;
            ys = total % persons;
        }

        int offset = 0;
        Long currentUserId = shiroService.getCurrentUserId();
        for (int i = 0; i < userIdList.size(); i++) {
            if (userIdList.get(i).equals(currentUserId)) {
                if (i < ys) {
                    offset = i * perCnt + 1;
                } else {
                    offset = i * perCnt;
                }
                break;
            }
        }

        //条件
        String appendWhere = "";
        Map<String, String> jsonMap = SerializeUtil.json2Map(jsonStr);
        for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
            if (entry.getValue() != null && !entry.getValue().equals("")) {
                appendWhere = appendWhere + " and " + entry.getKey() + " = " + entry.getValue();
            }
        }

        String sql = "select * from " + dao.getTableName() + " a"
                + " where checkFlag = '0' and delFlag = '0'"
                + " and (substr(to_char(creationdate,'yyyy-mm-dd hh:mi:ss'),1,4) = to_char(now(),'yyyy-mm-dd hh:mi:ss'))"
                + appendWhere
                + " order by delFlag asc, updateDate desc limit " + perCnt + " offset " + offset;

        return dao.findByNativeSql(sql, page, limit, VerseBean.class);
    }

    @Override
    public JsonStatus batchAudit(String entityIds, String reason) {
        return null;
    }

    public void setRoleBeanService(IRoleBeanService roleBeanService) {
        this.roleBeanService = roleBeanService;
    }
}
