package com.kalix.enrolment.question.api.biz;

import com.kalix.enrolment.question.entities.ChoiceBean;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.extend.api.biz.ILogicDeleteService;

import java.util.Map;

/**
 * Created by zangyanming at 2018-09-13.
 */
public interface IFreemarkerService {

    public String createDoc(String fileName, Map tempMap);

}
