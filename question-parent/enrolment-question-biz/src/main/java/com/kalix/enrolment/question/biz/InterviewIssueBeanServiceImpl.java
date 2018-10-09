package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.IInterviewIssueBeanService;
import com.kalix.enrolment.question.api.dao.IInterviewIssueBeanDao;
import com.kalix.enrolment.question.entities.InterviewIssueBean;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.util.StringUtils;
import com.kalix.framework.extend.impl.biz.LogicDeleteGenericBizServiceImpl;

/**
 * Created by zangyanming at 2018-09-13
 */
public class InterviewIssueBeanServiceImpl extends LogicDeleteGenericBizServiceImpl<IInterviewIssueBeanDao, InterviewIssueBean> implements IInterviewIssueBeanService {

    @Override
    public JsonData getAllEntityByQuery(Integer page, Integer limit, String jsonStr, String sort) {
        if (StringUtils.isEmpty(sort)) {
            sort = "[{'property': 'delFlag', 'direction': 'ASC'}]";
        }
        return super.getAllEntityByQuery(page, limit, jsonStr, sort);
    }
}
