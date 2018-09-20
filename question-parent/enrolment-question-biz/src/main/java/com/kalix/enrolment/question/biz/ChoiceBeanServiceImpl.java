package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.IChoiceBeanService;
import com.kalix.enrolment.question.api.dao.IChoiceBeanDao;
import com.kalix.enrolment.question.entities.ChoiceBean;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.util.StringUtils;
import com.kalix.framework.extend.impl.biz.LogicDeleteGenericBizServiceImpl;

/**
 * Created by angyanming at 2018-09-13
 */
public class ChoiceBeanServiceImpl extends LogicDeleteGenericBizServiceImpl<IChoiceBeanDao, ChoiceBean> implements IChoiceBeanService {

    @Override
    public JsonData getAllEntityByQuery(Integer page, Integer limit, String jsonStr, String sort) {
        if (StringUtils.isEmpty(sort)) {
            sort = "[{'property': 'delFlag', 'direction': 'ASC'}]";
        }
        return super.getAllEntityByQuery(page, limit, jsonStr, sort);
    }
}
