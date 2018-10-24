package com.kalix.enrolment.question.entities;

import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 题库功能参数设置实体类
 * Created by zangyanming on 2018/9/13.
 */
@Entity
@Table(name = "enrolment_question_setting")
public class QuestionSettingBean extends PersistentEntity {
    private Boolean available = false; // 题库功能是否开启

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
