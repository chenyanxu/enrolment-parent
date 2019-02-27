package com.kalix.enrolment.examinee.biz;

import com.kalix.enrolment.examinee.api.biz.IExamScoreBeanService;
import com.kalix.enrolment.examinee.api.dao.IExamScoreBeanDao;
import com.kalix.enrolment.examinee.api.dao.IExamScoreSettingBeanDao;
import com.kalix.enrolment.examinee.api.dao.IExamStudentBeanDao;
import com.kalix.enrolment.examinee.entities.ExamScoreBean;
import com.kalix.enrolment.examinee.entities.ExamStudentBean;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.util.Assert;
import com.kalix.framework.extend.impl.biz.LogicDeleteGenericBizServiceImpl;

import java.util.List;

/**
 * Created by zangyanming at 2018-09-13
 */
public class ExamScoreBeanServiceImpl extends LogicDeleteGenericBizServiceImpl<IExamScoreBeanDao, ExamScoreBean> implements IExamScoreBeanService {
    private static final String FUNCTION_NAME = "考试成绩";
    private IExamStudentBeanDao examStudentBeanDao;
    private IExamScoreSettingBeanDao examScoreSettingBeanDao;

    @Override
    public JsonData getAllEntityByQuery(Integer page, Integer limit, String jsonStr, String sort) {
        JsonData jsonData = new JsonData();
        try {
            /* 如果需要条件查询 */
            /*Map queryMap = SerializeUtil.json2Map(jsonStr);
            String questionType = (String) queryMap.get("questionType");
            if (StringUtils.isEmpty(questionType)) {
                return jsonData;
            }
            String similarity = (String) queryMap.get("similarity");
            if (StringUtils.isEmpty(similarity)) {
                similarity = (String) queryMap.get("%similarity%");
                if (StringUtils.isEmpty(similarity)) {
                    return jsonData;
                }
            }
            queryMap.remove("similarity");
            queryMap.remove("%similarity%");
            queryMap.put("similarity:gt", similarity);
            queryMap.remove("type");
            jsonStr = SerializeUtil.serializeJson(queryMap);*/
            jsonData = super.getAllEntityByQuery(page, limit, jsonStr, sort);
            // 字段翻译
            for (int i = 0; i < jsonData.getData().size(); i++) {
                ExamScoreBean examScoreBean = (ExamScoreBean) jsonData.getData().get(i);
                String barCode = examScoreBean.getBarCode();
                Double coefficient = 1.0;
                List<ExamStudentBean> list = examStudentBeanDao.findByBarCode(barCode);
                if (list != null && list.size() > 0) {
                    ExamStudentBean examStudentBean = list.get(0);
                    examScoreBean.setExamNumber(examStudentBean.getExamNumber());
                    examScoreBean.setExamName(examStudentBean.getExamName());
                    examScoreBean.setMajor(examStudentBean.getMajor());
                    examScoreBean.setProvince(examStudentBean.getProvince());

                    coefficient = examScoreSettingBeanDao.findCoefficient(examStudentBean.getMajor(), examStudentBean.getProvince());
                }
                examScoreBean.setFinalScore(examScoreBean.getTotalScore() * coefficient);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonData;
    }

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

    public void setExamStudentBeanDao(IExamStudentBeanDao examStudentBeanDao) {
        this.examStudentBeanDao = examStudentBeanDao;
    }

    public void setExamScoreSettingBeanDao(IExamScoreSettingBeanDao examScoreSettingBeanDao) {
        this.examScoreSettingBeanDao = examScoreSettingBeanDao;
    }
}
