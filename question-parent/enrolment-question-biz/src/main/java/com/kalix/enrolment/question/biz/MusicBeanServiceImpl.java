package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.IMusicBeanService;
import com.kalix.enrolment.question.api.dao.IMusicBeanDao;
import com.kalix.enrolment.question.entities.MusicBean;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.util.StringUtils;
import com.kalix.framework.extend.impl.biz.LogicDeleteGenericBizServiceImpl;

/**
 * Created by zangyanming at 2018-09-13
 */
public class MusicBeanServiceImpl extends LogicDeleteGenericBizServiceImpl<IMusicBeanDao, MusicBean> implements IMusicBeanService {

    @Override
    public JsonData getAllEntityByQuery(Integer page, Integer limit, String jsonStr, String sort) {
        if (StringUtils.isEmpty(sort)) {
            sort = "[{'property': 'delFlag', 'direction': 'ASC'}]";
        }
        return super.getAllEntityByQuery(page, limit, jsonStr, sort);
    }
}
