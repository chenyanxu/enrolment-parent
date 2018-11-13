package com.kalix.enrolment.question.biz;

import com.kalix.enrolment.question.api.biz.IMusicBeanService;
import com.kalix.enrolment.question.api.biz.IPaperQuesBeanService;
import com.kalix.enrolment.question.api.dao.IMusicBeanDao;
import com.kalix.enrolment.question.entities.MusicBean;
import com.kalix.framework.core.api.biz.IDownloadService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zangyanming at 2018-09-13
 */
public class MusicBeanServiceImpl extends QuestionGenericBizServiceImpl<IMusicBeanDao, MusicBean>
        implements IMusicBeanService, IDownloadService {

    private static String DICT_QUESTIONVALUE = "4";
    private static String DICT_SUBTYPE = "";
    private static String TEMP_NAME = "";
    private IPaperQuesBeanService paperQuesBeanService;

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
