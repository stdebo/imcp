package com.imcp.basic.bean;

import lombok.Data;

/**
 * 角色实体类
 */
@Data
public class Role {
    //角色id
    private String id;
    //角色guid
    private String guid;
    //角色名称
    private String rolaName;
    //状态
    private String status;
    //描述
    private String remark;
}
