package com.kalix.enrolment.question.dto.model;

import com.kalix.framework.core.api.web.model.BaseDTO;

/**
 *
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
     *试题数量
     */
    private String titleNum;
    /**
     * 试题类型
     */
    private String quesType;
    /**
     * 类型名称
     */
    private String quesTypeName;
    /**
     * 类型描述
     */
    private String quesTypeDesc;
    /**
     * 子类
     */
    private String subType;
    /**
     * 每题分数
     */
    private Long quesScore;
    /**
     * 总分
     */
    private Long quesTotalscore;
    /**
     * 问题描述
     */
    private String quesDesc;

    private String typeCount;

    public String getTypeCount() {
        return typeCount;
    }

    public void setTypeCount(String typeCount) {
        this.typeCount = typeCount;
    }

    public String getTitleNum() {
        return titleNum;
    }

    public void setTitleNum(String titleNum) {
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

    public String getQuesDesc() {
        return quesDesc;
    }

    public void setQuesDesc(String quesDesc) {
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
