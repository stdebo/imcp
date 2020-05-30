package com.imcp.basic.bean;

import lombok.Data;

import javax.persistence.Column;

/**
 * 部门实体类
 */
@Data
public class Dept {
    //部门id
    @Column(name="id")
    private String id;
    //部门guid
    @Column(name="guid")
    private String guid;
    //部门名称
    @Column(name="deptName")
    private String deptName;
    //上级部门id
    @Column(name="parent")
    private String parent;
    //状态
    @Column(name="status")
    private String status;
    //部门描述
    @Column(name="remark")
    private String remark;
}
