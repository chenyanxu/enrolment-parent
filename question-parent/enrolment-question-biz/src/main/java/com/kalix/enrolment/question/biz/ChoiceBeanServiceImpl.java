package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.IChoiceBeanService;
import com.kalix.enrolment.question.api.biz.IPaperQuesBeanService;
import com.kalix.enrolment.question.api.dao.IChoiceBeanDao;
import com.kalix.enrolment.question.biz.util.Constants;
import com.kalix.enrolment.question.entities.ChoiceBean;
import com.kalix.enrolment.question.entities.PaperQuesBean;
import com.kalix.framework.core.api.biz.IDownloadService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zangyanming at 2018-09-13
 */
public class ChoiceBeanServiceImpl extends QuestionGenericBizServiceImpl<IChoiceBeanDao, ChoiceBean>
        implements IChoiceBeanService, IDownloadService {

    private static String AUDIT_ROLE_NAME = "选择题审核人";
    private static String TEMP_NAME = "choice.ftl";
    private IPaperQuesBeanService paperQuesBeanService;

    public void setPaperQuesBeanService(IPaperQuesBeanService paperQuesBeanService) {
        this.paperQuesBeanService = paperQuesBeanService;
    }

    @Override
    public String getAuditRoleName(String subType) {
        return AUDIT_ROLE_NAME;
    }

    @Override
    public String getTempName(String subType) {
        return TEMP_NAME;
    }

    @Override
    public Map<String, Object> createSingleTestPaper(Map paperMap) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");

        Map<String, Object> singleTestPaper = new HashMap<String, Object>();
        String sql="";
        // 创建试题标题
        String title = "";
        // 以下需要通过参数动态获取
        int titleNum = Integer.parseInt(paperMap.get("titlenum").toString()) ;
        String titleName = "单项选择题";
        int perScore =  Integer.parseInt(paperMap.get("score").toString());
        int total =  Integer.parseInt(paperMap.get("totalscore").toString());

        String questype =  paperMap.get("questype").toString();
        String subtype = paperMap.get("subtype")==null?"":paperMap.get("subtype").toString();

        title = Constants.numGetChinese(titleNum) + "、" + titleName + "(每题" + perScore + "分，共" + total + "分)";
        singleTestPaper.put("title", title);
        int quesNum = total / perScore;

        Date year=(Date)paperMap.get("year");
        String year_str=simpleDateFormat.format(year);
        sql = "select * from enrolment_question_Choice where id not in (select quesid from enrolment_question_paperques where  to_char(year, 'yyyy')='"+year_str+"' and questype='"+questype+"' and subtype='"+subtype+"') order by random() limit " + quesNum;

        // 创建试题内容
        List<Map<String, Object>> question = new ArrayList<Map<String, Object>>();
        // 以下需要通过算法动态获取（抽取试题）
        List<ChoiceBean> list = this.dao.findByNativeSql(sql, ChoiceBean.class);
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            ChoiceBean choiceBean = list.get(i);
            PaperQuesBean paperQuesBean = new PaperQuesBean();
            map.put("type", "选择题");
            map.put("stem", choiceBean.getStem());
            map.put("answerA", choiceBean.getAnswerA());
            map.put("answerB", choiceBean.getAnswerB());
            map.put("answerC", choiceBean.getAnswerC());
            map.put("answerD", choiceBean.getAnswerD());
            paperQuesBean.setQuesid(choiceBean.getId());
            paperQuesBean.setYear(year);
            paperQuesBean.setQuesType(questype);
            paperQuesBean.setSubType(subtype);
            paperQuesBeanService.saveEntity(paperQuesBean);
            question.add(map);
        }
        singleTestPaper.put("question", question);

        return singleTestPaper;
    }

    @Override
    public String[] createDownloadFile(Long entityId, String fileType) {
        String[] str = new String[2];
        ChoiceBean choiceBean = this.getEntity(entityId);
        Map dataMap = new HashMap();
        Map tempMap = new HashMap();
        dataMap.put("stem", choiceBean.getStem());
        dataMap.put("answerA", choiceBean.getAnswerA());
        dataMap.put("answerB", choiceBean.getAnswerB());
        dataMap.put("answerC", choiceBean.getAnswerC());
        dataMap.put("answerD", choiceBean.getAnswerD());

        tempMap = new HashMap<>();
        tempMap.put("title", "选择题");
        tempMap.put("question", dataMap);

        str[0] = "123";
        str[1] = this.createSinglePreview(tempMap, "");
        return str;
    }
}
