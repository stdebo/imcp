package com.imcp.basic.bean;

import lombok.Data;

import javax.persistence.Column;

/**
 * 组织机构实体类
 */
@Data
public class Org {
    //组织id
    @Column(name="id")
    private String id;
    //组织guid
    @Column(name="guid")
    private String guid;
    //组织名称
    @Column(name="orgName")
    private String orgName;
    //上级组织id
    @Column(name="parent")
    private String parent;
    //状态
    @Column(name="status")
    private String status;
    //组织描述
    @Column(name="remark")
    private String remark;
}
