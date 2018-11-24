package com.kalix.enrolment.question.api.biz;

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
     * 试题审核查询
     * @param page
     * @param limit
     * @param subType
     * @return
     */
    JsonData getAllAuditEntityByQuery(Integer page, Integer limit, String subType);

    /**
     * 试题审核结果批量处理
     * @param entityIds
     * @param checkFlag
     * @param reason
     * @return
     */
    JsonStatus batchAudit(String entityIds, String checkFlag, String reason);
}
