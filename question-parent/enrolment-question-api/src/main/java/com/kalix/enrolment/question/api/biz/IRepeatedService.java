package com.kalix.enrolment.question.api.biz;

import com.kalix.enrolment.question.dto.model.BaseQuestionDTO;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;

import java.util.List;

/**
 * Created by Administrator_ on 2018/9/17.
 */
public interface IRepeatedService {

    // 新增或编辑题型数据时验证排重(前台需要传递题干)
    JsonData validateRepeates(BaseQuestionDTO baseQuestionDTO);

    // 单一题型全库排重(带处理)
    List getSingleRepeates(String subType, boolean isAll);

    // 重复情况查询(不处理)
    JsonData getRepeates(String jsonStr, boolean isAll);

    // 查询重复
    JsonData getRepeates(Long questionId);

    // 保留重复
    JsonStatus doSaveRepeate(Long questionId);

    // 删除重复
    JsonStatus doDeleteRepeate(Long questionId);
}
