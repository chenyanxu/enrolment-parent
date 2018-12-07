package com.kalix.enrolment.question.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by zangyanming on 2018/10/8.
 */
@Entity
@Table(name = "enrolment_question_music")
public class MusicBean extends BaseQuestionEntity {
    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy", timezone = "GMT+8")
    private Date year;                 // 年份
    @Column(length = 2000)
    private String answerConstraint;   // 答题要求
    @Column(length = 2000)
    private String scoreStandard;      // 评分标准

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getAnswerConstraint() {
        return answerConstraint;
    }

    public void setAnswerConstraint(String answerConstraint) {
        this.answerConstraint = answerConstraint;
    }

    public String getScoreStandard() {
        return scoreStandard;
    }

    public void setScoreStandard(String scoreStandard) {
        this.scoreStandard = scoreStandard;
    }
}
