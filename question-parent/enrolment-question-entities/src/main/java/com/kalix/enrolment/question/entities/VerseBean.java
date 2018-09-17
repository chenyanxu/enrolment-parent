package com.kalix.enrolment.question.entities;

import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * Created by zangyanming on 2018/9/13.
 */
@Entity
@Table(name = "enrolment_question_verse")
public class VerseBean extends PersistentEntity {
    @Column(nullable = false)
    private Integer type; // 类别,字典（类别）
    @Lob
    @Column(nullable = false)
    private String stem;  // 题干
    @Column(nullable = false)
    private String answerA; //空格A答案
    private String answerB; //空格B答案
    private String answerC; //空格C答案
    private String answerD; //空格D答案
    private String answerE; //空格E答案
    private String answerF; //空格F答案
    private String answerG; //空格G答案
    private String analysis; //试题解析

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getStem() {
        return stem;
    }

    public void setStem(String stem) {
        this.stem = stem;
    }

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
