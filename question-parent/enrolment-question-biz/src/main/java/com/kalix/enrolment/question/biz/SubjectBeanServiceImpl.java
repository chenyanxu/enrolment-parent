package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.IFreemarkerService;
import com.kalix.enrolment.question.api.biz.IQuestionAuditService;
import com.kalix.enrolment.question.api.biz.ISubjectBeanService;
import com.kalix.enrolment.question.api.dao.ISubjectBeanDao;
import com.kalix.enrolment.question.api.model.QuestionType;
import com.kalix.enrolment.question.api.model.SubjectType;
import com.kalix.enrolment.question.entities.SubjectBean;
import com.kalix.framework.core.api.biz.IDownloadService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zangyanming at 2018-09-13
 */
public class SubjectBeanServiceImpl extends QuestionGenericBizServiceImpl<ISubjectBeanDao, SubjectBean>
        implements ISubjectBeanService, IQuestionAuditService, IDownloadService, IFreemarkerService {

    private static String AUDIT_ROLE_NAME1 = "主观题审核人";
    private static String AUDIT_ROLE_NAME2 = "主观题审核人";

    @Override
    public String getQuestionType() {
        return QuestionType.SUBJECT;
    }

    @Override
    public String getAuditRoleName(String subType) {
        String roleName = "";
        switch (subType) {
            case SubjectType.A:
                roleName = AUDIT_ROLE_NAME1;
                break;
            case SubjectType.B:
                roleName = AUDIT_ROLE_NAME2;
                break;
        }
        return roleName;
    }

    @Override
    public String[] createDownloadFile(Long entityId, String fileType) {

        SubjectBean subjectBean = this.getEntity(entityId);

        Map dataMap = new HashMap();
        Map tempMap = new HashMap();
        dataMap.put("stem", subjectBean.getStem());

        tempMap = new HashMap<>();
        tempMap.put("title", "主观题");
        tempMap.put("question", dataMap);
        String[] str = new String[2];
        str[0] = "123";
        str[1] = this.createDoc("subject.ftl", tempMap);
        return str;
    }
}
