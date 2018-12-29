package com.kalix.enrolment.question.api.dao;

import com.kalix.enrolment.question.entities.PaperQuesBean;
import com.kalix.framework.core.api.dao.IGenericDao;

import java.util.List;

/**
 * Created by zangyanming at 2018-09-13.
 */
public interface IPaperQuesBeanDao extends IGenericDao<PaperQuesBean, Long> {
    void deleteByUuid(String uuid);
    List findByPaperId(Long paperId);
    List findByPaperId(Long paperId,String uuid);
}
