package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.ITestBeanService;
import com.kalix.enrolment.question.api.dao.ITestBeanDao;
import com.kalix.enrolment.question.entities.TestBean;
import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;

/**
 * Created by Administrator_ on 2018/9/6.
 */
public class TestBeanServiceImpl extends ShiroGenericBizServiceImpl<ITestBeanDao, TestBean> implements ITestBeanService {
}
