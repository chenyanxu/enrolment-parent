package com.kalix.enrolment.question.api.biz;

import com.kalix.enrolment.question.entities.RuleBean;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.extend.api.biz.ILogicDeleteService;

import java.util.List;

/**
 * Created by zangyanming at 2018-09-13.
 */
public interface IRuleBeanService extends ILogicDeleteService<RuleBean> {

    JsonData getEntitiesByFK(long paperId, Integer page, Integer limit, String jsonStr, String sort);

    List findByPaperId(Long paperId);
}
