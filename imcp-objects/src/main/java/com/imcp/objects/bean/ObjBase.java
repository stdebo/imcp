package com.imcp.objects.bean;

import lombok.Data;
import tk.mybatis.mapper.entity.Example;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 数据对象实体
 */
@Data
@Table(name="objBase")
public class ObjBase {
    //ID
    @Id
    private Integer id;
    //对象记录ID
    @Column(name="guid")
    private String guid;
    //数据对象名
    @Column(name="objViewName")
    private String objViewName;
    //数据对象物理名
    @Column(name="objName")
    private String objName;
    //数据对象状态
    private Integer status;
    //对象脚本
    private String script;
    //锁定对象
    private String locked;
    //数据对象创建日期
    @Column(name="createDate")
    private String createDate;
    //备注
    private String remark;

}
