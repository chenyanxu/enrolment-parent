package com.kalix.enrolment.question.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kalix.framework.core.api.persistence.PersistentEntity;
import com.kalix.framework.extend.api.entities.BaseLogicDeleteEntity;
import com.kalix.middleware.excel.api.annotation.ExcelField;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator_ on 2018/9/6.
 */
@Entity
@Table(name = "enrolment_question_completion")
public class CompletionBean extends BaseLogicDeleteEntity {
    @Column(nullable = false)
    private String type;            // 类别,字典（类别）
    @Lob
    @Column(nullable = false)
    private String stem;            // 题干
    @Column(nullable = false)
    private String answerA;         // 答案A
    private String answerB;         // 答案B
    private String answerC;         // 答案C
    private String answerD;         // 答案D
    private String answerE;         // 答案E
    private String answerF;         // 答案F
    private String answerG;         // 答案G
    private String analysis;        // 试题解析
    private String checkFlag = "0"; // 审核状态，字典[审核状态]
    private Long checkerId;         // 审核员id
    private String checker;         // 审核员
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date checkDate;         // 审核时间

    @ExcelField(title="类别", align=2, dictType="类别", sort=10)
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    @ExcelField(title="题干", align=2, sort=20)
    public String getStem() {
        return stem;
    }
    public void setStem(String stem) {
        this.stem = stem;
    }

    @ExcelField(title="空格A答案", align=2, sort=30)
    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    @ExcelField(title="空格B答案", align=2, sort=40)
    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    @ExcelField(title="空格C答案", align=2, sort=50)
    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    @ExcelField(title="空格D答案", align=2, sort=60)
    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    @ExcelField(title="空格E答案", align=2, sort=70)
    public String getAnswerE() {
        return answerE;
    }

    public void setAnswerE(String answerE) {
        this.answerE = answerE;
    }

    @ExcelField(title="空格F答案", align=2, sort=80)
    public String getAnswerF() {
        return answerF;
    }

    public void setAnswerF(String answerF) {
        this.answerF = answerF;
    }

    @ExcelField(title="空格G答案", align=2, sort=90)
    public String getAnswerG() {
        return answerG;
    }

    public void setAnswerG(String answerG) {
        this.answerG = answerG;
    }

    @ExcelField(title="试题解析", align=2, sort=100)
    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public String getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(String checkFlag) {
        this.checkFlag = checkFlag;
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
}
