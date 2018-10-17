package com.kalix.enrolment.question.api.biz;

import com.kalix.framework.core.api.IService;

import java.util.Map;

/**
 * Created by zangyanming at 2018-09-13.
 */
public interface IFreemarkerService extends IService {

    String createDoc(String fileName, Map tempMap);
}
