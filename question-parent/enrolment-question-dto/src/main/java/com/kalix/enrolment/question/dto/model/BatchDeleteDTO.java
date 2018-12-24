package com.kalix.enrolment.question.dto.model;

import java.io.Serializable;

/**
 * hqj: 2018-12-24
 * 批量删除操作对象模型
 *
 */
public class BatchDeleteDTO implements Serializable {
    String ids;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}
