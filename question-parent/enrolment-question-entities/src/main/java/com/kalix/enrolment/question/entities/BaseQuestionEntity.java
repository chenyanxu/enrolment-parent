package com.kalix.enrolment.question.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kalix.framework.extend.api.entities.BaseLogicDeleteEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zangyanming on 2018/9/13.
 */
@MappedSuperclass
@Access(AccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BaseQuestionEntity extends BaseLogicDeleteEntity {
    @Lob
    @Column(nullable = false)
    private String stem;               // 题干
    @Column(length = 2000)
    private String analysis;           // 试题解析
    private String checkFlag = "0";    // 审核状态，字典[审核状态]
    private Long checkerId;            // 审核员id
    private String checker;            // 审核员
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date checkDate;            // 审核时间
    private String checkReason;        // 审核不通过原因
    private String repeatedFlag = "0"; // 题库排重标识
    private String compareFlag = "0";  // 题库排重比对标识

    private String type;               // 试题类别,字典（可以为空）
    private String subType;            // 试题子类类型,字典（可以为空）
    private String opFlag = "0";       // 操作标识(目前使用其记录排重处理保留的数据值1,删除的数据值2,为新增排重审核功能使用)

    @Transient
    private double similarity;         // 试题相似度
    @Transient
    private String similarityDesc;     // 试题相似度描述

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getCompareFlag() {
        return compareFlag;
    }

    public void setCompareFlag(String compareFlag) {
        this.compareFlag = compareFlag;
    }

    public String getOpFlag() {
        return opFlag;
    }

    public void setOpFlag(String opFlag) {
        this.opFlag = opFlag;
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
}
