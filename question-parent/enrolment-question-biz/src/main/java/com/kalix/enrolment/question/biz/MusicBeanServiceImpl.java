package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.IMusicBeanService;
import com.kalix.enrolment.question.api.biz.IQuestionAuditService;
import com.kalix.enrolment.question.api.biz.ITestPaperService;
import com.kalix.enrolment.question.api.dao.IMusicBeanDao;
import com.kalix.enrolment.question.api.model.QuestionType;
import com.kalix.enrolment.question.entities.MusicBean;
import com.kalix.framework.core.api.biz.IDownloadService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zangyanming at 2018-09-13
 */
public class MusicBeanServiceImpl extends QuestionGenericBizServiceImpl<IMusicBeanDao, MusicBean>
        implements IMusicBeanService, IDownloadService {

    private static String QUESTION_BEAN_NAME = "Music";
    private static String AUDIT_ROLE_NAME = "音乐基础审核人";
    private static String TEMP_NAME = "";

    @Override
    public String getQuestionBeanName() {
        return QUESTION_BEAN_NAME;
    }

    @Override
    public String getAuditRoleName(String subType) {
        return AUDIT_ROLE_NAME;
    }

    @Override
    public String[] createDownloadFile(Long entityId, String fileType) {

        MusicBean musicBean = this.getEntity(entityId);

        Map dataMap = new HashMap();
        Map tempMap = new HashMap();
        dataMap.put("stem", musicBean.getStem());

        tempMap = new HashMap<>();
        tempMap.put("title", "音乐基础");
        tempMap.put("question", dataMap);
        String[] str = new String[2];
        str[0] = "123";
        str[1] = this.createSinglePreview(tempMap, "");
        return str;
    }

    @Override
    public String getTempName(String subType) {
        return TEMP_NAME;
    }

    @Override
    public Map<String, Object> createSingleTestPaper(Map paperMap) {
        return null;
    }
}
