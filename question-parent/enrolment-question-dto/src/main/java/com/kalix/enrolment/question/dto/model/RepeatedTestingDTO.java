package com.kalix.enrolment.question.dto.model;

import com.kalix.framework.core.api.web.model.BaseDTO;

/**
 * Created by Administrator_ on 2018/9/17.
 */
public class RepeatedTestingDTO extends BaseDTO {
    private String questionType;     // 题型
    private String questionTypeName; // 题型名称
    private String questionBeans;    // 题型beans
    private String subType;          // 题型子类
    private String subTypeName;      // 题型子类名称
    private Integer repeatedCount;   // 重复数量
    private String stem;             // 题干

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getQuestionTypeName() {
        return questionTypeName;
    }

    public void setQuestionTypeName(String questionTypeName) {
        this.questionTypeName = questionTypeName;
    }

    public String getQuestionBeans() {
        return questionBeans;
    }

    public void setQuestionBeans(String questionBeans) {
        this.questionBeans = questionBeans;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getSubTypeName() {
        return subTypeName;
    }

    public void setSubTypeName(String subTypeName) {
        this.subTypeName = subTypeName;
    }

    public Integer getRepeatedCount() {
        return repeatedCount;
    }

    public void setRepeatedCount(Integer repeatedCount) {
        this.repeatedCount = repeatedCount;
    }

    public String getStem() {
        return stem;
    }

    public void setStem(String stem) {
        this.stem = stem;
    }
}
