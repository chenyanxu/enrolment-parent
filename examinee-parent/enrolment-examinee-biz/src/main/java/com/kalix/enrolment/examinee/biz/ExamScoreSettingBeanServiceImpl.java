package com.kalix.enrolment.examinee.biz;

import com.kalix.enrolment.examinee.api.biz.IExamScoreSettingBeanService;
import com.kalix.enrolment.examinee.api.dao.IExamScoreSettingBeanDao;
import com.kalix.enrolment.examinee.entities.ExamScoreSettingBean;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;
import com.kalix.framework.core.util.Assert;

import java.util.List;

/**
 * Created by hqj on 2018-10-25.
 */
public class ExamScoreSettingBeanServiceImpl
        extends ShiroGenericBizServiceImpl<IExamScoreSettingBeanDao, ExamScoreSettingBean>
        implements IExamScoreSettingBeanService {
    private static final String FUNCTION_NAME = "系数";

    @Override
    public boolean isSave(ExamScoreSettingBean entity, JsonStatus status) {
        ExamScoreSettingBean bean = (ExamScoreSettingBean) entity;
        List<ExamScoreSettingBean> examScoreSettingBeens = dao.find("select ob from ExamScoreSettingBean ob where ob.major = ?1 and ob.province = ?2",
                bean.getMajor(), bean.getProvince());
        if (examScoreSettingBeens != null && examScoreSettingBeens.size() > 0) {
            status.setFailure(true);
            status.setMsg(FUNCTION_NAME + "已经存在！");
            return false;
        }
        return true;
    }

    @Override
    public boolean isUpdate(ExamScoreSettingBean entity, JsonStatus status) {
        Assert.notNull(entity, "实体不能为空.");
        ExamScoreSettingBean bean = (ExamScoreSettingBean) entity;
        List<ExamScoreSettingBean> examScoreSettingBeens = dao.find("select ob from ExamScoreSettingBean ob where ob.id <> ?1 and ob.major = ?2 and ob.province = ?3",
                bean.getId(), bean.getMajor(), bean.getProvince());
        if (examScoreSettingBeens != null && examScoreSettingBeens.size() > 0) {
            status.setFailure(true);
            status.setMsg(FUNCTION_NAME + "已经存在！");
            return false;
        }
        return true;
    }


}
