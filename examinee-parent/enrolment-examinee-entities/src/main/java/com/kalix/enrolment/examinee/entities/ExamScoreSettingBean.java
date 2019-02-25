package com.kalix.enrolment.examinee.entities;

import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 考试分数功能参数设置实体类
 * Created by hqj on 2019/2/25.
 */
@Entity
@Table(name = "enrolment_examinee_score_setting")
public class ExamScoreSettingBean extends PersistentEntity {
    private String major;    // 专业，字典[考生专业]
    private String province; // 省份
    private Double coefficient = 1.0; // 分数转换系数

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }
}
