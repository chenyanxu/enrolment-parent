package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.IQuestionAuditService;
import com.kalix.enrolment.question.api.biz.ITestPaperService;
import com.kalix.enrolment.question.api.biz.IVerseBeanService;
import com.kalix.enrolment.question.api.dao.IVerseBeanDao;
import com.kalix.enrolment.question.api.model.QuestionType;
import com.kalix.enrolment.question.biz.util.Constants;
import com.kalix.enrolment.question.entities.VerseBean;
import com.kalix.framework.core.api.biz.IDownloadService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zangyanming at 2018-09-13
 */
public class VerseBeanServiceImpl extends QuestionGenericBizServiceImpl<IVerseBeanDao, VerseBean>
        implements IVerseBeanService, IQuestionAuditService, IDownloadService, ITestPaperService {

    private static String AUDIT_ROLE_NAME = "补全诗句审核人";
    private static String TEMP_NAME = "verse.ftl";

    @Override
    public String getQuestionType() {
        return QuestionType.VERSE;
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
        str[1] = this.createSinglePreview(tempMap, "");
        return str;
    }

    @Override
    public String getTempName(String subType) {
        return TEMP_NAME;
    }

    @Override
    public Map<String, Object> createSingleTestPaper(String subType) {

        Map<String, Object> singleTestPaper = new HashMap<String, Object>();

        // 创建试题标题
        String title = "";
        // 以下需要通过参数动态获取
        int titleNum = 3;
        String titleName = "补全诗句";
        String perScore = "5";
        String total = "25";
        title = Constants.numGetChinese(titleNum) + "、" + titleName + "(每题" + perScore + "分，共" + total + "分)";
        singleTestPaper.put("title", title);

        // 创建试题内容
        List<Map<String, Object>> question = new ArrayList<Map<String, Object>>();
        // 以下需要通过算法动态获取（抽取试题）
        List<VerseBean> list = this.dao.getAll();
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            VerseBean verseBean = list.get(i);
            map.put("type", "填空题");
            map.put("stem", verseBean.getStem());
            question.add(map);
        }
        singleTestPaper.put("question", question);

        return singleTestPaper;
    }
}
