package com.kalix.enrolment.question.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kalix.framework.extend.api.entities.BaseLogicDeleteEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * 组卷规则Bean
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
    /**
     * title
     */
    private String title;

    /**
     * 试卷总分
     */
    private int totalMark;
    /**
     * 自动成卷份数
     */
    private Long copies;


    public Long getCopies() {
        return copies;
    }

    public void setCopies(Long copies) {
        this.copies = copies;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
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
