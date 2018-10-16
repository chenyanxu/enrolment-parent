package com.kalix.enrolment.question.api.biz;

import com.kalix.enrolment.question.entities.MusicBean;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.extend.api.biz.ILogicDeleteService;

import java.util.Map;

/**
 * Created by zangyanming at 2018-09-13.
 */
public interface IMusicBeanService extends ILogicDeleteService<MusicBean> {
    JsonData getAllCheckEntityByQuery(Integer page, Integer limit, String jsonStr, String sort);

    JsonStatus batchAudit(String entityIds, String reason);


}
