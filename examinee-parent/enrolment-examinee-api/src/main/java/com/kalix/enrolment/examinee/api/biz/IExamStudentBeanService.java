package com.kalix.enrolment.examinee.api.biz;

import com.kalix.enrolment.examinee.entities.ExamStudentBean;

import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.extend.api.biz.ILogicDeleteService;

import java.util.List;


/**
 * Created by zangyanming at 2018-09-13.
 */
public interface IExamStudentBeanService extends ILogicDeleteService<ExamStudentBean> {

    JsonData findByBarCode(String barCode);
}
