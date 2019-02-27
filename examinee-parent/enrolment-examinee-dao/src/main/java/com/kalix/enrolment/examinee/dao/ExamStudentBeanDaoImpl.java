package com.kalix.enrolment.examinee.dao;

import com.kalix.enrolment.examinee.api.dao.IExamStudentBeanDao;
import com.kalix.enrolment.examinee.entities.ExamScoreBean;
import com.kalix.enrolment.examinee.entities.ExamStudentBean;

import java.util.List;

public class ExamStudentBeanDaoImpl extends BaseBeanDao<ExamStudentBean, Long> implements IExamStudentBeanDao {

    @Override
    public List findByBarCode(String barCode) {
        String sql = "select t.* from (select a.* from " + super.getTableName() + " a where a.delflag='0' and a.barCode = ?1) t";
        return this.findByNativeSql(sql, ExamStudentBean.class, barCode);
    }
}
