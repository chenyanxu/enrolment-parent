package com.kalix.enrolment.question.api.biz;

import com.kalix.enrolment.question.entities.ChoiceBean;
import com.kalix.framework.core.api.IService;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.extend.api.biz.ILogicDeleteService;

import java.util.Map;

/**
 * Created by zangyanming at 2018-09-13.
 */
public interface ITestPaperService extends IService {
    public JsonStatus createTestPaper(String fileName, Map tempMap);
    public JsonStatus createTestPaper();
}
