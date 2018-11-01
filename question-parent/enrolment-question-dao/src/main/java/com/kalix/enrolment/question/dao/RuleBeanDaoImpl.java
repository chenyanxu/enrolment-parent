package com.kalix.enrolment.question.dao;

import com.kalix.enrolment.question.api.dao.IRuleBeanDao;
import com.kalix.enrolment.question.dto.model.RuleDto;
import com.kalix.enrolment.question.entities.RuleBean;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.impl.dao.CommonMethod;

import java.util.List;

public class RuleBeanDaoImpl extends BaseBeanDao<RuleBean, Long> implements IRuleBeanDao {

    @Override
    public JsonData findByPaperId(Long paperId, Integer page, Integer limit, String jsonStr, String sort) {
        JsonData jsonData = new JsonData();
        String sql = "select t.* from (select a.* from " + super.getTableName() + " a where a.delflag='0' and a.paperid = ?1) t";
        sql += CommonMethod.createWhereCondition(jsonStr, sort);
        jsonData = this.findByNativeSql(sql, page, limit, RuleBean.class, paperId);
        return jsonData;
    }

    @Override
    public List findByPaperId(Long paperId) {
        String sql = "select a.id,a.paperid,a.quesdesc,a.quesscore,a.questotalscore,a.questype,a.titlenum,a.subtype, d.label as quesTypeName, d.description as quesTypeDesc " +
                " from " + super.getTableName() + " a, enrolment_dict d " +
                " where a.delflag = '0' and a.paperid = ?1 and a.questype = d.value and d.type = '题型'";
        return this.findByNativeSql(sql, RuleDto.class, paperId);
    }
}
