package com.kalix.enrolment.examinee.entities;

import com.kalix.framework.extend.api.entities.BaseLogicDeleteEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 试卷组合试题规则实体
 *
 * @author: fwb
 * @CreateDate: 2018-10-22
 * @version: 1.0
 */
@Entity
@Table(name = "enrolment_examinee_score")
public class ExamScoreBean extends BaseLogicDeleteEntity {
    private String examNumber; //考号
    private String examName; //考生姓名
    private String major; //专业
    private String artScore;  //文艺常识、摄影作品赏析、面试单项分
    private String  barCode; // 条形码
    private String  storyScore; // 故事编写、摄影主题创作阐释、笔试单项分
    private String  totalScore; // 总分


    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getArtScore() {
        return artScore;
    }

    public void setArtScore(String artScore) {
        this.artScore = artScore;
    }

    public String getStoryScore() {
        return storyScore;
    }

    public void setStoryScore(String storyScore) {
        this.storyScore = storyScore;
    }

    public String getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(String totalScore) {
        this.totalScore = totalScore;
    }

    public String getExamNumber() {
        return examNumber;
    }

    public void setExamNumber(String examNumber) {
        this.examNumber = examNumber;
    }


    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }
}
