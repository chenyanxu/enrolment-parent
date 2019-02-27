package com.kalix.enrolment.examinee.api.dao;

import com.kalix.enrolment.examinee.entities.ExamScoreSettingBean;
import com.kalix.framework.core.api.dao.IGenericDao;

/**
 * Created by hqj at 2019-02-25.
 */
public interface IExamScoreSettingBeanDao extends IGenericDao<ExamScoreSettingBean, Long> {

    Double findCoefficient(String major, String province);
}
