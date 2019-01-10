package com.kalix.enrolment.examinee.biz;

import com.kalix.enrolment.examinee.api.biz.IExamStudentBeanService;
import com.kalix.enrolment.examinee.api.dao.IExamStudentBeanDao;
import com.kalix.enrolment.examinee.entities.ExamStudentBean;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.extend.impl.biz.LogicDeleteGenericBizServiceImpl;

import java.util.List;

/**
 * Created by zangyanming at 2018-09-13
 */
public class ExamStudentBeanServiceImpl extends LogicDeleteGenericBizServiceImpl<IExamStudentBeanDao, ExamStudentBean> implements IExamStudentBeanService {

    @Override
    public JsonData findByBarCode(String barCode) {
        JsonData jsonData = new JsonData();
        List list =this.dao.findByBarCode(barCode);
        jsonData.setData(list);
        return jsonData;
    }
}
