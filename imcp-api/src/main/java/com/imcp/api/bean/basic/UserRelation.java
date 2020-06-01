package com.imcp.api.bean.basic;

import lombok.Data;

/**
 * 用户关联表
 */
@Data
public class UserRelation {
    //id
    private String id;
    //用户id
    private String userGuid;
    //角色id
    private String roleGuid;
    //部门id
    private String deptGuid;
    //组织id
    private String orgGuid;
    //描述
    private String remark;
}
