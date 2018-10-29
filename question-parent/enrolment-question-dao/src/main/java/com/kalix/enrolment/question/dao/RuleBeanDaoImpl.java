package com.kalix.enrolment.question.dao;

import com.kalix.enrolment.question.api.dao.IRuleBeanDao;
import com.kalix.enrolment.question.entities.RuleBean;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.impl.dao.CommonMethod;

import java.util.List;

public class RuleBeanDaoImpl extends BaseBeanDao<RuleBean, Long> implements IRuleBeanDao {

    @Override
    public JsonData findByPaperId(Long paperId, Integer page, Integer limit, String jsonStr, String sort) {
        JsonData jsonData = new JsonData();
        /*String hql = "select t from MajorCourseBean t where t.orgid = ?1";
        //hql += CommonMethod.createWhereCondition(jsonStr, sort);
        List list = this.findbyPage(hql, page-1, limit, orgId);*/
        String sql = "select t.* from (select a.* from " + super.getTableName() + " a where a.delflag='0' and a.paperid = ?1) t";
        sql += CommonMethod.createWhereCondition(jsonStr, sort);
        jsonData = this.findByNativeSql(sql, page, limit, RuleBean.class, paperId);
        return jsonData;
    }

    @Override
    public List findByPaperId(Long paperId) {
        String sql = "select t.* from (select a.* from " + super.getTableName() + " a where a.delflag='0' and a.paperid = ?1) t";
        return this.findByNativeSql(sql,RuleBean.class, paperId);

    }
}
