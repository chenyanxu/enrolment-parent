package com.kalix.enrolment.question.api.biz;

import com.kalix.enrolment.question.dto.model.RepeatedDTO;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;

/**
 * Created by Administrator_ on 2018/9/17.
 */
public interface IRepeatedService {

    // 去重函数
    //JsonData doRepeate(String type);

    //填空题去重
    //JsonData doRepeate(RepeatedDTO c_repeatedDTO);

    JsonData getSingleRepeates(String subType);

    //保留重复
    JsonStatus doSaveRepeate(Long questionId);

    //删除重复
    JsonStatus doDeleteRepeate(Long questionId);
}
