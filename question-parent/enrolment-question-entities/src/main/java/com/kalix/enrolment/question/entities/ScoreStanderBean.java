package com.kalix.enrolment.question.entities;

import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "enrolment_question_scorestandar")
public class ScoreStanderBean extends PersistentEntity {

    private Long quesId; // 试题Id
    private String standerItem; // 标准项
    private Integer itemScore;  // 每项打分
    private String propositionTeacher;  // 命题教师
    private String quesType; // 题类型
    private String subType; // 题子类型

    public Long getQuesId() {
        return quesId;
    }

    public void setQuesId(Long quesId) {
        this.quesId = quesId;
    }

    public String getStanderItem() {
        return standerItem;
    }

    public void setStanderItem(String standerItem) {
        this.standerItem = standerItem;
    }

    public Integer getItemScore() {
        return itemScore;
    }

    public void setItemScore(Integer itemScore) {
        this.itemScore = itemScore;
    }

    public String getPropositionTeacher() {
        return propositionTeacher;
    }

    public void setPropositionTeacher(String propositionTeacher) {
        this.propositionTeacher = propositionTeacher;
    }

    public String getQuesType() {
        return quesType;
    }

    public void setQuesType(String quesType) {
        this.quesType = quesType;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }
}
