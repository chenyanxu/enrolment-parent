package com.kalix.enrolment.question.dto.model;

import com.kalix.framework.core.api.web.model.BaseDTO;

import java.util.List;

/**
 * Created by Administrator_ on 2018/9/17.
 */
public class RepeatedCountDTO extends BaseDTO {

    private String name; // 名称
    private List repeateList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getRepeateList() {
        return repeateList;
    }

    public void setRepeateList(List repeateList) {
        this.repeateList = repeateList;
    }
}
