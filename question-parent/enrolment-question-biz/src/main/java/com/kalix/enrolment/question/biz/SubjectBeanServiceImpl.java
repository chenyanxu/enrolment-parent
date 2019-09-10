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

        Map<String, Object> singleTestPaper = new HashMap<>();
        String sql = "";
        // 创建试题标题
        String title = "";
        // 以下需要通过参数动态获取

        Long paperId=Long.parseLong(paperMap.get("paperid").toString());
        // Long examId = Long.parseLong(paperMap.get("examId").toString());
        int titleNum = Integer.parseInt(paperMap.get("titlenum").toString());

        int perScore = Integer.parseInt(paperMap.get("score").toString());
        int total = Integer.parseInt(paperMap.get("totalscore").toString());

        String questype = paperMap.get("questype").toString();
        String uuid = paperMap.get("uuid").toString();
        String quesdesc=paperMap.get("quesdesc") == null ? "" : paperMap.get("quesdesc").toString();
        String subtype = paperMap.get("subtype") == null ? "" : paperMap.get("subtype").toString();
        EnrolmentDictBean enrolmentDictBean = enrolmentDictBeanService.getDictBeanByTypeAndValue(DICT_SUBTYPE, subtype);
//        String titleName = enrolmentDictBean.getLabel();
        String titleName = enrolmentDictBean.getDescription();
        //  String titleName = "评述题";
        // title = Constants.numGetChinese(titleNum) + "、" + titleName + "(每题" + perScore + "分，共" + total + "分)";
        title = Constants.numGetChinese(titleNum) + "、" + titleName + "(共" + total + "分)";
        singleTestPaper.put("title", title);
        singleTestPaper.put("titleNum", titleNum);
        singleTestPaper.put("quesdesc", quesdesc);
        singleTestPaper.put("perScore", perScore);
        singleTestPaper.put("quesType", questype);
        singleTestPaper.put("subType", subtype);

        int quesNum = total / perScore;

        Date year = (Date) paperMap.get("year");
        String year_str = simpleDateFormat.format(year);
        String term = paperMap.get("term") == null ? "" : paperMap.get("term").toString();
//        sql = "select * from enrolment_question_subject where checkFlag='1' and id not in (select quesid from enrolment_question_paperques where  to_char(year, 'yyyy')='" + year_str + "' and questype='" + questype + "' and subtype='" + subtype + "')  and subtype='" + subtype + "'  order by random() limit " + quesNum;
        // sql = "select * from enrolment_question_subject where checkFlag='1' and subtype='" + subtype + "'  order by random() limit " + quesNum;
        Object quesIdsObj = paperMap.get("quesIds");
        if (quesIdsObj != null) {
            String quesIds = quesIdsObj.toString();
            if (quesIds != null && quesIds.trim().length() > 0) {
                if (quesIds.indexOf(",") == -1) {
                    quesNum = 1;
                } else {
                    String[] quesArr = quesIds.split(",");
                    quesNum = quesArr.length;
                }
            }
            sql = "select * from enrolment_question_subject where subtype='" + subtype + "' and delflag='0' and id in("+quesIds+")";
        } else {
            sql = "select * from enrolment_question_subject where id not in (select quesid from enrolment_question_paperques where to_char(year, 'yyyy')='" + year_str + "' and questype='" + questype + "' and subtype='" + subtype + "')  and subtype='"
                    + subtype + "' and to_char(year, 'yyyy')='" + year_str + "' and term='"+term+"' and delflag='0' order by random() limit " + quesNum;
            // sql = "select * from enrolment_question_subject where subtype='" + subtype + "'  order by random() limit " + quesNum;
        }

        // 创建试题内容
        List<Map<String, Object>> question = new ArrayList<>();
        // 以下需要通过算法动态获取（抽取试题）
        List<SubjectBean> list = this.dao.findByNativeSql(sql, SubjectBean.class);
        if (list.size() == quesNum) {
            String quesIds = "";
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> map = new HashMap<>();
                SubjectBean subjectBean = list.get(i);
                quesIds = String.valueOf(subjectBean.getId());
                String scoreStandard = subjectBean.getScoreStandard();
                map.put("answerConstraint", subjectBean.getAnswerConstraint());
                map.put("type", "论述题");
                map.put("scoreStandard", scoreStandard);
                map.put("stem", subjectBean.getStem());
                PaperQuesBean paperQuesBean = this.getPaperByPaperIdAndQuesId(paperId, subjectBean.getId());
                if (paperQuesBean == null) {
                    paperQuesBean = new PaperQuesBean();
                    paperQuesBean.setQuesid(subjectBean.getId());
                    paperQuesBean.setYear(year);
                    paperQuesBean.setQuesType(questype);
                    paperQuesBean.setSubType(subtype);
                    paperQuesBean.setUuid(uuid);
                    paperQuesBean.setPaperId(paperId);
                    // paperQuesBean.setExamId(examId);
                    paperQuesBean.setCreateById(shiroService.getCurrentUserId());
                    paperQuesBean.setUpdateById(shiroService.getCurrentUserId());
                    paperQuesBeanService.saveEntity(paperQuesBean);
                } else {
                    paperQuesBean.setCreateById(shiroService.getCurrentUserId());
                    paperQuesBean.setUpdateById(shiroService.getCurrentUserId());
                    paperQuesBeanService.updateEntity(paperQuesBean);
                }
                map.put("paperBean", paperQuesBean);
                map.put("paperBeanId", paperQuesBean.getId());
                question.add(map);
            }
            singleTestPaper.put("quesIds", quesIds);
        }

        singleTestPaper.put("question", question);
        return singleTestPaper;
    }

    private PaperQuesBean getPaperByPaperIdAndQuesId(Long paperId, Long quesId) {
        List<PaperQuesBean> paperQuesBeans = dao.findByNativeSql("select * from enrolment_question_paperques where paperid=" + paperId +" and quesid=" + quesId, PaperQuesBean.class);
        if (paperQuesBeans != null && !paperQuesBeans.isEmpty()) {
            return paperQuesBeans.get(0);
        }
        return null;
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
