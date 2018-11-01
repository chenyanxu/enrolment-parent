package com.kalix.enrolment.question.api.biz;

import com.kalix.framework.core.api.IService;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;

/**
 * Created by hqj at 2018-10-31.
 */
public interface IQuestionCommonBizService extends IService {

    /**
     * 全库排重
     *
     * @return
     */
    JsonData getAllRepeates();

    /**
     * 根据试卷及试卷规则参数自动生成试卷
     *
     * @param paperId
     * @return
     */
    JsonStatus autoCreateTestPaper(Long paperId);

    JsonStatus autoCreateTestPaper();
}
