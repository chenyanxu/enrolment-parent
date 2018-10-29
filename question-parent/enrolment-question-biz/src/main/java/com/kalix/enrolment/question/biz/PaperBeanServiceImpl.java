package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.IChoiceBeanService;
import com.kalix.enrolment.question.api.biz.IPaperBeanService;
import com.kalix.enrolment.question.api.biz.IQuestionAuditService;
import com.kalix.enrolment.question.api.biz.ITestPaperService;
import com.kalix.enrolment.question.api.dao.IChoiceBeanDao;
import com.kalix.enrolment.question.api.dao.IPaperBeanDao;
import com.kalix.enrolment.question.api.model.QuestionType;
import com.kalix.enrolment.question.biz.util.Constants;
import com.kalix.enrolment.question.entities.ChoiceBean;
import com.kalix.enrolment.question.entities.PaperBean;
import com.kalix.framework.core.api.biz.IDownloadService;
import com.kalix.framework.extend.impl.biz.LogicDeleteGenericBizServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zangyanming at 2018-09-13
 */
public class PaperBeanServiceImpl extends LogicDeleteGenericBizServiceImpl<IPaperBeanDao, PaperBean>
        implements IPaperBeanService {
}
