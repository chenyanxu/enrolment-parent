package com.kalix.enrolment.question.api.biz;

import com.kalix.framework.core.api.IService;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;

/**
 * Created by hqj at 2018-10-31.
 */
public interface IQuestionCommonBizService extends IService {

    /**
     * 比较全库试题相似度
     * @return
     */
    JsonStatus compareAllSimilarity();

    /**
     * 查询题库试题，获取试题检测需要的试题
     */
    JsonData getAllQuestionTestings(Integer page, Integer limit, String jsonStr, String sort);

    /**
     * 全库排重处理(处理比对非重复数据)
     *
     * @return
     */
    JsonData getAllRepeates(Integer page, Integer limit, String jsonStr, String sort);

    JsonStatus initAllRepeated();

    /**
     * 根据试卷及试卷规则参数自动生成试卷
     *
     * @param paperId
     * @return
     */
    JsonStatus autoCreateTestPaper(Long paperId);

    JsonStatus deletePaper(String ids);
}
