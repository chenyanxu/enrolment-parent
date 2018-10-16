package com.kalix.enrolment.question.biz;

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

/**
 * Created by angyanming at 2018-09-13
 */
public class ChoiceBeanServiceImpl extends LogicDeleteGenericBizServiceImpl<IChoiceBeanDao, ChoiceBean> implements IChoiceBeanService,IDownloadService,IFreemarkerService {

    private BundleContext bundleContext;
    @Override
    public JsonData getAllEntityByQuery(Integer page, Integer limit, String jsonStr, String sort) {
        if (StringUtils.isEmpty(sort)) {
            sort = "[{'property': 'delFlag', 'direction': 'ASC'},{'property': 'updateDate', 'direction': 'DESC'}]";
        }
        return super.getAllEntityByQuery(page, limit, jsonStr, sort);
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
    public BundleContext getBundleContext() {
        return bundleContext;
    }
    public void setBundleContext(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
    }
}
