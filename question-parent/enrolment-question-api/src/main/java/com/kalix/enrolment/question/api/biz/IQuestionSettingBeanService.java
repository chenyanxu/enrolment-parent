package com.kalix.enrolment.question.api.biz;

import com.kalix.enrolment.question.entities.QuestionSettingBean;
import com.kalix.framework.core.api.biz.IBizService;
import com.kalix.framework.core.api.persistence.JsonStatus;

/**
 * Created by dell on 14-1-17.
 */
public interface IQuestionSettingBeanService extends IBizService<QuestionSettingBean> {

    /*int updateRepeated(Long id, Boolean repeated);*/

    int updateCompareCompletion(Long id, Boolean compareStatus);

    int updateCompareChoice(Long id, Boolean compareStatus);

    int updateCompareVerse(Long id, Boolean compareStatus);

    int updateCompareMusic(Long id, Boolean compareStatus);

    int updateCompareSubject(Long id, Boolean compareStatus);

    int updateCompareInterview(Long id, Boolean compareStatus);
}
