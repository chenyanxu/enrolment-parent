package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.ITestPaperService;
import com.kalix.enrolment.question.api.dao.IChoiceBeanDao;
import com.kalix.enrolment.question.api.dao.ICompletionBeanDao;
import com.kalix.enrolment.question.api.dao.IVerseBeanDao;
import com.kalix.enrolment.question.biz.util.Constants;
import com.kalix.enrolment.question.dto.model.QuestionDto;
import com.kalix.enrolment.question.dto.model.QuestionTypeDTO;
import com.kalix.enrolment.question.entities.ChoiceBean;
import com.kalix.enrolment.question.entities.CompletionBean;
import com.kalix.enrolment.question.entities.VerseBean;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.api.security.IShiroService;
import com.kalix.framework.core.util.ConfigUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zangyanming at 2018-09-13.
 */
public class TestPaperServiceImpl   implements ITestPaperService {

    private IShiroService shiroService;
    private IVerseBeanDao verseBeanDao;
    private IChoiceBeanDao choiceBeanDao;
    private ICompletionBeanDao completionBeanDao;

    public void setShiroService(IShiroService shiroService) {
        this.shiroService = shiroService;
    }

    public void setVerseBeanDao(IVerseBeanDao verseBeanDao) {
        this.verseBeanDao = verseBeanDao;
    }

    public void setChoiceBeanDao(IChoiceBeanDao choiceBeanDao) {
        this.choiceBeanDao = choiceBeanDao;
    }

    public void setCompletionBeanDao(ICompletionBeanDao completionBeanDao) {
        this.completionBeanDao = completionBeanDao;
    }
    @Override
    public JsonStatus createTestPaper()
    {
        Map<String,Object> resultMap=new HashMap<>();
        JsonStatus jsonStatus = new JsonStatus();
        int eqtCount=3; //题型个数
        //写入所有题目
        //试卷题型信息--已经按照题型排列顺序排列
        List<QuestionDto> eqtList= new ArrayList<QuestionDto>();
        List<Map<String,Object>> quesList=new ArrayList<>();
       // List<Map<String, String>> answerList=new ArrayList<>();
        QuestionDto tempEqt_completion = new QuestionDto();//试卷中题型
        tempEqt_completion.setQuestionNum(15l);
        tempEqt_completion.setTypeScore(1l);
        eqtList.add(tempEqt_completion);

        QuestionDto tempEqt_choice = new QuestionDto();//试卷中题型
        tempEqt_choice.setQuestionNum(15l);
        tempEqt_choice.setTypeScore(1l);
        eqtList.add(tempEqt_choice);

        QuestionDto tempEqt_verse = new QuestionDto();//试卷中题型
        tempEqt_verse.setQuestionNum(5l);
        tempEqt_verse.setTypeScore(5l);
        eqtList.add(tempEqt_verse);


        QuestionDto tempEqt;//试卷中题型
        QuestionTypeDTO qto;


        List qList;//试题列表
        List<Map<String, Object>> question;
        Map<String, Object> tempQuestionMap;//临时存放问题详情Map
        Map<String, Object> tempMap;//临时存放试卷中所有题型

        for(int i=0;i<eqtCount;i++){
            question=new ArrayList<>();
            qList=new ArrayList<>();
            tempMap = new HashMap<>();
            tempEqt=eqtList.get(i);//当前试题类型

            if(i==0)
            {
                qList=completionBeanDao.getAll();
                qto= new QuestionTypeDTO();
                qto.settTitle("填空题");
            }else if(i==1){
                qList=choiceBeanDao.getAll();
                qto= new QuestionTypeDTO();
                qto.settTitle("选择题");
            }else {
                qList=verseBeanDao.getAll();
                qto= new QuestionTypeDTO();
                qto.settTitle("补全诗句");
            }


            String title= Constants.numGetChinese(i+1)+"、"+qto.gettTitle()+"共"+qList.size()+"题，每题"+tempEqt.getTypeScore()+"分，共计"+qList.size()*tempEqt.getTypeScore()+"分";
            tempMap.put("title",title);
            for(int j=0;j<qList.size();j++) {
                tempQuestionMap = new HashMap<>();
                if(i==1)
                {
                    ChoiceBean choiceBean = (ChoiceBean) qList.get(j);
                    tempQuestionMap.put("type","选择题");
                    tempQuestionMap.put("stem", choiceBean.getStem());
                    tempQuestionMap.put("answerA", choiceBean.getAnswerA());
                    tempQuestionMap.put("answerB", choiceBean.getAnswerB());
                    tempQuestionMap.put("answerC", choiceBean.getAnswerC());
                    tempQuestionMap.put("answerD", choiceBean.getAnswerD());
                    question.add(tempQuestionMap);

                }else if(i==0)
                {
                    CompletionBean ompletion = (CompletionBean) qList.get(j);
                    tempQuestionMap.put("type","填空题");
                    tempQuestionMap.put("stem", ompletion.getStem());
                    question.add(tempQuestionMap);
                }
                else
                {
                    VerseBean verse = (VerseBean) qList.get(j);
                    tempQuestionMap.put("type","填空题");
                    tempQuestionMap.put("stem", verse.getStem());
                    question.add(tempQuestionMap);
                }

            }
            tempMap.put("question",question);
            quesList.add(tempMap);
        }
        resultMap.put("quesList", quesList);
        this.createTestPaper("testPaper.ftl",resultMap);
        return jsonStatus;
    }

    @Override
    public JsonStatus createTestPaper(String fileName, Map tempMap)
    {
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
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String testPaperName= sdf.format(new Date());

            File outFile = new File("d:\\"+testPaperName+".doc");
            Writer out = null;
            FileOutputStream fos=null;
            fos = new FileOutputStream(outFile);
            OutputStreamWriter oWriter = new OutputStreamWriter(fos,"UTF-8");
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
}
