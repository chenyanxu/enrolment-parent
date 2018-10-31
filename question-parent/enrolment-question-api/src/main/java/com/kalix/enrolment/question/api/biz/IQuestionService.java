package com.kalix.enrolment.question.api.biz;

import com.kalix.enrolment.question.entities.BaseQuestionEntity;
import com.kalix.framework.extend.api.biz.ILogicDeleteService;

/**
 * Created by hqj at 2018-10-30.
 */
public interface IQuestionService<T extends BaseQuestionEntity> extends ILogicDeleteService<T> {

    String getQuestionBeanName();
}
