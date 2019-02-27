package com.kalix.enrolment.examinee.biz;

import com.kalix.enrolment.examinee.api.biz.IExamStudentBeanService;
import com.kalix.enrolment.examinee.api.dao.IExamStudentBeanDao;
import com.kalix.enrolment.examinee.entities.ExamStudentBean;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.util.Assert;
import com.kalix.framework.extend.impl.biz.LogicDeleteGenericBizServiceImpl;

import java.util.List;

/**
 * Created by zangyanming at 2018-09-13
 */
public class ExamStudentBeanServiceImpl extends LogicDeleteGenericBizServiceImpl<IExamStudentBeanDao, ExamStudentBean> implements IExamStudentBeanService {
    private static final String FUNCTION_NAME = "考生信息";

    @Override
    public boolean isSave(ExamStudentBean entity, JsonStatus status) {
        ExamStudentBean bean = (ExamStudentBean) entity;
        List<ExamStudentBean> examStudentBeans = dao.find("select ob from ExamStudentBean ob where ob.barCode = ?1", bean.getBarCode());
        if (examStudentBeans != null && examStudentBeans.size() > 0) {
            status.setFailure(true);
            status.setMsg(FUNCTION_NAME + "已经存在！");
            return false;
        }
        return true;
    }

    @Override
    public boolean isUpdate(ExamStudentBean entity, JsonStatus status) {
        Assert.notNull(entity, "实体不能为空.");
        ExamStudentBean bean = (ExamStudentBean) entity;
        List<ExamStudentBean> examScoreBeens = dao.find("select ob from ExamStudentBean ob where ob.id <> ?1 and ob.barCode = ?2",
                bean.getId(), bean.getBarCode());
        if (examScoreBeens != null && examScoreBeens.size() > 0) {
            status.setFailure(true);
            status.setMsg(FUNCTION_NAME + "已经存在！");
            return false;
        }
        return true;
    }

    @Override
    public JsonData findByBarCode(String barCode) {
        JsonData jsonData = new JsonData();
        List list =this.dao.findByBarCode(barCode);
        jsonData.setData(list);
        return jsonData;
    }
}
