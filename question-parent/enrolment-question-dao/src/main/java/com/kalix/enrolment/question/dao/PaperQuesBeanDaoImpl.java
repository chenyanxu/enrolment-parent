package com.kalix.enrolment.question.dao;

import com.kalix.enrolment.question.api.dao.IPaperQuesBeanDao;
import com.kalix.enrolment.question.dto.model.RuleDto;
import com.kalix.enrolment.question.entities.PaperQuesBean;

import java.util.List;

public class PaperQuesBeanDaoImpl extends BaseBeanDao<PaperQuesBean, Long> implements IPaperQuesBeanDao {

    @Override
    public void deleteByUuid(String uuid) {
        String sql = "delete  from " + super.getTableName() + " where uuid ='"+uuid+"' " ;
        this.updateNativeQuery(sql);
    }


    @Override
    public List findByPaperId(Long paperId)  {
        String sql = "select *  from " + super.getTableName() + " where paperid =?1 " ;
        return this.findByNativeSql(sql, PaperQuesBean.class, paperId);
    }

    @Override
    public List findByPaperId(Long paperId,String uuid)  {
        String sql = "select *  from " + super.getTableName() + "  where  paperid =?1 and uuid=?2 " ;
        return this.findByNativeSql(sql, PaperQuesBean.class, paperId,uuid);
    }
}
