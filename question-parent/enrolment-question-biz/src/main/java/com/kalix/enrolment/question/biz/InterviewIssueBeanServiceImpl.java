package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.IFreemarkerService;
import com.kalix.enrolment.question.api.biz.IInterviewIssueBeanService;
import com.kalix.enrolment.question.api.biz.IQuestionAuditService;
import com.kalix.enrolment.question.api.dao.IInterviewIssueBeanDao;
import com.kalix.enrolment.question.api.model.InterviewType;
import com.kalix.enrolment.question.api.model.QuestionType;
import com.kalix.enrolment.question.entities.InterviewIssueBean;
import com.kalix.framework.core.api.biz.IDownloadService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zangyanming at 2018-09-13
 */
public class InterviewIssueBeanServiceImpl extends QuestionGenericBizServiceImpl<IInterviewIssueBeanDao, InterviewIssueBean>
        implements IInterviewIssueBeanService, IQuestionAuditService, IDownloadService, IFreemarkerService {

    private static String AUDIT_ROLE_NAME1 = "面试题审核人";
    private static String AUDIT_ROLE_NAME2 = "面试题审核人";

    @Override
    public String getQuestionType() {
        return QuestionType.INTERVIEW;
    }

    @Override
    public String getAuditRoleName(String subType) {
        String roleName = "";
        switch (subType) {
            case InterviewType.A_1:
                roleName = AUDIT_ROLE_NAME1;
                break;
            case "2":
                roleName = AUDIT_ROLE_NAME2;
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
        str[1] = this.createDoc("choice.ftl", tempMap);
        return str;
    }
}
