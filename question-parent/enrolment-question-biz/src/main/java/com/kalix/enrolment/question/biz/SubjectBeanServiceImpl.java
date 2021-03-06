package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.IPaperQuesBeanService;
import com.kalix.enrolment.question.api.biz.IQuestionAuditService;
import com.kalix.enrolment.question.api.biz.IRepeatedService;
import com.kalix.enrolment.question.api.biz.ISubjectBeanService;
import com.kalix.enrolment.question.api.dao.ISubjectBeanDao;
import com.kalix.enrolment.question.biz.util.Constants;
import com.kalix.enrolment.question.entities.PaperQuesBean;
import com.kalix.enrolment.question.entities.QuestionSettingBean;
import com.kalix.enrolment.question.entities.SubjectBean;
import com.kalix.enrolment.system.dict.entities.EnrolmentDictBean;
import com.kalix.framework.core.api.biz.IDownloadService;
import com.kalix.framework.core.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zangyanming at 2018-09-13
 */
public class SubjectBeanServiceImpl extends QuestionGenericBizServiceImpl<ISubjectBeanDao, SubjectBean>
        implements ISubjectBeanService, IQuestionAuditService, IRepeatedService, IDownloadService {

    private static String DICT_QUESTIONVALUE = "5";
    private static String DICT_SUBTYPE = "主观题类型";
    private static String TEMP_NAME = "subject.ftl";
    private IPaperQuesBeanService paperQuesBeanService;

    @Override
    public String getQuestionType() {
        return DICT_QUESTIONVALUE;
    }

    @Override
    public String getSubTypeDictType() {
        return DICT_SUBTYPE;
    }

    @Override
    public String getQuestionTableName() {
        return this.dao.getTableName();
    }

    @Override
    public String getTempName(String subType) {
        return TEMP_NAME;
    }

    @Override
    public Map<String, Object> createSingleTestPaper(Map paperMap) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");

        Map<String, Object> singleTestPaper = new HashMap<String, Object>();
        String sql = "";
        // 创建试题标题
        String title = "";
        String year_ques="";
        // 以下需要通过参数动态获取
        Long paperId=Long.parseLong(paperMap.get("paperid").toString());
        int titleNum = Integer.parseInt(paperMap.get("titlenum").toString());

        int perScore = Integer.parseInt(paperMap.get("score").toString());
        int total = Integer.parseInt(paperMap.get("totalscore").toString());

        String questype = paperMap.get("questype").toString();
        String quesRange = paperMap.get("quesRange") == null ? "" : paperMap.get("quesRange").toString();
        if(!StringUtils.isEmpty(quesRange)){

            if(quesRange.indexOf(",")>-1){
                String[] ques=quesRange.split(",");
                    for(String ques_str:ques){
                        year_ques+="'"+ques_str+"'"+",";
                    }
                year_ques=year_ques.substring(0,year_ques.length()-1);
            }else {
                year_ques="'"+quesRange+"'";
            }
        }

        String uuid = paperMap.get("uuid").toString();
        String quesdesc=paperMap.get("quesdesc") == null ? "" : paperMap.get("quesdesc").toString();
        String subtype = paperMap.get("subtype") == null ? "" : paperMap.get("subtype").toString();
        EnrolmentDictBean enrolmentDictBean = enrolmentDictBeanService.getDictBeanByTypeAndValue(DICT_SUBTYPE, subtype);
        String titleName = enrolmentDictBean.getLabel();
        //  String titleName = "评述题";
        title = Constants.numGetChinese(titleNum) + "、" + titleName + "(每题" + perScore + "分，共" + total + "分)";
        singleTestPaper.put("title", title);
        singleTestPaper.put("quesdesc", quesdesc);
        int quesNum = total / perScore;


        if(StringUtils.isEmpty(quesRange)){
            Date year = (Date) paperMap.get("year");
            String year_str = simpleDateFormat.format(year);
            sql = "select * from enrolment_question_subject where delflag='0' and checkFlag='1' and id not in (select quesid from enrolment_question_paperques where  to_char(year, 'yyyy')='" + year_str + "' and questype='" + questype + "' and subtype='" + subtype + "')  and subtype='" + subtype + "'  order by random() limit " + quesNum;
        }else {
            sql = "select * from enrolment_question_subject where delflag='0' and  to_char(year, 'yyyy') in (" + year_ques + ") and checkFlag='1' and id not in (select quesid from enrolment_question_paperques where  to_char(year, 'yyyy') in (" + year_ques + ") and questype='" + questype + "' and subtype='" + subtype + "')  and subtype='" + subtype + "'  order by random() limit " + quesNum;
        }


        // 创建试题内容
        List<Map<String, Object>> question = new ArrayList<Map<String, Object>>();
        // 以下需要通过算法动态获取（抽取试题）
        List<SubjectBean> list = this.dao.findByNativeSql(sql, SubjectBean.class);
        if (list.size() == quesNum) {
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> map = new HashMap<String, Object>();
                SubjectBean subjectBean = list.get(i);
                PaperQuesBean paperQuesBean = new PaperQuesBean();
                map.put("answerConstraint", subjectBean.getAnswerConstraint());
                map.put("type", "论述题");
                map.put("stem", subjectBean.getStem());
                paperQuesBean.setQuesid(subjectBean.getId());
                paperQuesBean.setYear(subjectBean.getYear());
                paperQuesBean.setQuesType(questype);
                paperQuesBean.setSubType(subtype);
                paperQuesBean.setUuid(uuid);
                paperQuesBean.setPaperId(paperId);
                paperQuesBeanService.saveEntity(paperQuesBean);
                question.add(map);
            }
        }

        singleTestPaper.put("question", question);
        return singleTestPaper;
    }

    @Override
    public boolean getCompareStatus() {
        QuestionSettingBean questionSettingBean = questionSettingBeanService.getEntity(1L);
        boolean compareStatus = questionSettingBean.getCompareSubject() == null ? true : questionSettingBean.getCompareSubject();
        return compareStatus;
    }

    @Override
    public int updateCompareStatus(Long id, Boolean compareStatus) {
        return questionSettingBeanService.updateCompareSubject(id, compareStatus);
    }

    @Override
    public String[] createDownloadFile(Long entityId, String fileType) {
        String[] str = new String[2];
        SubjectBean subjectBean = this.getEntity(entityId);
        Map dataMap = new HashMap();
        dataMap.put("stem", subjectBean.getStem());

        Map tempMap = new HashMap();
        // tempMap.put("title", "主观题");
        tempMap.put("question", dataMap);

        str[0] = "主观题";
        str[1] = this.createSinglePreview(tempMap, subjectBean.getSubType());
        return str;
    }

    public void setPaperQuesBeanService(IPaperQuesBeanService paperQuesBeanService) {
        this.paperQuesBeanService = paperQuesBeanService;
    }
}
