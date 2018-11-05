package com.kalix.enrolment.question.api.biz;

import com.kalix.enrolment.question.dto.model.RepeatedDTO;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;

/**
 * Created by Administrator_ on 2018/9/17.
 */
public interface IRepeatedService {

    // 单一题型全库排重
    JsonData getSingleRepeates(String subType);

    // 保留重复
    JsonStatus doSaveRepeate(Long questionId);

    // 删除重复
    JsonStatus doDeleteRepeate(Long questionId);

    // 新增或编辑题型数据时验证排重
    JsonData validateRepeates(RepeatedDTO repeatedDTO);
}