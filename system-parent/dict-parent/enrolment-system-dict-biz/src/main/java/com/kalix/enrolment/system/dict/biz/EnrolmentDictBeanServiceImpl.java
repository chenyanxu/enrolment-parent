package com.kalix.enrolment.system.dict.biz;

import com.kalix.enrolment.system.dict.api.biz.IEnrolmentDictBeanService;
import com.kalix.enrolment.system.dict.api.dao.IEnrolmentDictBeanDao;
import com.kalix.enrolment.system.dict.entities.EnrolmentDictBean;
import com.kalix.framework.core.impl.system.BaseDictServiceImpl;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public EnrolmentDictBean getDictBeanByTypeAndValue(String type, String value) {
        EnrolmentDictBean enrolmentDictBean = new EnrolmentDictBean();
        String tbName = dao.getTableName();
        String sql = "select * from %s where type='%s' and value='%s'";
        if (tbName != null) {
            sql = String.format(sql, tbName, type, value);
            List list = dao.findByNativeSql(sql, EnrolmentDictBean.class);
            if (list.size() == 1) {
                enrolmentDictBean = (EnrolmentDictBean) list.get(0);
            }
        }
        return enrolmentDictBean;
    }

    @Override
    public List<EnrolmentDictBean> getDictBeanByType(String type) {
        List<EnrolmentDictBean> list = new ArrayList<EnrolmentDictBean>();
        String tbName = dao.getTableName();
        String sql = "select * from %s where type='%s'";
        if (tbName != null) {
            sql = String.format(sql, tbName, type);
            list = dao.findByNativeSql(sql, EnrolmentDictBean.class);
        }
        return list;
    }
}
