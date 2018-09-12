package com.kalix.enrolment.system.dict.entities;

import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "enrolment_dict")
@Inheritance(strategy = InheritanceType.JOINED)
public class EnrolmentDictBean extends PersistentEntity {
    private String label;    // 标签名
    private String value;    // 数据值
    private String type;    // 类型
    private String description;// 描述

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
