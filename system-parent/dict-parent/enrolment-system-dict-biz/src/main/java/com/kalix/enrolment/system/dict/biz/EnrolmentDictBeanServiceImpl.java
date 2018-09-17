package com.kalix.enrolment.system.dict.biz;

import com.kalix.enrolment.system.dict.api.biz.IEnrolmentDictBeanService;
import com.kalix.enrolment.system.dict.api.dao.IEnrolmentDictBeanDao;
import com.kalix.enrolment.system.dict.entities.EnrolmentDictBean;
import com.kalix.framework.core.impl.system.BaseDictServiceImpl;

public class EnrolmentDictBeanServiceImpl extends BaseDictServiceImpl<IEnrolmentDictBeanDao, EnrolmentDictBean> implements IEnrolmentDictBeanService {
//    @Override
//    public JsonStatus saveEntity(EnrolmentDictBean entity) {
//        Integer maxValue = dao.getFieldMaxValue("value", "type='" + entity.getType() + "'");
//
//        maxValue = maxValue + 1;
//
//        entity.setValue(maxValue);
//
//        return super.saveEntity(entity);
//    }
}
