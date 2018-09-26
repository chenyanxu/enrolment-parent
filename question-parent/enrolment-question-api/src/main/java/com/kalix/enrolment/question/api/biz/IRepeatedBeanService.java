package com.kalix.enrolment.question.api.biz;

import com.kalix.enrolment.question.dto.model.RepeatedDTO;
import com.kalix.enrolment.question.entities.CompletionBean;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;

import java.util.List;

/**
 * Created by Administrator_ on 2018/9/17.
 */
public interface IRepeatedBeanService {

    // 去重函数
    public JsonData doRepeate(String type);

    //填空题去重(全库)
    public JsonData doRepeateCompletion();

    //选择题去重(全库)
    public JsonData doRepeateChoiceBean();

    //补全诗句去重(全库)
    public JsonData doRepeateVerseBean();


    //填空题去重
    public JsonData doRepeate(RepeatedDTO c_repeatedDTO);



    //保留
    public JsonStatus doSave(Long questionId,String questionType);

    //删除
    public JsonStatus doDelete(Long questionId,String questionType);
}
