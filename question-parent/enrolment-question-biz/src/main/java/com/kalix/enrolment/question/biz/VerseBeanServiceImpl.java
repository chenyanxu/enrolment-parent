package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.IFreemarkerService;
import com.kalix.enrolment.question.api.biz.IQuestionAuditService;
import com.kalix.enrolment.question.api.biz.IVerseBeanService;
import com.kalix.enrolment.question.api.dao.IVerseBeanDao;
import com.kalix.enrolment.question.api.model.QuestionType;
import com.kalix.enrolment.question.entities.VerseBean;
import com.kalix.framework.core.api.biz.IDownloadService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zangyanming at 2018-09-13
 */
public class VerseBeanServiceImpl extends QuestionGenericBizServiceImpl<IVerseBeanDao, VerseBean>
        implements IVerseBeanService, IQuestionAuditService, IDownloadService, IFreemarkerService {

    private static String AUDIT_ROLE_NAME = "补全诗句审核人";

    @Override
    public String getQuestionType() {
        return QuestionType.INTERVIEW;
    }

    @Override
    public String getAuditRoleName(String subType) {
        return AUDIT_ROLE_NAME;
    }

    @Override
    public String[] createDownloadFile(Long entityId, String fileType) {

        VerseBean verseBean = this.getEntity(entityId);

        Map dataMap = new HashMap();
        Map tempMap = new HashMap();
        dataMap.put("stem", verseBean.getStem());

        tempMap = new HashMap<>();
        tempMap.put("title", "补全诗句");
        tempMap.put("question", dataMap);
        String[] str = new String[2];
        str[0] = "123";
        str[1] = this.createDoc("verse.ftl", tempMap);
        return str;
    }
}
