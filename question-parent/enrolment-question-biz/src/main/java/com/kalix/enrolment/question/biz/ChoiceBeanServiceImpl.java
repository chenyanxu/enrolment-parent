package com.kalix.enrolment.question.biz;

import com.kalix.admin.core.api.biz.IRoleBeanService;
import com.kalix.admin.core.entities.RoleBean;
import com.kalix.enrolment.question.api.biz.IChoiceBeanService;
import com.kalix.enrolment.question.api.biz.IFreemarkerService;
import com.kalix.enrolment.question.api.dao.IChoiceBeanDao;
import com.kalix.enrolment.question.entities.ChoiceBean;
import com.kalix.framework.core.api.biz.IDownloadService;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.util.ConfigUtil;
import com.kalix.framework.core.util.StringUtils;
import com.kalix.framework.extend.impl.biz.LogicDeleteGenericBizServiceImpl;
import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import freemarker.template.Template;
import org.osgi.framework.BundleContext;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zangyanming at 2018-09-13
 */
public class ChoiceBeanServiceImpl extends LogicDeleteGenericBizServiceImpl<IChoiceBeanDao, ChoiceBean> implements IChoiceBeanService,IDownloadService,IFreemarkerService {

    private IRoleBeanService roleBeanService;
    private static String rolename = "选择题出题人";

    @Override
    public JsonData getAllEntityByQuery(Integer page, Integer limit, String jsonStr, String sort) {
        JsonData jsonData = new JsonData();
        if (StringUtils.isEmpty(sort)) {
            sort = "[{'property': 'delFlag', 'direction': 'ASC'},{'property': 'updateDate', 'direction': 'DESC'}]";
        }

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
        if(roleBean != null){
            userIdList = roleBeanService.getUserIdsByRoleId(roleBean.getId());
            persons = userIdList.size();
        }

        // 分给每个人的试题数
        int perCnt = 0;
        if (persons != 0) {
            perCnt = total / persons;
        }

        int ys = total % persons;

        int lpoint = 0;
        Long currentUserId = shiroService.getCurrentUserId();
        for (int i = 0; i < userIdList.size(); i++) {
            if (userIdList.get(i).equals(currentUserId)) {
                if (i < ys) {
                    lpoint = i * perCnt + 1;
                } else {
                    lpoint = i * perCnt;
                }
                break;
            }
        }

        String sql = "select * from " + dao.getTableName()
                + " where checkFlag = '0' and delFlag = '0'"
                + " and (substr(to_char(creationdate,'yyyy-mm-dd hh:mi:ss'),1,4) = to_char(now(),'yyyy-mm-dd hh:mi:ss'))"
                + " order by id limit " + perCnt + " offset " + lpoint;

        jsonData = dao.findByNativeSql(sql, page, limit, ChoiceBean.class);

        return jsonData;
        //return super.getAllEntityByQuery(page, limit, jsonStr, sort);
    }

    @Override
    public JsonData getAllCheckEntityByQuery(Integer page, Integer limit, String jsonStr, String sort) {

        return getAllEntityByQuery(page, limit, jsonStr, sort);
    }

    @Override
    public JsonStatus batchAudit(String entityIds, String reason) {
        JsonStatus jsonStatus = new JsonStatus();
        jsonStatus.setSuccess(true);

        return jsonStatus;
    }

    public void setRoleBeanService(IRoleBeanService roleBeanService) {
        this.roleBeanService = roleBeanService;
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
            //test.ftl为要装载的模板
            t = configuration.getTemplate(fileName,"utf-8");
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

    @Override
    public String[] createDownloadFile(Long entityId, String fileType) {

        ChoiceBean choiceBean = this.getEntity(entityId);

        Map dataMap = new HashMap();
        Map tempMap= new HashMap();
        dataMap.put("stem",choiceBean.getStem());
        dataMap.put("answerA",choiceBean.getAnswerA());
        dataMap.put("answerB",choiceBean.getAnswerB());
        dataMap.put("answerC",choiceBean.getAnswerC());
        dataMap.put("answerD",choiceBean.getAnswerD());

        // List question = new ArrayList();
        //  question.add(dataMap);
        tempMap = new HashMap<>();
        tempMap.put("title","选择题");
        tempMap.put("question",dataMap);
        String[] str = new String[2];
        str[0] = "123";
        str[1] = this.createDoc("choice.ftl",tempMap);
        return str;
    }

}
