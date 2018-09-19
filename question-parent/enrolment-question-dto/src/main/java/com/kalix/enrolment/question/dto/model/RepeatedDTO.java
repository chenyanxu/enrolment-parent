package com.kalix.enrolment.question.dto.model;

import com.kalix.framework.core.api.web.model.BaseDTO;

/**
 * Created by Administrator_ on 2018/9/17.
 */
public class RepeatedDTO extends BaseDTO {

    private Integer questionId;// 试题id
    private String stem; //题干
    private String similarity ; //相似度

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getStem() {
        return stem;
    }

    public void setStem(String stem) {
        this.stem = stem;
    }

    public String getSimilarity() {
        return similarity;
    }

    public void setSimilarity(String similarity) {
        this.similarity = similarity;
    }
}
