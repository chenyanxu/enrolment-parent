package com.kalix.enrolment.question.api.biz;

import com.kalix.enrolment.question.dto.model.CompareQuestionDTO;
import com.kalix.framework.core.api.IService;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;

/**
 * Created by Administrator_ on 2018/9/17.
 */
public interface IRepeatedService extends IService {

    /**
     * 试题排重比较相似度
     *
     * @return
     */
    JsonStatus compareAllSimilarity(String subType);

    /**
     * 查询排重比较是否进行
     *
     * @return
     */
    boolean getCompareStatus();

    /**
     * 更新排重比较进行状态
     *
     * @param id
     * @param compareStatus
     * @return
     */
    int updateCompareStatus(Long id, Boolean compareStatus);

    /**
     * 更新试题排重比较结果（包括比较状态和排重状态 0未比较，1比较完成；0有重复，1无重复）
     *
     * @param id
     * @param compareFlag
     * @param repeatedFlag
     * @return
     */
    int updateCompareFlag(Long id, String compareFlag, String repeatedFlag);

    /**
     * 新增或编辑题型数据时验证排重(前台需要传递题干)
     *
     * @param compareQuestionDTO
     * @return
     */
    JsonData validateRepeates(CompareQuestionDTO compareQuestionDTO);

    /**
     * 保留重复
     *
     * @param questionId
     * @return
     */
    JsonStatus doSaveRepeate(Long questionId);

    /**
     * 删除重复
     *
     * @param questionId
     * @return
     */
    JsonStatus doDeleteRepeate(Long questionId);

    /**
     * 试题排重比较相似度，单题执行
     *
     * @param questionId
     */
    JsonStatus compareSingleSimilarity(Long questionId);

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
     * 获取题干相同的试题
     *
     * @return
     */
    JsonData getTheSameStem(String jsonStr);
}
