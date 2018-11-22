package com.kalix.enrolment.question.api.biz;

import com.kalix.enrolment.question.entities.QuestionRepeatedBean;
import com.kalix.framework.core.api.biz.IBizService;
import com.kalix.framework.core.api.persistence.JsonData;

/**
 * Created by dell on 14-1-17.
 */
public interface IQuestionRepeatedBeanService extends IBizService<QuestionRepeatedBean> {

    JsonData getAllRepeatedByQuery(Integer page, Integer limit, String jsonStr, String sort);

    JsonData getRepeatedByQuery(Integer page, Integer limit, String jsonStr, String sort);
}
