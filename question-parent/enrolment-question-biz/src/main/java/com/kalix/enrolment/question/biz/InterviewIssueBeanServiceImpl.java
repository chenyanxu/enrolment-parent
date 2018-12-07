package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.IInterviewIssueBeanService;
import com.kalix.enrolment.question.api.biz.IPaperQuesBeanService;
import com.kalix.enrolment.question.api.biz.IQuestionAuditService;
import com.kalix.enrolment.question.api.biz.IRepeatedService;
import com.kalix.enrolment.question.api.dao.IInterviewIssueBeanDao;
import com.kalix.enrolment.question.biz.util.Constants;
import com.kalix.enrolment.question.entities.InterviewIssueBean;
import com.kalix.enrolment.question.entities.PaperQuesBean;
import com.kalix.enrolment.question.entities.QuestionSettingBean;
import com.kalix.framework.core.api.biz.IDownloadService;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zangyanming at 2018-09-13
 */
public class InterviewIssueBeanServiceImpl extends QuestionGenericBizServiceImpl<IInterviewIssueBeanDao, InterviewIssueBean>
        implements IInterviewIssueBeanService, IQuestionAuditService, IRepeatedService, IDownloadService {

    private static String DICT_QUESTIONVALUE = "6";
    private static String DICT_SUBTYPE = "面试题类型";
    private static String TEMP_NAME = "Interview.ftl";
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
        // 以下需要通过参数动态获取
        Long paperId = Long.parseLong(paperMap.get("paperid").toString());
        String uuid = paperMap.get("uuid").toString();
        String subtype = paperMap.get("subtype") == null ? "" : paperMap.get("subtype").toString();
        String kskm = paperMap.get("kskm").toString();
        //title = Constants.numGetChinese(titleNum) + "、" + titleName + "(每题" + perScore + "分，共" + total + "分)";
        singleTestPaper.put("title", title);


        Date year = (Date) paperMap.get("year");
        String year_str = simpleDateFormat.format(year);
        sql = "select * from enrolment_question_interview where checkFlag='1' and id not in (select quesid from enrolment_question_paperques where  to_char(year, 'yyyy')='" + year_str + "'  and subtype='" + subtype + "') order by random() limit 2";

        // 创建试题内容
        List<Map<String, Object>> question = new ArrayList<Map<String, Object>>();
        // 以下需要通过算法动态获取（抽取试题）
        List<InterviewIssueBean> list = this.dao.findByNativeSql(sql, InterviewIssueBean.class);
        if (list.size() == 2) {
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> map = new HashMap<String, Object>();
                InterviewIssueBean interviewIssueBean = list.get(i);
                PaperQuesBean paperQuesBean = new PaperQuesBean();
                map.put("type", kskm);
                map.put("stem", interviewIssueBean.getStem());
                paperQuesBean.setQuesid(interviewIssueBean.getId());
                paperQuesBean.setYear(year);
               // paperQuesBean.setQuesType(questype);
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
        boolean compareStatus = questionSettingBean.getCompareInterview() == null ? true : questionSettingBean.getCompareInterview();
        return compareStatus;
    }

    @Override
    public int updateCompareStatus(Long id, Boolean compareStatus) {
        return questionSettingBeanService.updateCompareInterview(id, compareStatus);
    }

    @Override
    public String[] createDownloadFile(Long entityId, String fileType) {
        String[] str = new String[2];
        InterviewIssueBean interviewIssueBean = this.getEntity(entityId);
        Map dataMap = new HashMap();
        dataMap.put("stem", interviewIssueBean.getStem());

        Map tempMap = new HashMap();
        // tempMap.put("title", "面试题");
        tempMap.put("question", dataMap);

        str[0] = "面试题";
        str[1] = this.createSinglePreview(tempMap, interviewIssueBean.getSubType());
        return str;
    }

    public void setPaperQuesBeanService(IPaperQuesBeanService paperQuesBeanService) {
        this.paperQuesBeanService = paperQuesBeanService;
    }
}
