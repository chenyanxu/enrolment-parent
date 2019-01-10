package com.kalix.enrolment.examinee.dao;

import com.kalix.framework.core.api.persistence.PersistentEntity;
import com.kalix.framework.core.impl.dao.GenericDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * Created by sunlf on 2015/10/26.
 */
public abstract class BaseBeanDao<T extends PersistentEntity, PK extends Serializable> extends GenericDao<T, PK> {

    @Override
    @PersistenceContext(unitName = "enrolment-examinee-unit")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
