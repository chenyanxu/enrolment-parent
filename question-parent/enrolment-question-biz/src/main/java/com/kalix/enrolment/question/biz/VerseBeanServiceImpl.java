package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.IPaperQuesBeanService;
import com.kalix.enrolment.question.api.biz.IVerseBeanService;
import com.kalix.enrolment.question.api.dao.IVerseBeanDao;
import com.kalix.enrolment.question.biz.util.Constants;
import com.kalix.enrolment.question.entities.PaperQuesBean;
import com.kalix.enrolment.question.entities.VerseBean;
import com.kalix.enrolment.system.dict.api.biz.IEnrolmentDictBeanService;
import com.kalix.enrolment.system.dict.entities.EnrolmentDictBean;
import com.kalix.framework.core.api.biz.IDownloadService;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zangyanming at 2018-09-13
 */
public class VerseBeanServiceImpl extends QuestionGenericBizServiceImpl<IVerseBeanDao, VerseBean>
        implements IVerseBeanService, IDownloadService {

    private static String TEMP_NAME = "verse.ftl";
    private static String DICT_TYPE = "题型";
    private static String DICT_VALUE = "3";
    private IEnrolmentDictBeanService enrolmentDictBeanService;
    private IPaperQuesBeanService paperQuesBeanService;

    @Override
    public String getAuditRoleName(String subType) {
        EnrolmentDictBean enrolmentDictBean = enrolmentDictBeanService.getDictBeanByTypeAndValue(DICT_TYPE, DICT_VALUE);
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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        String pattern = "(?<=\\[#).*?(?=\\])";
        // 编译正则
        Pattern p1 = Pattern.compile(pattern);
        // 指定要匹配的内容
        Map<String, Object> singleTestPaper = new HashMap<String, Object>();
        String sql = "";
        // 创建试题标题
        String title = "";
        // 以下需要通过参数动态获取
        int titleNum = Integer.parseInt(paperMap.get("titlenum").toString());
        String titleName = "补全诗句";
        int perScore = Integer.parseInt(paperMap.get("score").toString());
        int total = Integer.parseInt(paperMap.get("totalscore").toString());
        title = Constants.numGetChinese(titleNum) + "、" + titleName + "(每题" + perScore + "分，共" + total + "分)";
        singleTestPaper.put("title", title);
        int quesNum = total / perScore;

        Date year = (Date) paperMap.get("year");
        String year_str = simpleDateFormat.format(year);
        String questype = paperMap.get("questype").toString();
        String subtype = paperMap.get("subtype") == null ? "" : paperMap.get("subtype").toString();
        sql = "select * from enrolment_question_verse where id not in (select quesid from enrolment_question_paperques where  to_char(year, 'yyyy')='" + year_str + "' and questype='" + questype + "' and subtype='" + subtype + "') order by random() limit " + quesNum;
        // String sql = "select * from enrolment_question_verse order by random() limit " + quesNum;
        // 创建试题内容
        List<Map<String, Object>> question = new ArrayList<Map<String, Object>>();
        // 以下需要通过算法动态获取（抽取试题）
        List<VerseBean> list = this.dao.findByNativeSql(sql, VerseBean.class);
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            VerseBean verseBean = list.get(i);
            map.put("type", "补全诗句");
            Matcher m = p1.matcher(verseBean.getStem());
            String stem = m.replaceAll("________").replaceAll("\\[#", "").replaceAll("\\]", "");
            map.put("stem", stem);
            PaperQuesBean paperQuesBean = new PaperQuesBean();
            paperQuesBean.setQuesid(verseBean.getId());
            paperQuesBean.setYear(year);
            paperQuesBean.setQuesType(questype);
            paperQuesBean.setSubType(subtype);
            paperQuesBeanService.saveEntity(paperQuesBean);
            question.add(map);
        }
        singleTestPaper.put("question", question);

        return singleTestPaper;
    }

    @Override
    public String[] createDownloadFile(Long entityId, String fileType) {
        String[] str = new String[2];
        VerseBean verseBean = this.getEntity(entityId);
        Map dataMap = new HashMap();
        dataMap.put("stem", verseBean.getStem());

        Map tempMap = new HashMap();
        // tempMap.put("title", "补全诗句");
        tempMap.put("question", dataMap);

        str[0] = "补全诗句";
        str[1] = this.createSinglePreview(tempMap, "");
        return str;
    }

    public void setEnrolmentDictBeanService(IEnrolmentDictBeanService enrolmentDictBeanService) {
        this.enrolmentDictBeanService = enrolmentDictBeanService;
    }

    public void setPaperQuesBeanService(IPaperQuesBeanService paperQuesBeanService) {
        this.paperQuesBeanService = paperQuesBeanService;
    }
}
