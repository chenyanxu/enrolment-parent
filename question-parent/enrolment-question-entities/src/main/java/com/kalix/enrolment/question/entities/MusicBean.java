package com.kalix.enrolment.question.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kalix.framework.extend.api.entities.BaseLogicDeleteEntity;
import com.kalix.middleware.excel.api.annotation.ExcelField;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by zangyanming on 2018/10/8.
 */
@Entity
@Table(name = "enrolment_question_music")
public class MusicBean extends BaseLogicDeleteEntity {
    @Lob
    @Column(nullable = false)
    private String stem;               // 题干
    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy", timezone = "GMT+8")
    private Date year;                 // 年份
    private String answerConstraint;   // 答题要求
    private String analysis;           // 试题解析
    private String scoreStandard;      // 评分标准
    private Long checkerId;            // 审核员id
    private String checker;            // 审核员
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date checkDate;            // 审核时间
    private String checkReason;        // 审核不通过原因
    private String repeatedFlag = "0"; // 题库排重标识

    @ExcelField(title = "题干", align = 1, sort = 10)
    public String getStem() {
        return stem;
    }

    public void setStem(String stem) {
        this.stem = stem;
    }

    @ExcelField(title = "年份", align = 1, sort = 20)
    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    @ExcelField(title = "答题要求", align = 1, sort = 30)
    public String getAnswerConstraint() {
        return answerConstraint;
    }

    public void setAnswerConstraint(String answerConstraint) {
        this.answerConstraint = answerConstraint;
    }

    @ExcelField(title = "试题解析", align = 1, sort = 40)
    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    @ExcelField(title = "评分标准", align = 1, sort = 50)
    public String getScoreStandard() {
        return scoreStandard;
    }

    public void setScoreStandard(String scoreStandard) {
        this.scoreStandard = scoreStandard;
    }

    public Long getCheckerId() {
        return checkerId;
    }

    public void setCheckerId(Long checkerId) {
        this.checkerId = checkerId;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public String getCheckReason() {
        return checkReason;
    }

    public void setCheckReason(String checkReason) {
        this.checkReason = checkReason;
    }

    public String getRepeatedFlag() {
        return repeatedFlag;
    }

    public void setRepeatedFlag(String repeatedFlag) {
        this.repeatedFlag = repeatedFlag;
    }
}
