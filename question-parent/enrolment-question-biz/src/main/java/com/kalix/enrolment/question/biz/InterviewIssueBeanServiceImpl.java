package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.IInterviewIssueBeanService;
import com.kalix.enrolment.question.api.biz.IQuestionAuditService;
import com.kalix.enrolment.question.api.biz.ITestPaperService;
import com.kalix.enrolment.question.api.dao.IInterviewIssueBeanDao;
import com.kalix.enrolment.question.api.model.InterviewType;
import com.kalix.enrolment.question.api.model.QuestionType;
import com.kalix.enrolment.question.entities.InterviewIssueBean;
import com.kalix.framework.core.api.biz.IDownloadService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zangyanming at 2018-09-13
 */
public class InterviewIssueBeanServiceImpl extends QuestionGenericBizServiceImpl<IInterviewIssueBeanDao, InterviewIssueBean>
        implements IInterviewIssueBeanService, IQuestionAuditService, IDownloadService, ITestPaperService {

    private static String TEMP_NAME = "subject.ftl";

    @Override
    public String getQuestionType() {
        return QuestionType.INTERVIEW;
    }

    @Override
    public String getAuditRoleName(String subType) {
        String roleName = "";
        switch (subType) {
            case InterviewType.NEWS_BROADCAST:
                roleName = InterviewType.NEWS_BROADCAST_ROLENAME;
                break;
            case InterviewType.TOPIC_DISCUSSION:
                roleName = InterviewType.TOPIC_DISCUSSION_ROLENAME;
                break;
            case InterviewType.PROPOSITIONAL_STORY:
                roleName = InterviewType.PROPOSITIONAL_STORY_ROLENAME;
                break;
            case InterviewType.PROPOSITION_TWO_PERSON_ESSAY:
                roleName = InterviewType.PROPOSITION_TWO_PERSON_ESSAY_ROLENAME;
                break;
            case InterviewType.ENGLISH_STUDY:
                roleName = InterviewType.ENGLISH_STUDY_ROLENAME;
                break;
            case InterviewType.DRAMA_FILM_LITERATURE:
                roleName = InterviewType.DRAMA_FILM_LITERATURE_ROLENAME;
                break;
            case InterviewType.DRAMA_DIRECTOR:
                roleName = InterviewType.DRAMA_DIRECTOR_ROLENAME;
                break;
            case InterviewType.FILM_PRODUCTION:
                roleName = InterviewType.FILM_PRODUCTION_ROLENAME;
                break;
            case InterviewType.FLIGHT_ATTENDANTS_INTERVIEW:
                roleName = InterviewType.FLIGHT_ATTENDANTS_INTERVIEW_ROLENAME;
                break;
            case InterviewType.EXTEMPORE_REVIEW:
                roleName = InterviewType.EXTEMPORE_REVIEW_ROLENAME;
                break;
        }
        return roleName;
    }

    @Override
    public String[] createDownloadFile(Long entityId, String fileType) {

        InterviewIssueBean interviewIssueBean = this.getEntity(entityId);

        Map dataMap = new HashMap();
        Map tempMap = new HashMap();
        dataMap.put("stem", interviewIssueBean.getStem());

        // List question = new ArrayList();
        //  question.add(dataMap);
        tempMap = new HashMap<>();
        tempMap.put("title", "面试题");
        tempMap.put("question", dataMap);
        String[] str = new String[2];
        str[0] = "123";
        str[1] = this.createSinglePreview(tempMap, interviewIssueBean.getInterviewType());
        return str;
    }

    @Override
    public String getTempName(String subType) {
        return TEMP_NAME;
    }

    @Override
    public Map<String, Object> createSingleTestPaper(String subType) {
        return null;
    }
}
