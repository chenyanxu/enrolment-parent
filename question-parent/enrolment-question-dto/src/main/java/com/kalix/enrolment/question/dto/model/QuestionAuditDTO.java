package com.kalix.enrolment.question.dto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kalix.framework.core.api.web.model.BaseDTO;

import java.util.Date;

/**
 * Created by Administrator_ on 2018/9/17.
 */
public class QuestionAuditDTO extends BaseDTO {
    private Integer auditorNum = 0;    // 审核人数量
    private Integer questionNum = 0;   // 审核试题数量
    private Integer completeNum = 0;   // 审核完成数量
    private Integer completeTotal = 0; // 审核完成总量

    public Integer getAuditorNum() {
        return auditorNum;
    }

    public void setAuditorNum(Integer auditorNum) {
        this.auditorNum = auditorNum;
    }

    public Integer getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(Integer questionNum) {
        this.questionNum = questionNum;
    }

    public Integer getCompleteNum() {
        return completeNum;
    }

    public void setCompleteNum(Integer completeNum) {
        this.completeNum = completeNum;
    }

    public Integer getCompleteTotal() {
        return completeTotal;
    }

    public void setCompleteTotal(Integer completeTotal) {
        this.completeTotal = completeTotal;
    }
}
