package com.kalix.enrolment.question.api.biz;

import com.kalix.framework.core.api.IService;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;

/**
 * Created by zangyanming at 2018-09-13.
 */
public interface IQuestionAuditService extends IService {

    String getQuestionType();

    String getAuditRoleName(String subType);

    JsonData getAllAuditEntityByQuery(Integer page, Integer limit, String subType);

    JsonStatus batchAudit(String entityIds, String checkFlag, String reason);
}
