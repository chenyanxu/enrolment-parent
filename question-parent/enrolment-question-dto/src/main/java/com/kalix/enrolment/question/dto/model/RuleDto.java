package com.kalix.enrolment.question.dto.model;

import com.kalix.framework.core.api.web.model.BaseDTO;

/**
 * 试卷组合试题规则实体
 *
 * @author: fwb
 * @CreateDate: 2018-10-22
 * @version: 1.0
 */

public class RuleDto extends BaseDTO {
    /**
     * 试卷id
     */
    private Long paperId;
    /**
     * 试题顺序号
     */
    private int titleNum;
    /**
     * 题型,字典[题型]
     */
    private String quesType;
    /**
     * 题型名称
     */
    private String quesTypeName;
    /**
     * 题型描述,题型对应beanName
     */
    private String quesTypeDesc;
    /**
     * 题型子类，字典[主观题类型、面试题类型等]
     */
    private String subType;
    /**
     * 题型每题分数（每空分数）
     */
    private Long quesScore;
    /**
     * 题型总分
     */
    private Long quesTotalscore;
    /**
     * 题型描述（说明）
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

    public String getQuesTypeName() {
        return quesTypeName;
    }

    public void setQuesTypeName(String quesTypeName) {
        this.quesTypeName = quesTypeName;
    }

    public String getQuesTypeDesc() {
        return quesTypeDesc;
    }

    public void setQuesTypeDesc(String quesTypeDesc) {
        this.quesTypeDesc = quesTypeDesc;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }
}
