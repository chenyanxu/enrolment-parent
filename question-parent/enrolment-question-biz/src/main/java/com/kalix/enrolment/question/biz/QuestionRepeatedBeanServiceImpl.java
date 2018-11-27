package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.IQuestionRepeatedBeanService;
import com.kalix.enrolment.question.api.dao.IQuestionRepeatedBeanDao;
import com.kalix.enrolment.question.entities.QuestionRepeatedBean;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;
import com.kalix.framework.core.util.SerializeUtil;
import com.kalix.framework.core.util.StringUtils;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by hqj on 2018-10-25.
 */
public class QuestionRepeatedBeanServiceImpl
        extends ShiroGenericBizServiceImpl<IQuestionRepeatedBeanDao, QuestionRepeatedBean>
        implements IQuestionRepeatedBeanService {

    /*protected static String DICT_QUESTIONTYPE = "题型";
    protected IEnrolmentDictBeanService enrolmentDictBeanService;
    protected IQuestionService questionService;*/

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
    public JsonData getAllEntityByQuery(Integer page, Integer limit, String jsonStr, String sort) {
        JsonData jsonData = new JsonData();
        try {
            Map queryMap = SerializeUtil.json2Map(jsonStr);
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
            jsonStr = SerializeUtil.serializeJson(queryMap);
            jsonData = super.getAllEntityByQuery(page, limit, jsonStr, sort);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonData;
    }

    /*@Override
    public JsonData getAllRepeatedByQuery(Integer page, Integer limit, String jsonStr, String sort) {
        JsonData jsonData = new JsonData();
        try {
            Map queryMap = SerializeUtil.json2Map(jsonStr);
            String questionType = (String) queryMap.get("questionType");
            if (StringUtils.isEmpty(questionType)) {
                return jsonData;
            }
            // 默认排序
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
    }*/

    /*@Override
    public JsonData getRepeatedByQuery(Integer page, Integer limit, String jsonStr, String sort) {
        JsonData jsonData = new JsonData();
        try {
            Map queryMap = SerializeUtil.json2Map(jsonStr);
            String questionType = (String) queryMap.get("questionType");
            if (StringUtils.isEmpty(questionType)) {
                return jsonData;
            }
            EnrolmentDictBean enrolmentDictBean = enrolmentDictBeanService.getDictBeanByTypeAndValue(DICT_QUESTIONTYPE, questionType);
            String beanName = enrolmentDictBean.getDescription();
            Map<String, String> map = new HashMap<String, String>();
            map.put("beanName", beanName);
            questionService = JNDIHelper.getJNDIServiceForName(IQuestionService.class.getName(), map);
            String questionTableName = questionService.getQuestionTableName();
            String sql = "";
            // 增加数据权限
            Long userId = shiroService.getCurrentUserId();
            if (this.dataAuthService == null) {
                this.dataAuthService = JNDIHelper.getJNDIServiceForName(IDataAuthService.class.getName());
            }
            EnumDataAuth enumDataAuth = dataAuthService.getDataAuth(userId);
            switch (enumDataAuth) {
                // 本人数据
                case SELF:
                    sql = "select r.* from enrolment_question_repeated r, " + questionTableName + " y " +
                            " where r.firstquestionid = y.id and y.delflag = '0' and y.repeatedflag = '0' and " +
                            " y.createbyid = " + userId + " and " +
                            " r.similarity > (select s.similarity from enrolment_question_setting s where s.id = 1) " +
                            " order by r.subType, r.firstQuestionId, r.similarity desc";
                    break;
                // 所有数据
                case ALL:
                    sql = "select r.* from enrolment_question_repeated r, " + questionTableName + " y " +
                            " where r.firstquestionid = y.id and y.delflag = '0' and y.repeatedflag = '0' and " +
                            " r.similarity > (select s.similarity from enrolment_question_setting s where s.id = 1) " +
                            " order by r.subType, r.firstQuestionId, r.similarity desc";
                    break;
            }
            jsonData = this.dao.findByNativeSql(sql, page, limit, QuestionRepeatedBean.class);
            // 字段翻译
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
    }*/

    @Override
    @Transactional
    public int saveSimilarity(QuestionRepeatedBean entity) {
        int rtn = 0;
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
            rtn = 1;
        } catch (Exception e) {
            e.printStackTrace();
            rtn = 0;
        }
        return rtn;
    }
}
