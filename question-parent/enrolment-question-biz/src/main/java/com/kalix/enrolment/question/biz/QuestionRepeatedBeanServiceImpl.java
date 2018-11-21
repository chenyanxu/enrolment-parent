package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.IQuestionRepeatedBeanService;
import com.kalix.enrolment.question.api.dao.IQuestionRepeatedBeanDao;
import com.kalix.enrolment.question.entities.QuestionRepeatedBean;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;

/**
 * Created by hqj on 2018-10-25.
 */
public class QuestionRepeatedBeanServiceImpl
        extends ShiroGenericBizServiceImpl<IQuestionRepeatedBeanDao, QuestionRepeatedBean>
        implements IQuestionRepeatedBeanService {

    @Override
    public JsonData getAllRepeatedCountDTO(String jsonStr) {
        JsonData jsonData = new JsonData();
        return jsonData;
    }
}
