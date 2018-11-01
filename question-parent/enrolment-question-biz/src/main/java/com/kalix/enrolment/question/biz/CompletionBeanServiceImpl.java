package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.ICompletionBeanService;
import com.kalix.enrolment.question.api.dao.ICompletionBeanDao;
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
        implements ICompletionBeanService, IDownloadService {

    private static String AUDIT_ROLE_NAME = "填空题审核人";
    private static String TEMP_NAME = "completion.ftl";

    @Override
    public void beforeSaveEntity(CompletionBean entity, JsonStatus status) {
        String pattern = "(?<=\\[#).*?(?=\\])";
        // 编译正则
        Pattern p1 = Pattern.compile(pattern);
        // 指定要匹配的内容
        Matcher m = p1.matcher(entity.getStem());
        // 计算次数
        int count = 0;
        while (m.find()) {
            count++;
        }
        entity.setSpaceNum(count);

        // 解决create_by 未写入的问题
        super.beforeSaveEntity(entity, status);
    }

    @Override
    public String getAuditRoleName(String subType) {
        return AUDIT_ROLE_NAME;
    }

    @Override
    public String getTempName(String subType) {
        return TEMP_NAME;
    }

//    @Override
//    public Map<String, Object> createSingleTestPaper(Map paperMap) {
//        return null;
//    }

    @Override
    public Map<String, Object> createSingleTestPaper(Map paperMap) {

        Map<String, Object> singleTestPaper = new HashMap<String, Object>();
        List<CompletionBean> list_completion = new ArrayList<CompletionBean>();
        String sql = "";
        // 创建试题标题
        String title = "";
        //Map paperMap=new HashMap();
        //paperMap.put("titlenum","1");
        //paperMap.put("score","2");
        //paperMap.put("totalscore","20");
        // 以下需要通过参数动态获取
        int titleNum = Integer.parseInt((String) paperMap.get("titlenum"));
        String titleName = "填空题";
        int perScore = Integer.parseInt((String) paperMap.get("score"));
        int total = Integer.parseInt((String) paperMap.get("totalscore"));
        title = Constants.numGetChinese(titleNum) + "、" + titleName + "(每空" + perScore + "分，共" + total + "分)";
        singleTestPaper.put("title", title);
        int quesNum = total / perScore;

        getComletionList(quesNum, list_completion);
//        int num=0;
//        for(CompletionBean completionBean:list_completion){
//            System.out.println("------>"+completionBean.getSpaceNum());
//
//            num=num+ completionBean.getSpaceNum()*1;
//
//        }
//        System.out.println(num);
        // sql="select * from CompletionBean order by random() limit "+quesNum;
        // 创建试题内容
        List<Map<String, Object>> question = new ArrayList<Map<String, Object>>();
        // 以下需要通过算法动态获取（抽取试题）
        // List<CompletionBean> list = this.dao.findByNativeSql(sql, CompletionBean.class);
        for (int i = 0; i < list_completion.size(); i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            CompletionBean completionBean = list_completion.get(i);
            map.put("type", "填空题");
            map.put("stem", completionBean.getStem());
            question.add(map);
        }
        singleTestPaper.put("question", question);

        return singleTestPaper;
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

    public void getComletionList(int spacenum, List<CompletionBean> list_completion) {
        String sql = "select * from enrolment_question_completion order by random() limit 1";
        List<CompletionBean> list = this.dao.findByNativeSql(sql, CompletionBean.class);
        if (list != null && list.size() > 0) {
            CompletionBean completionBean = list.get(0);
            int completionSpaceNum = completionBean.getSpaceNum();
            spacenum = spacenum - completionSpaceNum;
            if (spacenum > 0) {
                list_completion.add(completionBean);
                getComletionList(spacenum, list_completion);
            } else if (spacenum < 0) {
                spacenum = spacenum + completionSpaceNum;
                String sql_1 = "select * from enrolment_question_completion where spacenum='" + spacenum + "' order by random() limit 1";
                List<CompletionBean> list_1 = this.dao.findByNativeSql(sql_1, CompletionBean.class);
                if (list_1 != null && list_1.size() > 0) {
                    CompletionBean completionBean_1 = list_1.get(0);
                    list_completion.add(completionBean_1);
                } else {
                    CompletionBean completionBean_last = list_completion.get(list_completion.size() - 1);
                    spacenum = completionBean_last.getSpaceNum() + spacenum;
                    list_completion.remove(list_completion.size() - 1);
                    getComletionList(spacenum, list_completion);
                }

            } else {
                list_completion.add(completionBean);
            }

        }

    }
}
