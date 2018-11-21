package com.kalix.enrolment.question.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * 题库功能参数设置实体类
 * Created by zangyanming on 2018/9/13.
 */
@Entity
@Table(name = "enrolment_question_setting")
public class QuestionSettingBean extends PersistentEntity {
    private Boolean available = false;     // 题库功能是否开启
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date questionStartTime;        // 题库功能开启时间
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date questionCloseTime;        // 题库功能关闭时间
    private Double similarity = 0.5;       // 题库去重相似度参数
    private Double cilinSimilarity = 0.5;  // 题库去重词林相似度参数
    private Double morphoSimilarity = 0.5; // 题库去重词形词序句子相似度参数
    private Double phraseSimilarity = 0.5; // 题库去重短语相似度参数
    private Boolean repeated = false;      // 题库排重状态

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Date getQuestionStartTime() {
        return questionStartTime;
    }

    public void setQuestionStartTime(Date questionStartTime) {
        this.questionStartTime = questionStartTime;
    }

    public Date getQuestionCloseTime() {
        return questionCloseTime;
    }

    public void setQuestionCloseTime(Date questionCloseTime) {
        this.questionCloseTime = questionCloseTime;
    }

    public Double getSimilarity() {
        return similarity;
    }

    public void setSimilarity(Double similarity) {
        this.similarity = similarity;
    }

    public Double getCilinSimilarity() {
        return cilinSimilarity;
    }

    public void setCilinSimilarity(Double cilinSimilarity) {
        this.cilinSimilarity = cilinSimilarity;
    }

    public Double getPhraseSimilarity() {
        return phraseSimilarity;
    }

    public void setPhraseSimilarity(Double phraseSimilarity) {
        this.phraseSimilarity = phraseSimilarity;
    }

    public Double getMorphoSimilarity() {
        return morphoSimilarity;
    }

    public void setMorphoSimilarity(Double morphoSimilarity) {
        this.morphoSimilarity = morphoSimilarity;
    }

    public Boolean getRepeated() {
        return repeated;
    }

    public void setRepeated(Boolean repeated) {
        this.repeated = repeated;
    }
}
