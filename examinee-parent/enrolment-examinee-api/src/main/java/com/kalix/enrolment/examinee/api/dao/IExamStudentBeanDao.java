package com.kalix.enrolment.examinee.api.dao;

import com.kalix.enrolment.examinee.entities.ExamStudentBean;

import com.kalix.framework.core.api.dao.IGenericDao;

import java.util.List;


/**
 * Created by zangyanming at 2018-09-13.
 */
public interface IExamStudentBeanDao extends IGenericDao<ExamStudentBean, Long> {

    List findByBarCode(String barCode);
}
