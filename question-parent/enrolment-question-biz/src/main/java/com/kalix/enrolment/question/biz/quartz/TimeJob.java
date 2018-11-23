package com.kalix.enrolment.question.biz.quartz;

import com.kalix.enrolment.question.api.biz.IQuestionCommonBizService;
import com.kalix.enrolment.question.api.biz.IQuestionSettingBeanService;
import com.kalix.enrolment.question.entities.QuestionSettingBean;
import com.kalix.framework.core.util.JNDIHelper;
import org.apache.camel.Handler;

import java.io.IOException;
import java.util.Date;

/**
 * Created by hqj on 2018/11/21.
 */

public class TimeJob {

    private IQuestionCommonBizService questionCommonBizService;

    /**
     * 排重初始化比对数据
     */
    @Handler
    public void initData() {
        try {
            questionCommonBizService = JNDIHelper.getJNDIServiceForName(IQuestionCommonBizService.class.getName());
            questionCommonBizService.compareAllSimilarity();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // @Handler
    public void test() {
        System.out.println("=====start" );
        System.out.println(new Date());
        System.out.println("hello test!");
        System.out.println(new Date());
        System.out.println("=====end");
    }
}
