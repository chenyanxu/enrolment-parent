package com.kalix.enrolment.question.entities;

import com.kalix.framework.extend.api.entities.BaseLogicDeleteEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 组卷规则Bean
 *
 * @author: fwb
 * @CreateDate: 2018-10-22
 * @version: 1.0
 */
@Entity
@Table(name = "enrolment_question_rule")
public class RuleBean extends BaseLogicDeleteEntity {

    /**
     * 规则对应的考试id
     */
    private Long paperId;
    /**
     * 题型顺序
     */
    private int  titleNum;

    /**
     * 题型
     */
    private String quesType;
    /**
     * 每题分数
     */
    private Long quesScore;
    /**
     * 题型总分
     */
    private Long quesTotalscore;
    /**
     * 题型描述
     */
    private Long quesDesc;

    public int getTitleNum() {
        return titleNum;
    }

    public void setTitleNum(int titleNum) {
        this.titleNum = titleNum;
    }



    public String getQuesType() {
        return quesType;
    }

    public void setQuesType(String quesType) {
        this.quesType = quesType;
    }

    public Long getQuesScore() {
        return quesScore;
    }

    public void setQuesScore(Long quesScore) {
        this.quesScore = quesScore;
    }

    public Long getQuesTotalscore() {
        return quesTotalscore;
    }

    public void setQuesTotalscore(Long quesTotalscore) {
        this.quesTotalscore = quesTotalscore;
    }

    public Long getPaperId() {
        return paperId;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }

    public Long getQuesDesc() {
        return quesDesc;
    }

    public void setQuesDesc(Long quesDesc) {
        this.quesDesc = quesDesc;
    }
}
