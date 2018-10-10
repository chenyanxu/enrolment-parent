package com.kalix.enrolment.question.api.biz;

import com.kalix.enrolment.question.entities.SubjectBean;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.extend.api.biz.ILogicDeleteService;

/**
 * Created by zangyanming at 2018-09-13.
 */
public interface ISubjectBeanService extends ILogicDeleteService<SubjectBean> {
    JsonData getAllCheckEntityByQuery(Integer page, Integer limit, String jsonStr, String sort);

    JsonStatus batchAudit(String entityIds, String reason);
}
