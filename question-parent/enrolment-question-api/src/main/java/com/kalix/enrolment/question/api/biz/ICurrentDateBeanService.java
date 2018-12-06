package com.kalix.enrolment.question.api.biz;

import com.kalix.enrolment.question.dto.model.RuleDto;
import com.kalix.enrolment.question.entities.ChoiceBean;
import com.kalix.framework.core.api.IService;
import com.kalix.framework.extend.api.biz.ILogicDeleteService;

/**
 * Created by zangyanming at 2018-09-13.
 */
public interface ICurrentDateBeanService extends IService {
    String getNowDate();
}
