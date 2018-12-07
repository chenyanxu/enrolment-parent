package com.kalix.enrolment.question.dto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kalix.framework.core.api.web.model.BaseDTO;

import java.util.Date;

/**
 * Created by Administrator_ on 2018/9/17.
 */
public class QuestionDTO extends BaseDTO {

    private String questionType;     // 题型
    private String questionTypeName; // 题型名称
    private String questionBeans;    // 题型beans
    private String subType;          // 题型子类
    private String subTypeName;      // 题型子类名称
    private String type;             // 试题类别
    private String typeName;         // 试题类别名称
    private Long questionId;         // 试题id
    private String stem;             // 题干
    private String answerA;          // 选择题选项A
    private String answerB;          // 选择题选项B
    private String answerC;          // 选择题选项C
    private String answerD;          // 选择题选项D
    private String analysis;         // 试题解析
    private String checkFlag;        // 审核状态，字典[审核状态]
    private Long checkerId;          // 审核员id
    private String checker;          // 审核员
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date checkDate;          // 审核时间
    private String checkReason;      // 审核不通过原因
    private String repeatedFlag;     // 题库排重标识
    private String delFlag;          // 逻辑删除标识
    private String reason;           // 逻辑删除原因
    private String compareFlag;      // 试题排重比对标识
    private String opFlag;           // 排重处理标识
    private double similarity;       // 试题相似度
    private String similarityDesc;   // 试题相似度说明

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getStem() {
        return stem;
    }

    public void setStem(String stem) {
        this.stem = stem;
    }

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

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCompareFlag() {
        return compareFlag;
    }

    public void setCompareFlag(String compareFlag) {
        this.compareFlag = compareFlag;
    }

    public double getSimilarity() {
        return similarity;
    }

    public void setSimilarity(double similarity) {
        this.similarity = similarity;
    }

    public String getSimilarityDesc() {
        return similarityDesc;
    }

    public void setSimilarityDesc(String similarityDesc) {
        this.similarityDesc = similarityDesc;
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

    public String getOpFlag() {
        return opFlag;
    }

    public void setOpFlag(String opFlag) {
        this.opFlag = opFlag;
    }
}
