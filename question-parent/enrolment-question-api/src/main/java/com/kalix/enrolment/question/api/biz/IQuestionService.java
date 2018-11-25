package com.kalix.enrolment.question.api.biz;

import com.kalix.enrolment.question.entities.BaseQuestionEntity;
import com.kalix.framework.extend.api.biz.ILogicDeleteService;

import java.text.ParseException;
import java.util.Map;

/**
 * Created by hqj at 2018-10-30.
 */
public interface IQuestionService<T extends BaseQuestionEntity> extends ILogicDeleteService<T> {

    /**
     * 获取题型代码
     *
     * @return
     */
    String getQuestionType();

    /**
     * 获取题型名称
     *
     * @return
     */
    String getQuestionTypeName();

    /**
     * 获取题型beans
     *
     * @return
     */
    String getQuestionBeans();

    /**
     * 获取题型子类字典type
     *
     * @return
     */
    String getSubTypeDictType();

    /**
     * 获取题型子类名称
     *
     * @param subType
     * @return
     */
    String getSubTypeName(String subType);

    /**
     * 获取试题表名
     *
     * @return
     */
    String getQuestionTableName();

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
