package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.IChoiceBeanService;
import com.kalix.enrolment.question.api.biz.IFreemarkerService;
import com.kalix.enrolment.question.api.biz.IQuestionAuditService;
import com.kalix.enrolment.question.api.dao.IChoiceBeanDao;
import com.kalix.enrolment.question.api.model.QuestionType;
import com.kalix.enrolment.question.entities.ChoiceBean;
import com.kalix.framework.core.api.biz.IDownloadService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zangyanming at 2018-09-13
 */
public class ChoiceBeanServiceImpl extends QuestionGenericBizServiceImpl<IChoiceBeanDao, ChoiceBean>
        implements IChoiceBeanService, IQuestionAuditService, IDownloadService, IFreemarkerService {

    private static String AUDIT_ROLE_NAME = "选择题审核人";

    @Override
    public String getQuestionType() {
        return QuestionType.CHOICE;
    }

    @Override
    public String getAuditRoleName(String subType) {
        return AUDIT_ROLE_NAME;
    }

    @Override
    public String[] createDownloadFile(Long entityId, String fileType) {
        String[] str = new String[2];
        ChoiceBean choiceBean = this.getEntity(entityId);
        Map dataMap = new HashMap();
        Map tempMap = new HashMap();
        dataMap.put("stem", choiceBean.getStem());
        dataMap.put("answerA", choiceBean.getAnswerA());
        dataMap.put("answerB", choiceBean.getAnswerB());
        dataMap.put("answerC", choiceBean.getAnswerC());
        dataMap.put("answerD", choiceBean.getAnswerD());

        tempMap = new HashMap<>();
        tempMap.put("title", "选择题");
        tempMap.put("question", dataMap);

        str[0] = "123";
        str[1] = this.createDoc("choice.ftl", tempMap);
        return str;
    }
}
