package com.kalix.enrolment.question.dto.model;

import com.kalix.framework.core.api.web.model.BaseDTO;

/**
 * �Ծ�����������ʵ��
 *
 * @author: fwb
 * @CreateDate: 2018-10-22
 * @version: 1.0
 */

public class RuleDto extends BaseDTO {
    /**
     * �Ծ�id
     */
    private Long paperId;
    /**
     * ����˳���
     */
    private int titleNum;
    /**
     * ����,�ֵ�[����]
     */
    private String quesType;
    /**
     * ��������
     */
    private String quesTypeName;
    /**
     * ��������,���Ͷ�ӦbeanName
     */
    private String quesTypeDesc;
    /**
     * �������࣬�ֵ�[���������͡����������͵�]
     */
    private String subType;
    /**
     * ����ÿ�������ÿ�շ�����
     */
    private Long quesScore;
    /**
     * �����ܷ�
     */
    private Long quesTotalscore;
    /**
     * ����������˵����
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
