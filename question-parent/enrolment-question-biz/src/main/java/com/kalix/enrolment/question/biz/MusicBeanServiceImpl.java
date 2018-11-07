package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.IMusicBeanService;
import com.kalix.enrolment.question.api.biz.IPaperQuesBeanService;
import com.kalix.enrolment.question.api.dao.IMusicBeanDao;
import com.kalix.enrolment.question.entities.MusicBean;
import com.kalix.enrolment.system.dict.entities.EnrolmentDictBean;
import com.kalix.framework.core.api.biz.IDownloadService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zangyanming at 2018-09-13
 */
public class MusicBeanServiceImpl extends QuestionGenericBizServiceImpl<IMusicBeanDao, MusicBean>
        implements IMusicBeanService, IDownloadService {

    private static String TEMP_NAME = "";
    private static String DICT_QUESTIONVALUE = "4";
    private IPaperQuesBeanService paperQuesBeanService;

    @Override
    public String getAuditRoleName(String subType) {
        EnrolmentDictBean enrolmentDictBean = enrolmentDictBeanService.getDictBeanByTypeAndValue(DICT_QUESTIONTYPE, DICT_QUESTIONVALUE);
        String label = enrolmentDictBean.getLabel();
        String auditRoleName = label + "审核人";
        return auditRoleName;
    }

    @Override
    public String getTempName(String subType) {
        return TEMP_NAME;
    }

    @Override
    public String getSubTypeName(String subType) {
        return "";
    }

    @Override
    public Map<String, Object> createSingleTestPaper(Map paperMap) {
        return null;
    }

    @Override
    public String[] createDownloadFile(Long entityId, String fileType) {
        String[] str = new String[2];
        MusicBean musicBean = this.getEntity(entityId);
        Map dataMap = new HashMap();
        dataMap.put("stem", musicBean.getStem());

        Map tempMap = new HashMap();
        // tempMap.put("title", "音乐基础");
        tempMap.put("question", dataMap);

        str[0] = "音乐基础";
        str[1] = this.createSinglePreview(tempMap, "");
        return str;
    }

    public void setPaperQuesBeanService(IPaperQuesBeanService paperQuesBeanService) {
        this.paperQuesBeanService = paperQuesBeanService;
    }
}
