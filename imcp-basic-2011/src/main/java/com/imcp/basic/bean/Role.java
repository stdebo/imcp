package com.imcp.basic.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 角色实体类
 */
@Data
public class Role {
    //角色id
    @Id
    private String id;
    //角色guid
    @Column(name="guid")
    private String guid;
    //角色名称
    @Column(name="roleName")
    private String roleName;
    //状态
    @Column(name="status")
    private Integer status;
    //描述
    @Column(name="remark")
    private String remark;
}
