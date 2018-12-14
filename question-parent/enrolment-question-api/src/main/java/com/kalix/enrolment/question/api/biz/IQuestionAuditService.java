package com.kalix.enrolment.question.api.biz;

import com.kalix.enrolment.question.dto.model.QuestionAuditDTO;
import com.kalix.framework.core.api.IService;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;

/**
 * Created by zangyanming at 2018-09-13.
 */
public interface IQuestionAuditService extends IService {

    /**
     * 获取试题审核角色名称
     * @param subType
     * @return
     */
    String getAuditRoleName(String subType);

    /**
     * 获取试题审核角色名称
     * @param type 试题类别
     * @param subType 试题子类
     * @return
     */
    String getAuditRoleName(String type, String subType);

    /**
     * 试题审核查询
     * @param page
     * @param limit
     * @param jsonStr
     * @param subType
     * @return
     */
    JsonData getAllAuditEntityByQuery(Integer page, Integer limit, String jsonStr, String subType);

    /**
     * 试题审核结果批量处理
     * @param entityIds
     * @param checkFlag
     * @param reason
     * @return
     */
    JsonStatus batchAudit(String entityIds, String checkFlag, String reason);

    /**
     * 获取审核进度信息
     * @param jsonStr
     * @return
     */
    QuestionAuditDTO getAuditProgress(String jsonStr);
}
