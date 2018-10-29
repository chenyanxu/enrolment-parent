package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.IQuestionSettingBeanService;
import com.kalix.enrolment.question.api.dao.IQuestionSettingBeanDao;
import com.kalix.enrolment.question.entities.QuestionSettingBean;
import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;

/**
 * Created by hqj on 2018-10-25.
 */
public class QuestionSettingBeanServiceImpl
        extends ShiroGenericBizServiceImpl<IQuestionSettingBeanDao, QuestionSettingBean>
        implements IQuestionSettingBeanService {
}
