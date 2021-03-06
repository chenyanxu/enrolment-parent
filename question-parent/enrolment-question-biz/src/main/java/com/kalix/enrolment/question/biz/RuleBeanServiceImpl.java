package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.IRuleBeanService;
import com.kalix.enrolment.question.api.dao.IRuleBeanDao;
import com.kalix.enrolment.question.entities.RuleBean;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.extend.impl.biz.LogicDeleteGenericBizServiceImpl;

import java.util.List;

/**
 * Created by zangyanming at 2018-09-13
 */
public class RuleBeanServiceImpl extends LogicDeleteGenericBizServiceImpl<IRuleBeanDao, RuleBean> implements IRuleBeanService {

    @Override
    public JsonData getEntitiesByFK(long paperId, Integer page, Integer limit, String jsonStr, String sort) {
        return this.dao.findByPaperId(paperId, page, limit, jsonStr, sort);
    }

    @Override
    public List findByPaperId(Long paperId) {
        return this.dao.findByPaperId(paperId);
    }

    @Override
    public void beforeSaveEntity(RuleBean entity, JsonStatus status) {
        int count = 0;
        int index = 0;
        super.beforeSaveEntity(entity, status);
    }
}
