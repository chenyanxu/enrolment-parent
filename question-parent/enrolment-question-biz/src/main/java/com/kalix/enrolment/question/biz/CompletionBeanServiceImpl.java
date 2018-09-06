package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.ICompletionBeanService;
import com.kalix.enrolment.question.api.dao.ICompletionBeanDao;
import com.kalix.enrolment.question.entities.CompletionBean;
import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;

/**
 * Created by Administrator_ on 2018/9/6.
 */
public class CompletionBeanServiceImpl extends ShiroGenericBizServiceImpl<ICompletionBeanDao, CompletionBean> implements ICompletionBeanService {
}
