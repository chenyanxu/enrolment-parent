package com.kalix.enrolment.admissions.biz;

import com.kalix.admin.core.api.biz.IOrganizationBeanService;
import com.kalix.enrolment.admissions.api.biz.IEnrolmentAdmissionsBeanService;
import com.kalix.enrolment.admissions.api.dao.IEnrolmentAdmissionsBeanDao;
import com.kalix.enrolment.admissions.entities.EnrolmentAdmissionsBean;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.api.web.model.QueryDTO;
import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;
import com.kalix.framework.core.util.Assert;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by hqj on 2017-3-7.
 */
public class EnrolmentAdmissionsBeanServiceImpl extends ShiroGenericBizServiceImpl<IEnrolmentAdmissionsBeanDao, EnrolmentAdmissionsBean> implements IEnrolmentAdmissionsBeanService {

}
