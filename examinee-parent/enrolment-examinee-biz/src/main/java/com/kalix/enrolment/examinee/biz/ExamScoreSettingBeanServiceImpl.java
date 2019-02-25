package com.kalix.enrolment.examinee.biz;

import com.kalix.enrolment.examinee.api.biz.IExamScoreSettingBeanService;
import com.kalix.enrolment.examinee.api.dao.IExamScoreSettingBeanDao;
import com.kalix.enrolment.examinee.entities.ExamScoreSettingBean;
import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;

/**
 * Created by hqj on 2018-10-25.
 */
public class ExamScoreSettingBeanServiceImpl
        extends ShiroGenericBizServiceImpl<IExamScoreSettingBeanDao, ExamScoreSettingBean>
        implements IExamScoreSettingBeanService {
}
