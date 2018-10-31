package com.kalix.enrolment.question.api.biz;

import com.kalix.framework.core.api.IService;
import com.kalix.framework.core.api.persistence.JsonStatus;

import java.util.Map;

/**
 * Created by hqj at 2018-10-18.
 */
public interface ITestPaperService extends IService {

    /**
     * 获取题库单项题型预览模板文件名
     *
     * @param subType
     * @return
     */
    String getTempName(String subType);

    /**
     * 生成题库单项题型预览结果
     *
     * @param tempMap 预览内容
     * @return
     */
    String createSinglePreview(Map tempMap, String subType);

    /**
     * 生成试卷单项题型试题结果
     *
     * @return
     */
    Map<String, Object> createSingleTestPaper(Map paperMap);

    JsonStatus createTestPaper(Long paperId);
}
