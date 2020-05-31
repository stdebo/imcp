package com.imcp.basic.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户关联表
 */
@Data
@Table(name ="User_Relation")
public class UserRelation {
    //id
    @Id
    private String id;
    //用户id
    @Column(name ="userGuid")
    private String userGuid;
    //角色id
    @Column(name ="roleGuid")
    private String roleGuid;
    //部门id
    @Column(name ="deptGuid")
    private String deptGuid;
    //组织id
    @Column(name ="orgGuid")
    private String orgGuid;
    //描述
    @Column(name ="remark")
    private String remark;
}
