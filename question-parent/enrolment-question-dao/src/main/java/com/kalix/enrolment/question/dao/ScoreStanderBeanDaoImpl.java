package com.kalix.enrolment.question.dao;

import com.kalix.enrolment.question.api.dao.IScoreStanderBeanDao;
import com.kalix.enrolment.question.entities.ScoreStanderBean;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.impl.dao.CommonMethod;

public class ScoreStanderBeanDaoImpl extends BaseBeanDao<ScoreStanderBean, Long> implements IScoreStanderBeanDao {

    @Override
    public JsonData findByQuesId(Long quesId, Integer page, Integer limit, String jsonStr, String sort) {
        JsonData jsonData = new JsonData();
        String sql = "select t.* from (select a.* from " + super.getTableName() + " a where a.quesid = ?1) t";
        sql += CommonMethod.createWhereCondition(jsonStr, sort);
        jsonData = this.findByNativeSql(sql, page, limit, ScoreStanderBean.class, quesId);
        return jsonData;
    }
}
