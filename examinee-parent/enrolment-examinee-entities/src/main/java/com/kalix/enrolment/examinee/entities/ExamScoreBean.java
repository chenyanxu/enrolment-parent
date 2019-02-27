package com.kalix.enrolment.examinee.entities;

import com.kalix.framework.extend.api.entities.BaseLogicDeleteEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

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
    private String barCode;          // 条形码
    private Double artScore = 0.0;   // 文艺常识、摄影作品赏析、面试单项分
    private Double storyScore = 0.0; // 故事编写、摄影主题创作阐释、笔试单项分
    private Double totalScore = 0.0; // 总分
    private String remark = "0";     // 备注，字典[成绩备注]

    @Transient
    private String examNumber; // 考号
    @Transient
    private String examName;   // 考生姓名
    @Transient
    private String major;      // 专业
    @Transient
    private String majorName;  // 专业名称
    @Transient
    private String province;   // 省份
    @Transient
    private Double finalScore = 0.0; // 最终成绩

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Double getArtScore() {
        return artScore;
    }

    public void setArtScore(Double artScore) {
        this.artScore = artScore;
    }

    public Double getStoryScore() {
        return storyScore;
    }

    public void setStoryScore(Double storyScore) {
        this.storyScore = storyScore;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getExamNumber() {
        return examNumber;
    }

    public void setExamNumber(String examNumber) {
        this.examNumber = examNumber;
    }

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

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Double getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(Double finalScore) {
        this.finalScore = finalScore;
    }
}
