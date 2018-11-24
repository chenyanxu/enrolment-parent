package com.kalix.enrolment.question.api.biz;

import com.kalix.enrolment.question.dto.model.BaseQuestionDTO;
import com.kalix.enrolment.question.dto.model.CompareQuestionDTO;
import com.kalix.framework.core.api.IService;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;

import java.util.List;

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
     * 更新试题排重比较相似度结果状态（0未比较，1比较完成）
     *
     * @param id
     * @param compareFlag
     * @return
     */
    int updateCompareFlag(Long id, String compareFlag);

    /**
     * 新增或编辑题型数据时验证排重(前台需要传递题干)
     * @param compareQuestionDTO
     * @return
     */
    JsonData validateRepeates(CompareQuestionDTO compareQuestionDTO);

    /**
     * 保留重复
     * @param questionId
     * @return
     */
    JsonStatus doSaveRepeate(Long questionId);

    /**
     * 删除重复
     * @param questionId
     * @return
     */
    JsonStatus doDeleteRepeate(Long questionId);

    /**
     * 试题排重比较相似度，单题执行
     * @param questionId
     */
    JsonStatus compareSingleSimilarity(Long questionId);

    // 重复情况查询(不处理)
    JsonData getRepeates(String jsonStr, boolean isAll);

    // 查询重复
    JsonData getRepeates(Long questionId);
}
