package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.ICompletionBeanService;
import com.kalix.enrolment.question.api.dao.ICompletionBeanDao;
import com.kalix.enrolment.question.entities.CompletionBean;
import com.kalix.framework.extend.impl.biz.LogicDeleteGenericBizServiceImpl;
import org.xm.Similarity;

/**
 * Created by Administrator_ on 2018/9/6.
 */
public class CompletionBeanServiceImpl extends LogicDeleteGenericBizServiceImpl<ICompletionBeanDao, CompletionBean> implements ICompletionBeanService {

    @Override
    public void aaa() {
        //double result = Similarity.cilinSimilarity("教师", "教授");
        double result = 123;
        System.out.println(result);
    }

    public static void main(String[] args) {
        double result = Similarity.cilinSimilarity("教师", "教授");
        System.out.println(result);
    }
}
