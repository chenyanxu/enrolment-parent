package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.*;
import com.kalix.enrolment.question.entities.PaperBean;
import com.kalix.enrolment.question.entities.RuleBean;
import com.kalix.enrolment.system.dict.api.biz.IEnrolmentDictBeanService;
import com.kalix.enrolment.system.dict.entities.EnrolmentDictBean;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.util.ConfigUtil;
import com.kalix.framework.core.util.JNDIHelper;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator_ on 2018/9/17.
 */
public class QuestionCommonBizServiceImpl implements IQuestionCommonBizService {

    private static String ENROLMENT_DICT_TYPE = "题型";

    private IEnrolmentDictBeanService enrolmentDictBeanService;
    private IPaperBeanService paperBeanService;
    private IRuleBeanService ruleBeanService;

    private IRepeatedService repeatedService;
    private IQuestionService questionService;

    @Override
    public JsonData getAllRepeates() {
        JsonData jsonData = new JsonData();
        List list = new ArrayList();
        List<EnrolmentDictBean> dictBeans = enrolmentDictBeanService.getDictBeanByType(ENROLMENT_DICT_TYPE);
        for (int i = 0; i < dictBeans.size(); i++) {
            EnrolmentDictBean enrolmentDictBean = dictBeans.get(i);
            String beanName = enrolmentDictBean.getDescription();
            Map<String, String> map = new HashMap<String, String>();
            map.put("beanName", beanName);
            try {
                JsonData result = new JsonData();
                repeatedService = JNDIHelper.getJNDIServiceForName(IRepeatedService.class.getName(), map);
                result = repeatedService.getSingleRepeates("");
                if (result.getData() != null && result.getData().size() > 0) {
                    list.addAll(result.getData());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        jsonData.setData(list);
        return jsonData;
    }

    @Override
    public JsonStatus autoCreateTestPaper(Long paperId) {
        JsonStatus jsonStatus = new JsonStatus();
        try {
            Map tempMap = new HashMap<>();
            PaperBean paperBean = paperBeanService.getEntity(paperId);
            List list_rule = ruleBeanService.findByPaperId(paperId);
            List<Map> test = new ArrayList<Map>();
            for (int i = 0; i < list_rule.size(); i++) {
                RuleBean ruleBean = (RuleBean) list_rule.get(i);
                Map paper_map = new HashMap();
                paper_map.put("score", ruleBean.getQuesScore());
                paper_map.put("totalscore", ruleBean.getQuesTotalscore());
                paper_map.put("desc", ruleBean.getQuesDesc());
                paper_map.put("titlenum", ruleBean.getTitleNum());
                paper_map.put("paperid", ruleBean.getPaperId());
                String beanName = ruleBean.getQuesTypeDesc();
                Map<String, String> map = new HashMap<String, String>();
                map.put("beanName", beanName);
                questionService = JNDIHelper.getJNDIServiceForName(IQuestionService.class.getName(), map);
                Map singleTestPaper = questionService.createSingleTestPaper(paper_map);
                test.add(singleTestPaper);
            }
            tempMap.put("quesList", test);
            jsonStatus = produceTestPaper("testPaper.ftl", tempMap);
        } catch (IOException e) {
            e.printStackTrace();
            jsonStatus.setSuccess(false);
            jsonStatus.setMsg(e.getMessage());
        }
        return jsonStatus;
    }

    private JsonStatus produceTestPaper(String fileName, Map tempMap) {
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

    public void setEnrolmentDictBeanService(IEnrolmentDictBeanService enrolmentDictBeanService) {
        this.enrolmentDictBeanService = enrolmentDictBeanService;
    }

    public void setPaperBeanService(IPaperBeanService paperBeanService) {
        this.paperBeanService = paperBeanService;
    }

    public void setRuleBeanService(IRuleBeanService ruleBeanService) {
        this.ruleBeanService = ruleBeanService;
    }
}
