package com.kalix.enrolment.question.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kalix.framework.core.api.persistence.PersistentEntity;
import org.apache.openjpa.persistence.jdbc.Index;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import java.util.Date;

/**
 * Created by hqj on 2018/11/20.
 */
@Entity
@Table(name = "enrolment_question_repeated")
public class QuestionRepeatedBean extends PersistentEntity {
    private String questionType;     // 题型
    private String questionTypeName; // 题型名称
    private String questionBeans;    // 题型beans
    private String subType;          // 题型子类
    private String subTypeName;      // 题型子类名称
    @Index(name = "index_first_question_id", columnNames = "firstQuestionId")
    private Long firstQuestionId;    // 试题1id
    @Index(name = "index_second_question_id", columnNames = "secondQuestionId")
    private Long secondQuestionId;   // 试题2id
    @Index(name = "index_similarity", columnNames = "similarity")
    private Double similarity;       // 试题相似度
    private String similarityDesc;   // 试题相似度描述

    @Transient
    private String firstStem;  // 试题1题干
    private String secondStem; // 试题2题干

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

    public Long getFirstQuestionId() {
        return firstQuestionId;
    }

    public void setFirstQuestionId(Long firstQuestionId) {
        this.firstQuestionId = firstQuestionId;
    }

    public Long getSecondQuestionId() {
        return secondQuestionId;
    }

    public void setSecondQuestionId(Long secondQuestionId) {
        this.secondQuestionId = secondQuestionId;
    }

    public Double getSimilarity() {
        return similarity;
    }

    public void setSimilarity(Double similarity) {
        this.similarity = similarity;
    }

    public String getSimilarityDesc() {
        return similarityDesc;
    }

    public void setSimilarityDesc(String similarityDesc) {
        this.similarityDesc = similarityDesc;
    }

    public String getFirstStem() {
        return firstStem;
    }

    public void setFirstStem(String firstStem) {
        this.firstStem = firstStem;
    }

    public String getSecondStem() {
        return secondStem;
    }

    public void setSecondStem(String secondStem) {
        this.secondStem = secondStem;
    }
}
