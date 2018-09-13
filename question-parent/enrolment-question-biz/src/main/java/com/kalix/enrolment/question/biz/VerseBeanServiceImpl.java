package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.IVerseBeanService;
import com.kalix.enrolment.question.api.dao.IVerseBeanDao;
import com.kalix.enrolment.question.entities.VerseBean;
import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;

/**
 * Created by angyanming at 2018-09-13
 */
public class VerseBeanServiceImpl extends ShiroGenericBizServiceImpl<IVerseBeanDao, VerseBean> implements IVerseBeanService {
}
