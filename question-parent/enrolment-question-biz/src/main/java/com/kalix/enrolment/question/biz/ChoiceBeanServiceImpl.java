package com.kalix.enrolment.question.biz;

import com.kalix.admin.core.api.biz.IRoleBeanService;
import com.kalix.admin.core.entities.RoleBean;
import com.kalix.enrolment.question.api.biz.IChoiceBeanService;
import com.kalix.enrolment.question.api.dao.IChoiceBeanDao;
import com.kalix.enrolment.question.entities.ChoiceBean;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.util.StringUtils;
import com.kalix.framework.extend.impl.biz.LogicDeleteGenericBizServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zangyanming at 2018-09-13
 */
public class ChoiceBeanServiceImpl extends LogicDeleteGenericBizServiceImpl<IChoiceBeanDao, ChoiceBean> implements IChoiceBeanService {

    private IRoleBeanService roleBeanService;
    private static String rolename = "选择题出题人";

    @Override
    public JsonData getAllEntityByQuery(Integer page, Integer limit, String jsonStr, String sort) {
        JsonData jsonData = new JsonData();
        if (StringUtils.isEmpty(sort)) {
            sort = "[{'property': 'delFlag', 'direction': 'ASC'},{'property': 'updateDate', 'direction': 'DESC'}]";
        }

        // 未审核试题总数
        String countSql = "select count(1) from " + dao.getTableName()
                + " where checkFlag = '0' and delFlag = '0'"
                + " and (substr(to_char(creationdate,'yyyy-mm-dd hh:mi:ss'),1,4) = to_char(now(),'yyyy-mm-dd hh:mi:ss'))";
        List list = dao.findByNativeSql(countSql, Integer.class);
        int total = 0;
        if (list != null && list.get(0) != null) {
            total = (Integer) list.get(0);
        }

        // 根据该试题的角色查找审核该试题的人员
        int persons = 0;
        List userIdList = new ArrayList();
        RoleBean roleBean = roleBeanService.queryByRoleName(rolename);
        if(roleBean != null){
            userIdList = roleBeanService.getUserIdsByRoleId(roleBean.getId());
            persons = userIdList.size();
        }

        // 分给每个人的试题数
        int perCnt = 0;
        if (persons != 0) {
            perCnt = total / persons;
        }

        int ys = total % persons;

        int lpoint = 0;
        Long currentUserId = shiroService.getCurrentUserId();
        for (int i = 0; i < userIdList.size(); i++) {
            if (userIdList.get(i).equals(currentUserId)) {
                if (i < ys) {
                    lpoint = i * perCnt + 1;
                } else {
                    lpoint = i * perCnt;
                }
                break;
            }
        }

        String sql = "select * from " + dao.getTableName()
                + " where checkFlag = '0' and delFlag = '0'"
                + " and (substr(to_char(creationdate,'yyyy-mm-dd hh:mi:ss'),1,4) = to_char(now(),'yyyy-mm-dd hh:mi:ss'))"
                + " order by id limit " + perCnt + " offset " + lpoint;

        jsonData = dao.findByNativeSql(sql, page, limit, ChoiceBean.class);

        return jsonData;
        //return super.getAllEntityByQuery(page, limit, jsonStr, sort);
    }

    @Override
    public JsonData getAllCheckEntityByQuery(Integer page, Integer limit, String jsonStr, String sort) {

        return getAllEntityByQuery(page, limit, jsonStr, sort);
    }

    @Override
    public JsonStatus batchAudit(String entityIds, String reason) {
        JsonStatus jsonStatus = new JsonStatus();
        jsonStatus.setSuccess(true);

        return jsonStatus;
    }

    public void setRoleBeanService(IRoleBeanService roleBeanService) {
        this.roleBeanService = roleBeanService;
    }
}
