package com.kalix.enrolment.system.dict.dao;

import com.kalix.enrolment.system.dict.api.dao.IEnrolmentDictBeanDao;
import com.kalix.enrolment.system.dict.entities.EnrolmentDictBean;
import com.kalix.framework.core.impl.dao.GenericDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EnrolmentDictBeanDaoImpl extends GenericDao<EnrolmentDictBean, Long> implements IEnrolmentDictBeanDao {
    @Override
    @PersistenceContext(unitName = "enrolment-system-dict-unit")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
