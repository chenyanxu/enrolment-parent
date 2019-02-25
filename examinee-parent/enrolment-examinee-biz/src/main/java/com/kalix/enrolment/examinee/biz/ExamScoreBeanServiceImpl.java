package com.kalix.enrolment.examinee.biz;

import com.kalix.enrolment.examinee.api.biz.IExamScoreBeanService;
import com.kalix.enrolment.examinee.api.dao.IExamScoreBeanDao;
import com.kalix.enrolment.examinee.entities.ExamScoreBean;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.util.Assert;
import com.kalix.framework.extend.impl.biz.LogicDeleteGenericBizServiceImpl;

import java.util.List;

/**
 * Created by zangyanming at 2018-09-13
 */
public class ExamScoreBeanServiceImpl extends LogicDeleteGenericBizServiceImpl<IExamScoreBeanDao, ExamScoreBean> implements IExamScoreBeanService {
    private static final String FUNCTION_NAME = "考试成绩";

    @Override
    public boolean isSave(ExamScoreBean entity, JsonStatus status) {
        ExamScoreBean bean = (ExamScoreBean) entity;
        List<ExamScoreBean> examScoreBeens = dao.find("select ob from ExamScoreBean ob where ob.barCode = ?1", bean.getBarCode());
        if (examScoreBeens != null && examScoreBeens.size() > 0) {
            status.setFailure(true);
            status.setMsg(FUNCTION_NAME + "已经存在！");
            return false;
        }
        return true;
    }

    @Override
    public boolean isUpdate(ExamScoreBean entity, JsonStatus status) {
        Assert.notNull(entity, "实体不能为空.");
        ExamScoreBean bean = (ExamScoreBean) entity;
        List<ExamScoreBean> examScoreBeens = dao.find("select ob from ExamScoreBean ob where ob.id <> ?1 and ob.barCode = ?2",
                bean.getId(), bean.getBarCode());
        if (examScoreBeens != null && examScoreBeens.size() > 0) {
            status.setFailure(true);
            status.setMsg(FUNCTION_NAME + "已经存在！");
            return false;
        }
        return true;
    }
}
