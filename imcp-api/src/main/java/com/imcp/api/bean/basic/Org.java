package com.imcp.api.bean.basic;

import lombok.Data;

/**
 * 组织机构实体类
 */
@Data
public class Org {
    //组织id
    private String id;
    //组织guid
    private String guid;
    //组织名称
    private String orgName;
    //上级组织id
    private String parent;
    //状态
    private Integer status;
    //组织描述
    private String remark;
}
