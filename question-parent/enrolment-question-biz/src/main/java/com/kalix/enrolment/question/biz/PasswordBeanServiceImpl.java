package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.IPaperBeanService;
import com.kalix.enrolment.question.api.biz.IPasswordBeanService;
import com.kalix.enrolment.question.api.dao.IPaperBeanDao;
import com.kalix.enrolment.question.api.dao.IPasswordBeanDao;
import com.kalix.enrolment.question.entities.PaperBean;
import com.kalix.enrolment.question.entities.PasswordBean;
import com.kalix.framework.extend.impl.biz.LogicDeleteGenericBizServiceImpl;

/**
 * Created by zangyanming at 2018-09-13
 */
public class PasswordBeanServiceImpl extends LogicDeleteGenericBizServiceImpl<IPasswordBeanDao, PasswordBean> implements IPasswordBeanService {
}
