package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.IChoiceBeanService;
import com.kalix.enrolment.question.api.dao.IChoiceBeanDao;
import com.kalix.enrolment.question.entities.ChoiceBean;
import com.kalix.framework.extend.impl.biz.LogicDeleteGenericBizServiceImpl;

/**
 * Created by angyanming at 2018-09-13
 */
public class ChoiceBeanServiceImpl extends LogicDeleteGenericBizServiceImpl<IChoiceBeanDao, ChoiceBean> implements IChoiceBeanService {
}
