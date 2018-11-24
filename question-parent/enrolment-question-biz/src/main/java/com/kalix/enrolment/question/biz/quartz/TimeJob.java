package com.kalix.enrolment.question.biz.quartz;

import com.kalix.enrolment.question.api.biz.IQuestionSettingBeanService;
import com.kalix.enrolment.question.api.biz.IRepeatedService;
import com.kalix.enrolment.question.entities.QuestionSettingBean;
import com.kalix.enrolment.system.dict.api.biz.IEnrolmentDictBeanService;
import com.kalix.enrolment.system.dict.entities.EnrolmentDictBean;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.util.JNDIHelper;
import org.apache.camel.Handler;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hqj on 2018/11/21.
 */

public class TimeJob {

    private IQuestionSettingBeanService questionSettingBeanService;
    private IRepeatedService repeatedService;
    private IEnrolmentDictBeanService enrolmentDictBeanService;

    /**
     * 排重初始化比对数据
     */
    @Handler
    public void compareCompletionSimilarity() {
        try {
            questionSettingBeanService = JNDIHelper.getJNDIServiceForName(IQuestionSettingBeanService.class.getName());
            QuestionSettingBean questionSettingBean = questionSettingBeanService.getEntity(1L);
            // 判断题库排重是否进行自动比对状态.true开启自动比对
            if (questionSettingBean.getRepeated()) {
                Map<String, String> map = new HashMap<String, String>();
                String beanName = "Completion";
                map.put("beanName", beanName);
                repeatedService = JNDIHelper.getJNDIServiceForName(IRepeatedService.class.getName(), map);
                JsonStatus jsonStatus = repeatedService.compareAllSimilarity("");
                if (!jsonStatus.getSuccess()) {
                    System.out.println(jsonStatus.getMsg());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 排重初始化比对数据
     */
    @Handler
    public void compareChoiceSimilarity() {
        try {
            questionSettingBeanService = JNDIHelper.getJNDIServiceForName(IQuestionSettingBeanService.class.getName());
            QuestionSettingBean questionSettingBean = questionSettingBeanService.getEntity(1L);
            // 判断题库排重是否进行自动比对状态.true开启自动比对
            if (questionSettingBean.getRepeated()) {
                Map<String, String> map = new HashMap<String, String>();
                String beanName = "Choice";
                map.put("beanName", beanName);
                repeatedService = JNDIHelper.getJNDIServiceForName(IRepeatedService.class.getName(), map);
                JsonStatus jsonStatus = repeatedService.compareAllSimilarity("");
                if (!jsonStatus.getSuccess()) {
                    System.out.println(jsonStatus.getMsg());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 排重初始化比对数据
     */
    @Handler
    public void compareVerseSimilarity() {
        try {
            questionSettingBeanService = JNDIHelper.getJNDIServiceForName(IQuestionSettingBeanService.class.getName());
            QuestionSettingBean questionSettingBean = questionSettingBeanService.getEntity(1L);
            // 判断题库排重是否进行自动比对状态.true开启自动比对
            if (questionSettingBean.getRepeated()) {
                Map<String, String> map = new HashMap<String, String>();
                String beanName = "Verse";
                map.put("beanName", beanName);
                repeatedService = JNDIHelper.getJNDIServiceForName(IRepeatedService.class.getName(), map);
                JsonStatus jsonStatus = repeatedService.compareAllSimilarity("");
                if (!jsonStatus.getSuccess()) {
                    System.out.println(jsonStatus.getMsg());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 排重初始化比对数据
     */
    @Handler
    public void compareSubjectSimilarity() {
        try {
            questionSettingBeanService = JNDIHelper.getJNDIServiceForName(IQuestionSettingBeanService.class.getName());
            QuestionSettingBean questionSettingBean = questionSettingBeanService.getEntity(1L);
            // 判断题库排重是否进行自动比对状态.true开启自动比对
            if (questionSettingBean.getRepeated()) {
                Map<String, String> map = new HashMap<String, String>();
                String beanName = "Subject";
                map.put("beanName", beanName);
                repeatedService = JNDIHelper.getJNDIServiceForName(IRepeatedService.class.getName(), map);
                enrolmentDictBeanService = JNDIHelper.getJNDIServiceForName(IEnrolmentDictBeanService.class.getName());
                List<EnrolmentDictBean> subDictBeans = enrolmentDictBeanService.getDictBeanByType("主观题类型");
                for (int j = 0; j < subDictBeans.size(); j++) {
                    EnrolmentDictBean subDictBean = subDictBeans.get(j);
                    String subType = subDictBean.getValue();
                    JsonStatus jsonStatus = repeatedService.compareAllSimilarity(subType);
                    if (!jsonStatus.getSuccess()) {
                        System.out.println(jsonStatus.getMsg());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 排重初始化比对数据
     */
    @Handler
    public void compareInterviewSimilarity() {
        try {
            questionSettingBeanService = JNDIHelper.getJNDIServiceForName(IQuestionSettingBeanService.class.getName());
            QuestionSettingBean questionSettingBean = questionSettingBeanService.getEntity(1L);
            // 判断题库排重是否进行自动比对状态.true开启自动比对
            if (questionSettingBean.getRepeated()) {
                Map<String, String> map = new HashMap<String, String>();
                String beanName = "InterviewIssue";
                map.put("beanName", beanName);
                repeatedService = JNDIHelper.getJNDIServiceForName(IRepeatedService.class.getName(), map);
                enrolmentDictBeanService = JNDIHelper.getJNDIServiceForName(IEnrolmentDictBeanService.class.getName());
                List<EnrolmentDictBean> subDictBeans = enrolmentDictBeanService.getDictBeanByType("面试题类型");
                for (int j = 0; j < subDictBeans.size(); j++) {
                    EnrolmentDictBean subDictBean = subDictBeans.get(j);
                    String subType = subDictBean.getValue();
                    JsonStatus jsonStatus = repeatedService.compareAllSimilarity(subType);
                    if (!jsonStatus.getSuccess()) {
                        System.out.println(jsonStatus.getMsg());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // @Handler
    public void test() {
        System.out.println("=====start");
        System.out.println(new Date());
        System.out.println("hello test!");
        System.out.println(new Date());
        System.out.println("=====end");
    }
}
