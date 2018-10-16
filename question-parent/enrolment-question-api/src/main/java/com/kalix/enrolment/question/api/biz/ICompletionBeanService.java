package com.kalix.enrolment.question.api.biz;

import com.kalix.enrolment.question.entities.CompletionBean;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.extend.api.biz.ILogicDeleteService;

import java.util.Map;

/**
 * Created by dell on 14-1-17.
 */
public interface ICompletionBeanService extends ILogicDeleteService<CompletionBean> {
    JsonData getAllCheckEntityByQuery(Integer page, Integer limit, String jsonStr, String sort);

    JsonStatus batchAudit(String entityIds, String checkFlag, String reason);
}
