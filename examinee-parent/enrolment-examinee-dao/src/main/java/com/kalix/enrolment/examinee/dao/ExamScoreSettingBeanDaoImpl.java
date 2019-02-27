package com.kalix.enrolment.examinee.dao;

import com.kalix.enrolment.examinee.api.dao.IExamScoreSettingBeanDao;
import com.kalix.enrolment.examinee.entities.ExamScoreSettingBean;

import java.util.List;

public class ExamScoreSettingBeanDaoImpl extends BaseBeanDao<ExamScoreSettingBean, Long> implements IExamScoreSettingBeanDao {

    @Override
    public Double findCoefficient(String major, String province) {
        Double rtn = 1.0;
        String sql = "select t.coefficient from " + super.getTableName() + " t " +
                "where t.major = '" + major + "' and t.province = '" + province + "'";
        List<Double> list = this.findByNativeSql(sql, Double.class);
        if (list != null && list.size() > 0) {
            rtn = list.get(0);
        }
        return rtn;
    }
}
