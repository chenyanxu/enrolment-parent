package com.kalix.enrolment.admissions.dao;

import com.kalix.enrolment.admissions.api.dao.IEnrolmentAdmissionsBeanDao;
import com.kalix.enrolment.admissions.entities.EnrolmentAdmissionsBean;
import com.kalix.framework.core.impl.dao.GenericDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EnrolmentAdmissionsBeanDaoImpl extends BaseBeanDao<EnrolmentAdmissionsBean, Long> implements IEnrolmentAdmissionsBeanDao {

}
