package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.IScoreStanderBeanService;
import com.kalix.enrolment.question.api.dao.IScoreStanderBeanDao;
import com.kalix.enrolment.question.entities.ScoreStanderBean;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.impl.biz.GenericBizServiceImpl;

public class ScoreStanderBeanServiceImpl extends GenericBizServiceImpl<IScoreStanderBeanDao, ScoreStanderBean> implements IScoreStanderBeanService {
    @Override
    public JsonData getEntitiesByFK(Long quesId, Integer page, Integer limit, String jsonStr, String sort) {
        return this.dao.findByQuesId(quesId, page, limit, jsonStr, sort);
    }
}
