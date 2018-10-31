package com.kalix.enrolment.question.api.biz;

import com.kalix.framework.core.api.IService;
import com.kalix.framework.core.api.persistence.JsonStatus;

import java.util.Map;

/**
 * Created by hqj at 2018-10-18.
 */
public interface ITestPaperService extends IService {

    /**
     * 生成题库单项题型预览结果
     *
     * @param tempMap 预览内容
     * @return
     */
    String createSinglePreview(Map tempMap, String subType);
}
