package com.kalix.enrolment.question.api.biz;

import com.kalix.enrolment.question.entities.BaseQuestionEntity;
import com.kalix.framework.extend.api.biz.ILogicDeleteService;

import java.text.ParseException;
import java.util.Map;

/**
 * Created by hqj at 2018-10-30.
 */
public interface IQuestionService<T extends BaseQuestionEntity> extends ILogicDeleteService<T> {

    String getQuestionType();

    String getQuestionTypeName();

    String getQuestionBeans();

    String getSubTypeDictType();

    String getSubTypeName(String subType);

    String getAuditRoleName(String subType);

    /**
     * 获取题库单项题型预览模板文件名
     *
     * @param subType
     * @return
     */
    String getTempName(String subType);

    /**
     * 生成试卷单项题型试题结果
     *
     * @return
     */
    Map<String, Object> createSingleTestPaper(Map paperMap) throws ParseException;
}
