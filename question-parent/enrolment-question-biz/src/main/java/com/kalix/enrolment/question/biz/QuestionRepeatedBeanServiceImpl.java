package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.IQuestionRepeatedBeanService;
import com.kalix.enrolment.question.api.biz.IQuestionService;
import com.kalix.enrolment.question.api.dao.IQuestionRepeatedBeanDao;
import com.kalix.enrolment.question.entities.BaseQuestionEntity;
import com.kalix.enrolment.question.entities.QuestionRepeatedBean;
import com.kalix.enrolment.system.dict.api.biz.IEnrolmentDictBeanService;
import com.kalix.enrolment.system.dict.entities.EnrolmentDictBean;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;
import com.kalix.framework.core.util.JNDIHelper;
import com.kalix.framework.core.util.SerializeUtil;
import com.kalix.framework.core.util.StringUtils;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hqj on 2018-10-25.
 */
public class QuestionRepeatedBeanServiceImpl
        extends ShiroGenericBizServiceImpl<IQuestionRepeatedBeanDao, QuestionRepeatedBean>
        implements IQuestionRepeatedBeanService {

    protected static String DICT_QUESTIONTYPE = "题型";
    protected IEnrolmentDictBeanService enrolmentDictBeanService;
    protected IQuestionService questionService;

    @Override
    public void beforeSaveEntity(QuestionRepeatedBean entity, JsonStatus status) {
        String userName = shiroService.getCurrentUserRealName();
        Long userId = -1L;
        if (StringUtils.isEmpty(userName)) {
            userId = -1L;
            userName = "admin";
        } else {
            userId = shiroService.getCurrentUserId();
        }
        entity.setCreateBy(userName);
        entity.setUpdateBy(userName);

        entity.setCreateById(userId);
        entity.setUpdateById(userId);
    }

    @Override
    public void beforeUpdateEntity(QuestionRepeatedBean entity, JsonStatus status) {
        String userName = shiroService.getCurrentUserRealName();
        Long userId = -1L;
        if (StringUtils.isEmpty(userName)) {
            userId = -1L;
            userName = "admin";
        } else {
            userId = shiroService.getCurrentUserId();
        }
        entity.setUpdateBy(userName);
        entity.setUpdateById(userId);
    }

    @Override
    public JsonData getAllRepeatedByQuery(Integer page, Integer limit, String jsonStr, String sort) {
        JsonData jsonData = new JsonData();
        try {
            Map queryMap = SerializeUtil.json2Map(jsonStr);
            String questionType = (String) queryMap.get("questionType");
            if (StringUtils.isEmpty(questionType)) {
                return jsonData;
            }
            if (StringUtils.isEmpty(sort)) {
                sort = "[{'property': 'subType', 'direction': 'ASC'}," +
                        "{'property': 'firstQuestionId', 'direction': 'ASC'}," +
                        "{'property': 'similarity', 'direction': 'DESC'}]";
            }
            jsonData = super.getAllEntityByQuery(page, limit, jsonStr, sort);
            EnrolmentDictBean enrolmentDictBean = enrolmentDictBeanService.getDictBeanByTypeAndValue(DICT_QUESTIONTYPE, questionType);
            String beanName = enrolmentDictBean.getDescription();
            Map<String, String> map = new HashMap<String, String>();
            map.put("beanName", beanName);
            questionService = JNDIHelper.getJNDIServiceForName(IQuestionService.class.getName(), map);
            for (int i = 0; i < jsonData.getData().size(); i++) {
                QuestionRepeatedBean questionRepeatedBean = (QuestionRepeatedBean) jsonData.getData().get(i);
                BaseQuestionEntity firstEntity = (BaseQuestionEntity) questionService.getEntity(questionRepeatedBean.getFirstQuestionId());
                BaseQuestionEntity secondEntity = (BaseQuestionEntity) questionService.getEntity(questionRepeatedBean.getSecondQuestionId());
                questionRepeatedBean.setFirstStem(firstEntity.getStem());
                questionRepeatedBean.setSecondStem(secondEntity.getStem());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonData;
    }

    @Override
    public JsonData getRepeatedByQuery(Integer page, Integer limit, String jsonStr, String sort) {
        JsonData jsonData = new JsonData();
        try {
            Map queryMap = SerializeUtil.json2Map(jsonStr);
            String questionType = (String) queryMap.get("questionType");
            if (StringUtils.isEmpty(questionType)) {
                return jsonData;
            }
            String sql = "select r.* from enrolment_question_repeated r, enrolment_question_completion y " +
                    " where r.firstquestionid = y.id and y.delflag = '0' and y.repeatedflag = '0' and " +
                    " r.similarity > (select s.similarity from enrolment_question_setting s where s.id = 1) " +
                    " order by r.subType, r.firstQuestionId, r.similarity desc";
            jsonData = this.dao.findByNativeSql(sql, page, limit, QuestionRepeatedBean.class);
            EnrolmentDictBean enrolmentDictBean = enrolmentDictBeanService.getDictBeanByTypeAndValue(DICT_QUESTIONTYPE, questionType);
            String beanName = enrolmentDictBean.getDescription();
            Map<String, String> map = new HashMap<String, String>();
            map.put("beanName", beanName);
            questionService = JNDIHelper.getJNDIServiceForName(IQuestionService.class.getName(), map);
            for (int i = 0; i < jsonData.getData().size(); i++) {
                QuestionRepeatedBean questionRepeatedBean = (QuestionRepeatedBean) jsonData.getData().get(i);
                BaseQuestionEntity firstEntity = (BaseQuestionEntity) questionService.getEntity(questionRepeatedBean.getFirstQuestionId());
                BaseQuestionEntity secondEntity = (BaseQuestionEntity) questionService.getEntity(questionRepeatedBean.getSecondQuestionId());
                questionRepeatedBean.setFirstStem(firstEntity.getStem());
                questionRepeatedBean.setSecondStem(secondEntity.getStem());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonData;
    }

    @Override
    @Transactional
    public JsonStatus saveSimilarity(QuestionRepeatedBean entity) {
        JsonStatus jsonStatus = new JsonStatus();
        try {
            String userName = shiroService.getCurrentUserRealName();
            Long userId = -1L;
            if (StringUtils.isEmpty(userName)) {
                userId = -1L;
                userName = "admin";
            } else {
                userId = shiroService.getCurrentUserId();
            }
            String sql = "select * from " + this.dao.getTableName() +
                    " where questionType = '" + entity.getQuestionType() + "' and firstQuestionId =" + entity.getFirstQuestionId() +
                    " and secondQuestionId = " + entity.getSecondQuestionId();
            List list = this.dao.findByNativeSql(sql, QuestionRepeatedBean.class);
            if (list != null && list.size() > 0) {
                entity.setId(((QuestionRepeatedBean) list.get(0)).getId());
                entity.setUpdateBy(userName);
                entity.setUpdateById(userId);
                entity.setUpdateDate(new Date());
            } else {
                entity.setId(0);
                entity.setCreateBy(userName);
                entity.setCreateById(userId);
                entity.setCreationDate(new Date());
                entity.setUpdateBy(userName);
                entity.setUpdateById(userId);
                entity.setUpdateDate(new Date());
            }
            this.dao.save(entity);
            jsonStatus.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            jsonStatus.setSuccess(false);
            jsonStatus.setMsg(e.getMessage());
        }
        return jsonStatus;
    }

    public void setEnrolmentDictBeanService(IEnrolmentDictBeanService enrolmentDictBeanService) {
        this.enrolmentDictBeanService = enrolmentDictBeanService;
    }
}
