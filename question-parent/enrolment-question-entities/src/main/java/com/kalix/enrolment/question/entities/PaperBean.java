package com.kalix.enrolment.question.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kalix.framework.extend.api.entities.BaseLogicDeleteEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * 试卷配置参数实体
 *
 * @author: fwb
 * @CreateDate: 2018-10-22
 * @version: 1.0
 */
@Entity
@Table(name = "enrolment_question_paper")
public class PaperBean extends BaseLogicDeleteEntity {
    /**
     * 年份
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy", timezone = "GMT+8")
    private Date year;
    // 学期
    private String term;
    /**
     * 标题
     */
    private String title;

    /**
     * 总分
     */
    private int totalMark;
    /**
     * 自动成卷份数
     */
    private int copies;

    private String kskm; //考试科目

    private String tempName; //模板名称


    public String getTempName() {
        return tempName;
    }

    public void setTempName(String tempName) {
        this.tempName = tempName;
    }

    public String getKskm() {
        return kskm;
    }

    public void setKskm(String kskm) {
        this.kskm = kskm;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }
}
