package com.imcp.basic.bean;

import lombok.Data;

import javax.persistence.Column;

/**
 * 角色实体类
 */
@Data
public class Role {
    //角色id
    @Column(name="id")
    private String id;
    //角色guid
    @Column(name="guid")
    private String guid;
    //角色名称
    @Column(name="rolaName")
    private String rolaName;
    //状态
    @Column(name="status")
    private String status;
    //描述
    @Column(name="remark")
    private String remark;
}
