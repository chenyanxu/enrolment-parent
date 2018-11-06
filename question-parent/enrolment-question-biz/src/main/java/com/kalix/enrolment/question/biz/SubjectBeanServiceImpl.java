package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.ISubjectBeanService;
import com.kalix.enrolment.question.api.dao.ISubjectBeanDao;
import com.kalix.enrolment.question.api.model.SubjectType;
import com.kalix.enrolment.question.entities.SubjectBean;
import com.kalix.framework.core.api.biz.IDownloadService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zangyanming at 2018-09-13
 */
public class SubjectBeanServiceImpl extends QuestionGenericBizServiceImpl<ISubjectBeanDao, SubjectBean>
        implements ISubjectBeanService, IDownloadService {

    private static String TEMP_NAME = "subject.ftl";

    @Override
    public String getAuditRoleName(String subType) {
        String roleName = "";
        switch (subType) {
            case SubjectType.SHORT_ANSWER_QUESTIONS:
                roleName = SubjectType.SHORT_ANSWER_QUESTIONS_ROLENAME;
                break;
            case SubjectType.TOPIC_DISCUSSION:
                roleName = SubjectType.TOPIC_DISCUSSION_ROLENAME;
                break;
            case SubjectType.COMMENTARY:
                roleName = SubjectType.COMMENTARY_ROLENAME;
                break;
            case SubjectType.STORY_WRITING:
                roleName = SubjectType.STORY_WRITING_ROLENAME;
                break;
            case SubjectType.STORY_RENEW:
                roleName = SubjectType.STORY_RENEW_ROLENAME;
                break;
            case SubjectType.MICRO_WRITING:
                roleName = SubjectType.MICRO_WRITING_ROLENAME;
                break;
            case SubjectType.PHOTOGRAPHY_ANALYSIS:
                roleName = SubjectType.PHOTOGRAPHY_ANALYSIS_ROLENAME;
                break;
            case SubjectType.FILM_SOUND_ANALYSIS:
                roleName = SubjectType.FILM_SOUND_ANALYSIS_ROLENAME;
                break;
            case SubjectType.IMAGE_ANALYSIS:
                roleName = SubjectType.IMAGE_ANALYSIS_ROLENAME;
                break;
            case SubjectType.PHOTOGRAPHY_WRITING:
                roleName = SubjectType.PHOTOGRAPHY_WRITING_ROLENAME;
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
}
