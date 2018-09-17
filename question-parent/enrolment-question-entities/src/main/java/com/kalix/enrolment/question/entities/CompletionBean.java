package com.kalix.enrolment.question.entities;

import com.kalix.framework.core.api.persistence.PersistentEntity;
import com.kalix.framework.extend.api.entities.BaseLogicDeleteEntity;
import com.kalix.middleware.excel.api.annotation.ExcelField;

import javax.persistence.*;

/**
 * Created by Administrator_ on 2018/9/6.
 */
@Entity
@Table(name = "enrolment_question_completion")
public class CompletionBean extends BaseLogicDeleteEntity {
    @Column(nullable = false)
    private String type; // 类别,字典（类别）
    @Lob
    @Column(nullable = false)
    private String stem;  // 题干
    @Column(nullable = false)
    private String answerA; //答案A
    private String answerB; //答案B
    private String answerC; //答案C
    private String answerD; //答案D
    private String answerE; //答案E
    private String answerF; //答案F
    private String answerG; //答案G
    private String analysis; //试题解析


    @ExcelField(title="类别", align=1, dictType="类别", sort=10)
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

    @ExcelField(title="答案A", align=2, sort=20)
    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public String getAnswerE() {
        return answerE;
    }

    public void setAnswerE(String answerE) {
        this.answerE = answerE;
    }

    public String getAnswerF() {
        return answerF;
    }

    public void setAnswerF(String answerF) {
        this.answerF = answerF;
    }

    public String getAnswerG() {
        return answerG;
    }

    public void setAnswerG(String answerG) {
        this.answerG = answerG;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }
}
