package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.IChoiceBeanService;
import com.kalix.enrolment.question.api.biz.IPaperQuesBeanService;
import com.kalix.enrolment.question.api.biz.IQuestionAuditService;
import com.kalix.enrolment.question.api.biz.IRepeatedService;
import com.kalix.enrolment.question.api.dao.IChoiceBeanDao;
import com.kalix.enrolment.question.biz.util.Constants;
import com.kalix.enrolment.question.dto.model.CompareQuestionDTO;
import com.kalix.enrolment.question.dto.model.QuestionDTO;
import com.kalix.enrolment.question.entities.ChoiceBean;
import com.kalix.enrolment.question.entities.PaperQuesBean;
import com.kalix.enrolment.question.entities.QuestionSettingBean;
import com.kalix.framework.core.api.biz.IDownloadService;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.util.SerializeUtil;
import com.kalix.framework.core.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zangyanming at 2018-09-13
 */
public class ChoiceBeanServiceImpl extends QuestionGenericBizServiceImpl<IChoiceBeanDao, ChoiceBean>
        implements IChoiceBeanService, IQuestionAuditService, IRepeatedService, IDownloadService {

    private static String DICT_QUESTIONVALUE = "2";
    private static String DICT_SUBTYPE = "";
    private static String TEMP_NAME = "choice.ftl";
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
    public Map<String, Object> createSingleTestPaper(Map paperMap) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");

        Map<String, Object> singleTestPaper = new HashMap<String, Object>();
        String sql = "";
        // 创建试题标题
        String title = "";
        // 以下需要通过参数动态获取
        Long paperId = Long.parseLong(paperMap.get("paperid").toString());
        int titleNum = Integer.parseInt(paperMap.get("titlenum").toString());
        String titleName = paperMap.get("questypename").toString();
        int perScore = Integer.parseInt(paperMap.get("score").toString());
        int total = Integer.parseInt(paperMap.get("totalscore").toString());
        String uuid = paperMap.get("uuid").toString();
        String questype = paperMap.get("questype").toString();
        String quesdesc=paperMap.get("quesdesc") == null ? "" : paperMap.get("quesdesc").toString();
        String subtype = paperMap.get("subtype") == null ? "" : paperMap.get("subtype").toString();
        String typeCount=paperMap.get("typeCount") == null ? "" : paperMap.get("typeCount").toString();
        title = Constants.numGetChinese(titleNum) + "、" + titleName + "(每题" + perScore + "分，共" + total + "分)";
        singleTestPaper.put("title", title);
        singleTestPaper.put("quesdesc", quesdesc);

        int quesNum = 0;
        int typeNum=0;
        List<ChoiceBean> list=new ArrayList<>();
        Date year = (Date) paperMap.get("year");
        String year_str = simpleDateFormat.format(year);
        if(StringUtils.isEmpty(typeCount)) {

            quesNum = total / perScore;
            sql = "select * from enrolment_question_Choice where checkFlag='1' and id not in (select quesid from enrolment_question_paperques where  to_char(year, 'yyyy')='" + year_str + "' and questype='" + questype + "' and subtype='" + subtype + "') order by random() limit " + quesNum;
            list = this.dao.findByNativeSql(sql, ChoiceBean.class);
        }else {
            String [] ques=typeCount.split(";");
            for(int i=0;i<ques.length;i++){
                String[] str=ques[i].split(",");
                sql = "select * from enrolment_question_Choice where checkFlag='1' and type='"+str[0]+"' and id not in (select quesid from enrolment_question_paperques where  to_char(year, 'yyyy')='" + year_str + "' and questype='" + questype + "' and subtype='" + subtype + "') order by random() limit " + str[1];
                typeNum = Integer.parseInt(str[1]) / perScore;
                quesNum+=typeNum;
                List<ChoiceBean> list_1 = this.dao.findByNativeSql(sql, ChoiceBean.class);
                list.addAll(list_1);
            }
        }

        // 创建试题内容
        List<Map<String, Object>> question = new ArrayList<Map<String, Object>>();
        // 以下需要通过算法动态获取（抽取试题）

        if (list.size() == quesNum) {
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
                paperQuesBean.setUuid(uuid);
                paperQuesBean.setPaperId(paperId);
                paperQuesBeanService.saveEntity(paperQuesBean);
                question.add(map);
            }
        }

        singleTestPaper.put("question", question);
        //备用试题
       // SpareQues(singleTestPaper,year_str, questype, subtype);
        return singleTestPaper;
    }


    public void  SpareQues(Map<String, Object> singleTestPaper,String year_str,String questype,String subtype){
        String pattern = "(?<=\\[#).*?(?=\\])";
        // 编译正则
        List<Map<String, Object>> question = new ArrayList<Map<String, Object>>();
        String sql = "select * from enrolment_question_Choice where checkFlag='1' and id not in (select quesid from enrolment_question_paperques where  to_char(year, 'yyyy')='" + year_str + "' and questype='" + questype + "' and subtype='" + subtype + "') order by random() limit 5";
        List<ChoiceBean> list = this.dao.findByNativeSql(sql, ChoiceBean.class);
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            ChoiceBean choiceBean = list.get(i);
            map.put("type", "选择题");
            map.put("stem", choiceBean.getStem());
            map.put("answerA", choiceBean.getAnswerA());
            map.put("answerB", choiceBean.getAnswerB());
            map.put("answerC", choiceBean.getAnswerC());
            map.put("answerD", choiceBean.getAnswerD());
            question.add(map);

        }
        singleTestPaper.put("SpareQues",question);
    }

    @Override
    public boolean getCompareStatus() {
        QuestionSettingBean questionSettingBean = questionSettingBeanService.getEntity(1L);
        boolean compareStatus = questionSettingBean.getCompareChoice() == null ? true : questionSettingBean.getCompareChoice();
        return compareStatus;
    }

    @Override
    public int updateCompareStatus(Long id, Boolean compareStatus) {
        return questionSettingBeanService.updateCompareChoice(id, compareStatus);
    }

    @Override
    public JsonData validateRepeates(CompareQuestionDTO compareQuestionDTO) {
        JsonData jsonData = new JsonData();
        Long questionId = compareQuestionDTO.getQuestionId() == null ? 0 : compareQuestionDTO.getQuestionId();
        String stem = compareQuestionDTO.getStem();
        String sql = "";
        if (questionId > 0) {
            sql = "select t.* from " + dao.getTableName() + " t " +
                    " where t.delFlag = '0' and t.checkFlag <> '2' and t.id <> " + questionId;
        } else {
            sql = "select t.* from " + dao.getTableName() + " t " +
                    " where t.delFlag = '0' and t.checkFlag <> '2'";
        }
        List list = dao.findByNativeSql(sql, ChoiceBean.class);
        double similarity = this.getSimilarity();
        List repeateList = this.doRepeat(stem, list, similarity);

        jsonData.setData(repeateList);
        jsonData.setTotalCount((long) repeateList.size());
        return jsonData;
    }

    protected String getFirstQuestionsSQL(StringBuilder jsonStrB, StringBuilder dataAuthStrB) {
        StringBuilder sqlStrB = new StringBuilder();
        String questionType = this.getQuestionType();
        String questionTypeName = this.getQuestionTypeName();
        String questionBeans = this.getQuestionBeans();
        // String subTypeDictType = this.getSubTypeDictType();
        String selectStr = "select '" + questionType + "' as questiontype, '" + questionTypeName +
                "' as questiontypename, '" + questionBeans + "' as questionbeans, y.subtype, y.id, y.id as questionId, " +
                " y.stem, y.analysis, y.checkflag, y.checkerid, y.checker, y.checkdate, y.checkreason, y.repeatedflag, " +
                " y.delflag, y.reason, y.compareFlag, y.createby, y.creationdate, y.updateby, y.updatedate, " +
                " d.label as typename, y.answera, y.answerb, y.answerc, y.answerd ";
        sqlStrB.append(selectStr);
        /*if (StringUtils.isNotEmpty(subTypeDictType)) {
            sqlStrB.append(", d2.label as subtypename ");
        }*/
        sqlStrB.append("from " + this.dao.getTableName() + " y ");
        sqlStrB.append("left join enrolment_dict d on d.type = '" + DICT_TYPE + "' and d.value = y.type ");
        /*if (StringUtils.isNotEmpty(subTypeDictType)) {
            sqlStrB.append("left join enrolment_dict d2 on d2.type = '" + subTypeDictType + "' and d2.value = y.subtype ");
        }*/
        sqlStrB.append("where y.delflag = '0' and y.repeatedflag = '0' and y.compareflag = '1' ");
        if (jsonStrB.length() > 0) {
            sqlStrB.append(jsonStrB.toString());
        }
        if (dataAuthStrB.length() > 0) {
            sqlStrB.append(dataAuthStrB.toString());
        }
        sqlStrB.append(" and y.id in (select distinct r.firstquestionid from " + this.questionRepeatedBeanDao.getTableName() + " r " +
                "where r.questiontype = '" + questionType + "' and r.similarity > " +
                "(select s.similarity from enrolment_question_setting s where s.id = 1)) ");
        sqlStrB.append("order by y.subType, y.type, y.id");
        return sqlStrB.toString();
    }

    protected String getSecondQuestionsSQL(Long firstQuestionId) {
        StringBuilder sqlStrB = new StringBuilder();
        String questionType = this.getQuestionType();
        String questionTypeName = this.getQuestionTypeName();
        String questionBeans = this.getQuestionBeans();
        String subTypeDictType = this.getSubTypeDictType();
        String selectStr = "select '" + questionType + "' as questiontype, '" + questionTypeName +
                "' as questiontypename, '" + questionBeans + "' as questionbeans, y.subtype, y.id, y.id as questionId, " +
                " y.stem, y.analysis, y.checkflag, y.checkerid, y.checker, y.checkdate, y.checkreason, y.repeatedflag, " +
                " y.delflag, y.reason, y.compareFlag, y.createby, y.creationdate, y.updateby, y.updatedate, " +
                " r.similarity, r.similaritydesc, d.label as typename, y.answera, y.answerb, y.answerc, y.answerd ";
        sqlStrB.append(selectStr);
        if (StringUtils.isNotEmpty(subTypeDictType)) {
            sqlStrB.append(", d2.label as subtypename ");
        }
        sqlStrB.append("from " + this.dao.getTableName() + " y ");
        sqlStrB.append("left join enrolment_dict d on d.type = '" + DICT_TYPE + "' and d.value = y.type ");
        if (StringUtils.isNotEmpty(subTypeDictType)) {
            sqlStrB.append("left join enrolment_dict d2 on d2.type = '" + subTypeDictType + "' and d2.value = y.subtype ");
        }
        sqlStrB.append(", " + this.questionRepeatedBeanDao.getTableName() + " r ");
        sqlStrB.append("where y.delflag = '0' and y.id = r.secondquestionid and r.questiontype = '" + questionType +
                "' and r.firstquestionid = " + firstQuestionId + " and r.similarity > " +
                "(select s.similarity from enrolment_question_setting s where s.id = 1) ");
        sqlStrB.append("order by r.similarity desc, y.subtype, y.type, y.id");
        return sqlStrB.toString();
    }

    @Override
    public String[] createDownloadFile(Long entityId, String fileType) {
        String[] str = new String[2];
        ChoiceBean choiceBean = this.getEntity(entityId);
        Map dataMap = new HashMap();
        dataMap.put("stem", choiceBean.getStem());
        dataMap.put("answerA", choiceBean.getAnswerA());
        dataMap.put("answerB", choiceBean.getAnswerB());
        dataMap.put("answerC", choiceBean.getAnswerC());
        dataMap.put("answerD", choiceBean.getAnswerD());

        Map tempMap = new HashMap();
        // tempMap.put("title", "选择题");
        tempMap.put("question", dataMap);

        str[0] = "单项选择题";
        str[1] = this.createSinglePreview(tempMap, "");
        return str;
    }

    public void setPaperQuesBeanService(IPaperQuesBeanService paperQuesBeanService) {
        this.paperQuesBeanService = paperQuesBeanService;
    }
}
