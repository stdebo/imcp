package com.imcp.api.bean.basic;

import lombok.Data;

/**
 * 角色实体类
 */
@Data
public class Role {

    private String id;
    private String guid;
    private String roleName;
    private Integer status;
    private String remark;
}
