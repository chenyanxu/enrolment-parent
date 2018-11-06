package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.IPaperQuesBeanService;
import com.kalix.enrolment.question.api.dao.IPaperQuesBeanDao;
import com.kalix.enrolment.question.entities.PaperQuesBean;
import com.kalix.framework.extend.impl.biz.LogicDeleteGenericBizServiceImpl;

/**
 * Created by zangyanming at 2018-09-13
 */
public class PaperQuesBeanServiceImpl extends LogicDeleteGenericBizServiceImpl<IPaperQuesBeanDao, PaperQuesBean> implements IPaperQuesBeanService {
}
