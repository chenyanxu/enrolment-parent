package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.ICompletionBeanService;
import com.kalix.enrolment.question.api.biz.IQuestionAuditService;
import com.kalix.enrolment.question.api.biz.ITestPaperService;
import com.kalix.enrolment.question.api.dao.ICompletionBeanDao;
import com.kalix.enrolment.question.api.model.QuestionType;
import com.kalix.enrolment.question.biz.util.Constants;
import com.kalix.enrolment.question.entities.CompletionBean;
import com.kalix.framework.core.api.biz.IDownloadService;
import com.kalix.framework.core.api.persistence.JsonStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator_ on 2018/9/6.
 */
public class CompletionBeanServiceImpl extends QuestionGenericBizServiceImpl<ICompletionBeanDao, CompletionBean>
        implements ICompletionBeanService, IQuestionAuditService, IDownloadService, ITestPaperService {

    private static String AUDIT_ROLE_NAME = "填空题审核人";
    private static String TEMP_NAME = "completion.ftl";

    @Override
    public String getQuestionType() {
        return QuestionType.COMPLETION;
    }

    @Override
    public String getAuditRoleName(String subType) {
        return AUDIT_ROLE_NAME;
    }

    @Override
    public void beforeSaveEntity(CompletionBean entity, JsonStatus status) {
        String pattern = "(?<=\\[#).*?(?=\\])";
        //	编译正则
        Pattern p1 = Pattern.compile(pattern);
        //	指定要匹配的内容
        Matcher m = p1.matcher(entity.getStem());
//	计算次数
        int count = 0;
        while(m.find()){
            count++;
        }
        entity.setSpaceNum(count);

        // 解决create_by 未写入的问题
        super.beforeSaveEntity(entity, status);
    }



    @Override
    public String[] createDownloadFile(Long entityId, String fileType) {

        CompletionBean completionBean = this.getEntity(entityId);

        Map dataMap = new HashMap();
        Map tempMap = new HashMap();
        dataMap.put("stem", completionBean.getStem());

        // List question = new ArrayList();
        //  question.add(dataMap);
        tempMap = new HashMap<>();
        tempMap.put("title", "填空题");
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
        int titleNum = 2;
        String titleName = "填空题";
        String perScore = "1";
        String total = "30";
        title = Constants.numGetChinese(titleNum) + "、" + titleName + "(每空" + perScore + "分，共" + total + "分)";
        singleTestPaper.put("title", title);

        // 创建试题内容
        List<Map<String, Object>> question = new ArrayList<Map<String, Object>>();
        // 以下需要通过算法动态获取（抽取试题）
        List<CompletionBean> list = this.dao.getAll();
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            CompletionBean completionBean = list.get(i);
            map.put("type", "填空题");
            map.put("stem", completionBean.getStem());
            question.add(map);
        }
        singleTestPaper.put("question", question);

        return singleTestPaper;
    }
}
