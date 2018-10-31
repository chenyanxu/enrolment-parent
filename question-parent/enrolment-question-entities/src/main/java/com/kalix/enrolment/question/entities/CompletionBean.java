package com.kalix.enrolment.question.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator_ on 2018/9/6.
 */
@Entity
@Table(name = "enrolment_question_completion")
public class CompletionBean extends BaseQuestionEntity {
    @Column(nullable = false)
    private String type;               // 类别，字典[类别]
    @Column(nullable = false)
    private String answerA;            // 答案A
    private String answerB;            // 答案B
    private String answerC;            // 答案C
    private String answerD;            // 答案D
    private String answerE;            // 答案E
    private String answerF;            // 答案F
    private String answerG;            // 答案G
    private int spaceNum;              // 填空个数

    public int getSpaceNum() {
        return spaceNum;
    }

    public void setSpaceNum(int spaceNum) {
        this.spaceNum = spaceNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}
