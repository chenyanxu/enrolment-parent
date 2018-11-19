package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.ICompletionBeanService;
import com.kalix.enrolment.question.api.biz.IPaperQuesBeanService;
import com.kalix.enrolment.question.api.dao.ICompletionBeanDao;
import com.kalix.enrolment.question.biz.util.Constants;
import com.kalix.enrolment.question.entities.CompletionBean;
import com.kalix.enrolment.question.entities.PaperQuesBean;
import com.kalix.framework.core.api.biz.IDownloadService;
import com.kalix.framework.core.api.persistence.JsonStatus;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator_ on 2018/9/6.
 */
public class CompletionBeanServiceImpl extends QuestionGenericBizServiceImpl<ICompletionBeanDao, CompletionBean>
        implements ICompletionBeanService, IDownloadService {

    private static String DICT_QUESTIONVALUE = "1";
    private static String DICT_SUBTYPE = "";
    private static String TEMP_NAME = "completion.ftl";
    private IPaperQuesBeanService paperQuesBeanService;

    @Override
    public void beforeSaveEntity(CompletionBean entity, JsonStatus status) {
        String pattern = "(?<=\\[#).*?(?=\\])";
        // 编译正则
        Pattern p1 = Pattern.compile(pattern);
        // 指定要匹配的内容
        Matcher m = p1.matcher(entity.getStem());
        m.replaceAll("_");
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
    public String getQuestionType() {
        return DICT_QUESTIONVALUE;
    }

    @Override
    public String getSubTypeDictType() {
        return DICT_SUBTYPE;
    }

    @Override
    public String getTempName(String subType) {
        return TEMP_NAME;
    }

    @Override
    public Map<String, Object> createSingleTestPaper(Map paperMap) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        String pattern = "(?<=\\[#).*?(?=\\])";
        // 编译正则
        Pattern p1 = Pattern.compile(pattern);
        // 指定要匹配的内容

        Map<String, Object> singleTestPaper = new HashMap<String, Object>();
        List<CompletionBean> list_completion = new ArrayList<CompletionBean>();
        String sql = "";
        // 创建试题标题
        String title = "";
        int num=0;
        int sumSpace = 0;
        //Map paperMap=new HashMap();
        //paperMap.put("titlenum","1");
        //paperMap.put("score","2");
        //paperMap.put("totalscore","20");
        // 以下需要通过参数动态获取
        int titleNum = Integer.parseInt(paperMap.get("titlenum").toString());
        String titleName = paperMap.get("questypename").toString();
        int perScore = Integer.parseInt(paperMap.get("score").toString());
        int total = Integer.parseInt(paperMap.get("totalscore").toString());
        title = Constants.numGetChinese(titleNum) + "、" + titleName + "(每空" + perScore + "分，共" + total + "分)";
        singleTestPaper.put("title", title);
        int quesNum = total / perScore;


        Date year = (Date) paperMap.get("year");
        String year_str = simpleDateFormat.format(year);
        String questype = paperMap.get("questype").toString();
        String subtype = paperMap.get("subtype") == null ? "" : paperMap.get("subtype").toString();
        try {
            getComletionList(quesNum, list_completion, year_str, questype, subtype, num);
            // 创建试题内容
            List<Map<String, Object>> question = new ArrayList<Map<String, Object>>();

            if (list_completion != null && list_completion.size() > 0) {
                for (CompletionBean completionBean : list_completion) {
                    sumSpace += completionBean.getSpaceNum();
                }
                // 以下需要通过算法动态获取（抽取试题）
                // List<CompletionBean> list = this.dao.findByNativeSql(sql, CompletionBean.class);
                if (sumSpace == quesNum) {
                    for (int i = 0; i < list_completion.size(); i++) {
                        Map<String, Object> map = new HashMap<String, Object>();
                        CompletionBean completionBean = list_completion.get(i);
                        map.put("type", "填空题");
                        Matcher m = p1.matcher(completionBean.getStem());
                        String stem = m.replaceAll("________").replaceAll("\\[#", "").replaceAll("\\]", "");
                        map.put("stem", stem);
                        question.add(map);
                        PaperQuesBean paperQuesBean = new PaperQuesBean();
                        paperQuesBean.setQuesid(completionBean.getId());
                        paperQuesBean.setYear(year);
                        paperQuesBean.setQuesType(questype);
                        paperQuesBean.setSubType(subtype);
                        paperQuesBeanService.saveEntity(paperQuesBean);
                    }
                }
            }
            singleTestPaper.put("question", question);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return singleTestPaper;
    }

    @Override
    public String[] createDownloadFile(Long entityId, String fileType) {
        String[] str = new String[2];
        CompletionBean completionBean = this.getEntity(entityId);
        Map dataMap = new HashMap();
        dataMap.put("stem", completionBean.getStem());

        Map tempMap = new HashMap();
        // tempMap.put("title", "填空题");
        tempMap.put("question", dataMap);

        str[0] = "填空题";
        str[1] = this.createSinglePreview(tempMap, "");
        return str;
    }

    public void getComletionList(int spacenum, List<CompletionBean> list_completion, String year_str, String questype, String subtype, int num) throws Exception {
        String sql = "select * from enrolment_question_completion where checkFlag='1' and id not in (select quesid from enrolment_question_paperques where  to_char(year, 'yyyy')='" + year_str + "' and questype='" + questype + "' and subtype='" + subtype + "') order by random() limit 1";
        List<CompletionBean> list = this.dao.findByNativeSql(sql, CompletionBean.class);
        if (list != null && list.size() > 0) {
            CompletionBean completionBean = list.get(0);
            int completionSpaceNum = completionBean.getSpaceNum();
            if (!list_completion.contains(completionBean)) {
                spacenum = spacenum - completionSpaceNum;
                if (spacenum > 0) {
                    list_completion.add(completionBean);
                    getComletionList(spacenum, list_completion, year_str, questype, subtype, (num+1));
                } else if (spacenum < 0) {
                    spacenum = spacenum + completionSpaceNum;
                    String sql_1 = "select * from enrolment_question_completion where checkFlag='1' and id not in (select quesid from enrolment_question_paperques where  to_char(year, 'yyyy')='" + year_str + "' and questype='" + questype + "' and subtype='" + subtype + "') and spacenum='" + spacenum + "' order by random() limit 1";
                    List<CompletionBean> list_1 = this.dao.findByNativeSql(sql_1, CompletionBean.class);
                    if (list_1 != null && list_1.size() > 0) {
                        CompletionBean completionBean_1 = list_1.get(0);
                        list_completion.add(completionBean_1);
                    } else {
                        CompletionBean completionBean_last = list_completion.get(list_completion.size() - 1);
                        spacenum = completionBean_last.getSpaceNum() + spacenum;
                        list_completion.remove(list_completion.size() - 1);
                        getComletionList(spacenum, list_completion, year_str, questype, subtype, (num+1));
                    }
                } else {

                        list_completion.add(completionBean);


                }
            } else {
                if(num>5)
                {
                    JsonStatus jsonStatus = new JsonStatus();
                    jsonStatus.setMsg("试题数量不够，请补充试题！");
                    throw new Exception(jsonStatus.getMsg());
                }else {
                    getComletionList(spacenum, list_completion, year_str, questype, subtype, (num+1));
                }
            }
        }
    }

    public void setPaperQuesBeanService(IPaperQuesBeanService paperQuesBeanService) {
        this.paperQuesBeanService = paperQuesBeanService;
    }
}
