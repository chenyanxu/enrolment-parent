package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.IPaperQuesBeanService;
import com.kalix.enrolment.question.api.biz.ISubjectBeanService;
import com.kalix.enrolment.question.api.dao.ISubjectBeanDao;
import com.kalix.enrolment.question.entities.SubjectBean;
import com.kalix.enrolment.system.dict.api.biz.IEnrolmentDictBeanService;
import com.kalix.enrolment.system.dict.entities.EnrolmentDictBean;
import com.kalix.framework.core.api.biz.IDownloadService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zangyanming at 2018-09-13
 */
public class SubjectBeanServiceImpl extends QuestionGenericBizServiceImpl<ISubjectBeanDao, SubjectBean>
        implements ISubjectBeanService, IDownloadService {

    private static String TEMP_NAME = "subject.ftl";
    private static String DICT_TYPE = "主观题类型";
    private IEnrolmentDictBeanService enrolmentDictBeanService;
    private IPaperQuesBeanService paperQuesBeanService;

    @Override
    public String getAuditRoleName(String subType) {
        EnrolmentDictBean enrolmentDictBean = enrolmentDictBeanService.getDictBeanByTypeAndValue(DICT_TYPE, subType);
        String label = enrolmentDictBean.getLabel();
        String auditRoleName = label.trim() + "审核人";
        return auditRoleName;
    }

    @Override
    public String getTempName(String subType) {
        return TEMP_NAME;
    }

    @Override
    public Map<String, Object> createSingleTestPaper(Map paperMap) {
        return null;
    }

    @Override
    public String[] createDownloadFile(Long entityId, String fileType) {
        String[] str = new String[2];
        SubjectBean subjectBean = this.getEntity(entityId);
        Map dataMap = new HashMap();
        dataMap.put("stem", subjectBean.getStem());

        Map tempMap = new HashMap();
        // tempMap.put("title", "主观题");
        tempMap.put("question", dataMap);

        str[0] = "主观题";
        str[1] = this.createSinglePreview(tempMap, subjectBean.getSubType());
        return str;
    }

    public void setEnrolmentDictBeanService(IEnrolmentDictBeanService enrolmentDictBeanService) {
        this.enrolmentDictBeanService = enrolmentDictBeanService;
    }

    public void setPaperQuesBeanService(IPaperQuesBeanService paperQuesBeanService) {
        this.paperQuesBeanService = paperQuesBeanService;
    }
}
