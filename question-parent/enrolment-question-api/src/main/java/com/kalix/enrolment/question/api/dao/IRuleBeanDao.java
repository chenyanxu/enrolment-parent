package com.kalix.enrolment.question.api.dao;

import com.kalix.enrolment.question.entities.PaperBean;
import com.kalix.enrolment.question.entities.RuleBean;
import com.kalix.framework.core.api.dao.IGenericDao;
import com.kalix.framework.core.api.persistence.JsonData;

import java.util.List;

/**
 * Created by zangyanming at 2018-09-13.
 */
public interface IRuleBeanDao extends IGenericDao<RuleBean, Long> {
    JsonData findByPaperId(Long paperId, Integer page, Integer limit, String jsonStr, String sort);
    List findByPaperId(Long paperId);
}
