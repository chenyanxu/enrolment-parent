package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.*;
import com.kalix.enrolment.question.dto.model.RuleDto;
import com.kalix.enrolment.question.entities.PaperBean;
import com.kalix.enrolment.system.dict.api.biz.IEnrolmentDictBeanService;
import com.kalix.enrolment.system.dict.entities.EnrolmentDictBean;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.util.ConfigUtil;
import com.kalix.framework.core.util.JNDIHelper;
import com.kalix.middleware.couchdb.api.biz.ICouchdbService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator_ on 2018/9/17.
 */
public class QuestionCommonBizServiceImpl implements IQuestionCommonBizService {

    protected static String DICT_QUESTIONTYPE = "题型";
    private ICouchdbService couchdbService;
    private IEnrolmentDictBeanService enrolmentDictBeanService;
    private IPaperBeanService paperBeanService;
    private IRuleBeanService ruleBeanService;

    private IRepeatedService repeatedService;
    private IQuestionService questionService;

    @Override
    public JsonData getAllRepeates() {
        JsonData jsonData = new JsonData();
        List list = new ArrayList();
        List<EnrolmentDictBean> dictBeans = enrolmentDictBeanService.getDictBeanByType(DICT_QUESTIONTYPE);
        for (int i = 0; i < dictBeans.size(); i++) {
            EnrolmentDictBean enrolmentDictBean = dictBeans.get(i);
            String questionType = enrolmentDictBean.getValue();
            String subTypeDictType = enrolmentDictBean.getSubType();
            String beanName = enrolmentDictBean.getDescription();
            Map<String, String> map = new HashMap<String, String>();
            map.put("beanName", beanName);
            try {
                List result = new ArrayList<>();
                repeatedService = JNDIHelper.getJNDIServiceForName(IRepeatedService.class.getName(), map);
                if (StringUtils.isEmpty(subTypeDictType)) {
                    result = repeatedService.getSingleRepeates(questionType, "");
                    if (result != null && result.size() > 0) {
                        list.addAll(result);
                    }
                } else {
                    List<EnrolmentDictBean> subDictBeans = enrolmentDictBeanService.getDictBeanByType(subTypeDictType);
                    for (int j = 0; j < subDictBeans.size(); j++) {
                        EnrolmentDictBean subDictBean = subDictBeans.get(j);
                        result = repeatedService.getSingleRepeates(questionType, subDictBean.getValue());
                        if (result != null && result.size() > 0) {
                            list.addAll(result);
                        }
                    }
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
            int copies = 1;
            int  total=0;
            //成卷结果
            String doPaperRes="T";
            List<Map> quesList =null;
            Map tempMap = new HashMap<>();
            PaperBean paperBean = paperBeanService.getEntity(paperId);
            Date year = paperBean.getYear();
            int paperTotal=paperBean.getTotalMark();
            List<RuleDto> list_rule = ruleBeanService.findByPaperId(paperId);
            for(RuleDto rule1Bean:list_rule){
                total+=rule1Bean.getQuesTotalscore();
            }
            if(total==paperTotal)
            {

                if(paperBean.getCopies()>1)
                {
                    copies=paperBean.getCopies();
                }
                for(int j=0;j<copies;j++){
                    quesList=new ArrayList<Map>();
                    for (int i = 0; i < list_rule.size(); i++) {
                        RuleDto ruleBean = (RuleDto) list_rule.get(i);
                        Map paper_map = new HashMap();
                        paper_map.put("year", year);
                        paper_map.put("score", ruleBean.getQuesScore());
                        paper_map.put("totalscore", ruleBean.getQuesTotalscore());
                        paper_map.put("desc", ruleBean.getQuesDesc());
                        paper_map.put("titlenum", ruleBean.getTitleNum());
                        paper_map.put("paperid", ruleBean.getPaperId());
                        paper_map.put("questype", ruleBean.getQuesType());
                        paper_map.put("subtype", ruleBean.getSubType());
                        paper_map.put("questypename", ruleBean.getQuesTypeName());
                        String beanName = ruleBean.getQuesTypeDesc();
                        Map<String, String> map = new HashMap<String, String>();
                        map.put("beanName", beanName);
                        questionService = JNDIHelper.getJNDIServiceForName(IQuestionService.class.getName(), map);
                        Map singleTestPaper = questionService.createSingleTestPaper(paper_map);
                       List list_ques= (List)singleTestPaper.get("question");
                       if(list_ques==null||list_ques.size()==0)
                       {
                           doPaperRes="F";
                           break;
                       }
                        quesList.add(singleTestPaper);
                    }
                    if("F".equals(doPaperRes)){
                        jsonStatus.setSuccess(false);
                        jsonStatus.setMsg("试题数量不足，成卷失败!");
                    }else {
                        tempMap.put("quesList", quesList);
                        jsonStatus = produceTestPaper("testPaper.ftl", tempMap);
                    }

                }

            }else {
                jsonStatus.setSuccess(false);
                jsonStatus.setMsg("试卷分数与参数分数不符，请核对后重新提交！");
            }

        } catch (IOException e) {
            e.printStackTrace();
            jsonStatus.setSuccess(false);
            jsonStatus.setMsg(e.getMessage());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonStatus;
    }

    @Override
    public JsonStatus autoCreateTestPaper() {
        return null;
    }

    private JsonStatus produceTestPaper(String fileName, Map tempMap) throws IOException {
        JsonStatus jsonStatus = new JsonStatus();

        Configuration configuration = new Configuration();
        File outFile = null;
        //dataMap 要填入模本的数据文件
        //设置模本装置方法和路径,
        Template t = null;
        Writer out = null;
        FileOutputStream fos = null;
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
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String testPaperName = sdf.format(new Date());


            outFile = new File("d:\\" + testPaperName + ".doc");


            fos = new FileOutputStream(outFile);
            OutputStreamWriter oWriter = new OutputStreamWriter(fos, "UTF-8");
            //这个地方对流的编码不可或缺，使用main（）单独调用时，应该可以，但是如果是web请求导出时导出后word文档就会打不开，并且包XML文件错误。主要是编码格式不正确，无法解析。
            //out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
            out = new BufferedWriter(oWriter);
            t.process(tempMap, out);

            jsonStatus.setSuccess(true);
            jsonStatus.setMsg("试卷生成成功!");
            if(outFile.exists())
            {
                InputStream input = new FileInputStream(outFile);
                couchdbService.addAttachment(input,
                        testPaperName + ".doc", "application/vnd.ms-word");
            }


        } catch (Exception e) {
            //logger.error("导出出错", e);
            e.printStackTrace();
            // throw new BusinessException(CommonResultEnum.COMMON_ERROR_637);
        } finally {
            outFile.delete();
            out.close();
            fos.close();
        }
        return jsonStatus;
    }

    public void setEnrolmentDictBeanService(IEnrolmentDictBeanService enrolmentDictBeanService) {
        this.enrolmentDictBeanService = enrolmentDictBeanService;
    }

    public void setCouchdbService(ICouchdbService couchdbService) {
        this.couchdbService = couchdbService;
    }

    public void setPaperBeanService(IPaperBeanService paperBeanService) {
        this.paperBeanService = paperBeanService;
    }

    public void setRuleBeanService(IRuleBeanService ruleBeanService) {
        this.ruleBeanService = ruleBeanService;
    }

}
