package com.kalix.enrolment.question.api.biz;

import com.kalix.framework.core.api.IService;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;

/**
 * Created by hqj at 2018-10-31.
 */
public interface IQuestionCommonBizService extends IService {

    /**
     * 查询试题排重比对情况
     *
     * @param page
     * @param limit
     * @param jsonStr
     * @param sort
     * @return
     */
    JsonData getAllQuestionRepeateds(Integer page, Integer limit, String jsonStr, String sort);

    /**
     * 获取比对后有重复的试题
     *
     * @param page
     * @param limit
     * @param jsonStr
     * @param sort
     * @return
     */
    JsonData getFirstQuestions(Integer page, Integer limit, String jsonStr, String sort);

    /**
     * 选择一道试题后，获取和该试题重复的所有试题
     *
     * @param page
     * @param limit
     * @param jsonStr
     * @param sort
     * @return
     */
    JsonData getSecondQuestions(Integer page, Integer limit, String jsonStr, String sort);

    /**
     * 查询题库试题，获取试题检测需要的试题
     */
    JsonData getAllQuestionTestings(Integer page, Integer limit, String jsonStr, String sort);

    /**
     * 根据试卷及试卷规则参数自动生成试卷
     *
     * @param paperId
     * @return
     */
    JsonStatus autoCreateTestPaper(Long paperId);

    JsonStatus deletePaper(String ids);
    JsonStatus reductionPaper(String ids);

}
