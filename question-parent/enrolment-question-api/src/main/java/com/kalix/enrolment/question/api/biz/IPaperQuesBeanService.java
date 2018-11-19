package com.kalix.enrolment.question.api.biz;

import com.kalix.enrolment.question.entities.PaperQuesBean;
import com.kalix.framework.extend.api.biz.ILogicDeleteService;

import java.util.List;

/**
 * Created by zangyanming at 2018-09-13.
 */
public interface IPaperQuesBeanService extends ILogicDeleteService<PaperQuesBean> {
    void deleteByUuid(String uuid);
}
