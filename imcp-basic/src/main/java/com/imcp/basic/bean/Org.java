package com.imcp.basic.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 组织机构实体类
 */
@Data
public class Org {
    //组织id
    @Id
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
    private Integer status;
    //组织描述
    @Column(name="remark")
    private String remark;
}
