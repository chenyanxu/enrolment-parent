package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.IChoiceBeanService;
import com.kalix.enrolment.question.api.dao.IChoiceBeanDao;
import com.kalix.enrolment.question.biz.util.Constants;
import com.kalix.enrolment.question.entities.ChoiceBean;
import com.kalix.framework.core.api.biz.IDownloadService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zangyanming at 2018-09-13
 */
public class ChoiceBeanServiceImpl extends QuestionGenericBizServiceImpl<IChoiceBeanDao, ChoiceBean>
        implements IChoiceBeanService, IDownloadService {

    private static String AUDIT_ROLE_NAME = "选择题审核人";
    private static String TEMP_NAME = "choice.ftl";

    @Override
    public String getAuditRoleName(String subType) {
        return AUDIT_ROLE_NAME;
    }

    @Override
    public String getTempName(String subType) {
        return TEMP_NAME;
    }

    @Override
    public Map<String, Object> createSingleTestPaper(Map paperMap) {

        Map<String, Object> singleTestPaper = new HashMap<String, Object>();

        // 创建试题标题
        String title = "";
        // 以下需要通过参数动态获取
        int titleNum = Integer.parseInt(paperMap.get("titlenum").toString()) ;
        String titleName = "单项选择题";
        int perScore =  Integer.parseInt(paperMap.get("score").toString());
        int total =  Integer.parseInt(paperMap.get("totalscore").toString());
        title = Constants.numGetChinese(titleNum) + "、" + titleName + "(每题" + perScore + "分，共" + total + "分)";
        singleTestPaper.put("title", title);
        int quesNum = total / perScore;
        String sql = "select * from enrolment_question_Choice order by random() limit " + quesNum;
        // 创建试题内容
        List<Map<String, Object>> question = new ArrayList<Map<String, Object>>();
        // 以下需要通过算法动态获取（抽取试题）
        List<ChoiceBean> list = this.dao.findByNativeSql(sql, ChoiceBean.class);
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            ChoiceBean choiceBean = list.get(i);
            map.put("type", "选择题");
            map.put("stem", choiceBean.getStem());
            map.put("answerA", choiceBean.getAnswerA());
            map.put("answerB", choiceBean.getAnswerB());
            map.put("answerC", choiceBean.getAnswerC());
            map.put("answerD", choiceBean.getAnswerD());
            question.add(map);
        }
        singleTestPaper.put("question", question);

        return singleTestPaper;
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
        str[1] = this.createSinglePreview(tempMap, "");
        return str;
    }
}
