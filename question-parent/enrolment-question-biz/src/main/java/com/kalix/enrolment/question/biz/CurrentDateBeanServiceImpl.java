package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.*;
import com.kalix.enrolment.question.biz.util.CurrentDate;

/**
 * Created by zangyanming at 2018-09-13
 */
public class CurrentDateBeanServiceImpl implements ICurrentDateBeanService {

    @Override
    public String getNowDate(){
        CurrentDate date = new CurrentDate();
        return date.getNowDate();
    }
}
