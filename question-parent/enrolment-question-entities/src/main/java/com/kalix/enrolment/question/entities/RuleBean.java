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
 * ������Bean
 *
 * @author: fwb
 * @CreateDate: 2018-10-22
 * @version: 1.0
 */
@Entity
@Table(name = "enrolment_question_rule")
public class RuleBean extends BaseLogicDeleteEntity {

    /**
     * �����Ӧ�Ŀ���id
     */
    private Long paperId;
    /**
     * ����˳��
     */
    private int  titleNum;

    /**
     * ����
     */
    private String quesType;
    /**
     * ÿ�����
     */
    private Long quesScore;
    /**
     * �����ܷ�
     */
    private Long quesTotalscore;
    /**
     * ��������
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
