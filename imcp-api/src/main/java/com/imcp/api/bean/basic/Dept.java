package com.imcp.api.bean.basic;

import lombok.Data;

/**
 * 部门实体类
 */
@Data
public class Dept {
    //部门id
    private String id;
    //部门guid
    private String guid;
    //部门名称
    private String deptName;
    //上级部门id
    private String parent;
    //状态
    private Integer status;
    //部门描述
    private String remark;
}
