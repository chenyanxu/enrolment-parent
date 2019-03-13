package com.kalix.enrolment.question.api.dao;

import com.kalix.enrolment.question.entities.ScoreStanderBean;
import com.kalix.framework.core.api.dao.IGenericDao;
import com.kalix.framework.core.api.persistence.JsonData;

public interface IScoreStanderBeanDao extends IGenericDao<ScoreStanderBean, Long> {

    JsonData findByQuesId(Long quesId, Integer page, Integer limit, String jsonStr, String sort);

}
