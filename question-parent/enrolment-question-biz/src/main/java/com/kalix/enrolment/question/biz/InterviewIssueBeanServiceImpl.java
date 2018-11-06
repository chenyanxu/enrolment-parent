package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.IInterviewIssueBeanService;
import com.kalix.enrolment.question.api.dao.IInterviewIssueBeanDao;
import com.kalix.enrolment.question.api.model.InterviewType;
import com.kalix.enrolment.question.entities.InterviewIssueBean;
import com.kalix.enrolment.question.entities.MusicBean;
import com.kalix.framework.core.api.biz.IDownloadService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zangyanming at 2018-09-13
 */
public class InterviewIssueBeanServiceImpl extends QuestionGenericBizServiceImpl<IInterviewIssueBeanDao, InterviewIssueBean>
        implements IInterviewIssueBeanService, IDownloadService {

    private static String TEMP_NAME = "subject.ftl";

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
//            case InterviewType.PROPOSITION_TWO_PERSON_ESSAY:
//                roleName = InterviewType.PROPOSITION_TWO_PERSON_ESSAY_ROLENAME;
//                break;
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
            case InterviewType.ACT_SHORTSKETCH:
                roleName = InterviewType.ACT_SHORTSKETCH_ROLENAME;
                break;
            case InterviewType.DIRECT_SHORTSKETCH:
                roleName = InterviewType.DIRECT_SHORTSKETCH_ROLENAME;
                break;
        }
        return roleName;
    }

    @Override
    public String getTempName(String subType) {
        return TEMP_NAME;
    }

    @Override
    public Map<String, Object> createSingleTestPaper(Map paperMap) {
        return null;
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
}
