package com.kalix.enrolment.question.api.biz;

import com.kalix.enrolment.question.entities.ScoreStanderBean;
import com.kalix.framework.core.api.biz.IBizService;
import com.kalix.framework.core.api.persistence.JsonData;

public interface IScoreStanderBeanService extends IBizService<ScoreStanderBean> {
    JsonData getEntitiesByFK(Long quesId, Integer page, Integer limit, String jsonStr, String sort);
}
