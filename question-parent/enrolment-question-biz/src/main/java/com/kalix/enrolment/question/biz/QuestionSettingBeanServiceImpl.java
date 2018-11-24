package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.IQuestionSettingBeanService;
import com.kalix.enrolment.question.api.dao.IQuestionSettingBeanDao;
import com.kalix.enrolment.question.entities.QuestionSettingBean;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;

import javax.transaction.Transactional;

/**
 * Created by hqj on 2018-10-25.
 */
public class QuestionSettingBeanServiceImpl
        extends ShiroGenericBizServiceImpl<IQuestionSettingBeanDao, QuestionSettingBean>
        implements IQuestionSettingBeanService {

    /*@Override
    @Transactional
    public int updateRepeated(Long id, Boolean repeated) {
        String sql = "update " + this.dao.getTableName() + " set repeated = " + repeated + " where id = " + id;
        return this.dao.updateNativeQuery(sql);
    }*/

    @Override
    @Transactional
    public int updateCompareCompletion(Long id, Boolean compareStatus) {
        String sql = "update " + this.dao.getTableName() + " set compareCompletion = " + compareStatus + " where id = " + id;
        return this.dao.updateNativeQuery(sql);
    }

    @Override
    @Transactional
    public int updateCompareChoice(Long id, Boolean compareStatus) {
        String sql = "update " + this.dao.getTableName() + " set compareChoice = " + compareStatus + " where id = " + id;
        return this.dao.updateNativeQuery(sql);
    }

    @Override
    @Transactional
    public int updateCompareVerse(Long id, Boolean compareStatus) {
        String sql = "update " + this.dao.getTableName() + " set compareVerse = " + compareStatus + " where id = " + id;
        return this.dao.updateNativeQuery(sql);
    }

    @Override
    @Transactional
    public int updateCompareMusic(Long id, Boolean compareStatus) {
        String sql = "update " + this.dao.getTableName() + " set compareMusic = " + compareStatus + " where id = " + id;
        return this.dao.updateNativeQuery(sql);
    }

    @Override
    @Transactional
    public int updateCompareSubject(Long id, Boolean compareStatus) {
        String sql = "update " + this.dao.getTableName() + " set compareSubject = " + compareStatus + " where id = " + id;
        return this.dao.updateNativeQuery(sql);
    }

    @Override
    @Transactional
    public int updateCompareInterview(Long id, Boolean compareStatus) {
        String sql = "update " + this.dao.getTableName() + " set compareInterview = " + compareStatus + " where id = " + id;
        return this.dao.updateNativeQuery(sql);
    }
}
