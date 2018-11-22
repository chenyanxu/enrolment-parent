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

    private IQuestionSettingBeanService questionSettingBeanService;
    private IQuestionCommonBizService questionCommonBizService;

    /**
     * 排重初始化比对数据
     */
    @Handler
    public void initData() {
        try {
            System.out.println("=====start" );
            System.out.println(new Date());
            questionSettingBeanService = JNDIHelper.getJNDIServiceForName(IQuestionSettingBeanService.class.getName());
            QuestionSettingBean questionSettingBean = questionSettingBeanService.getEntity(1L);
            if (questionSettingBean.getRepeated()) {
                System.out.println("排重初始化比对数据进行中,请等待!");
                System.out.println(new Date());
                System.out.println("=====end");
                return;
            }
            questionCommonBizService = JNDIHelper.getJNDIServiceForName(IQuestionCommonBizService.class.getName());
            questionSettingBeanService.updateRepeated(questionSettingBean.getId(), true);
            questionCommonBizService.initAllRepeated();
            System.out.println("排重初始化比对数据完成");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(new Date());
        System.out.println("=====end");
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
