package com.imcp.objects.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 数据对象字段实体
 */
@Data
@Table(name = "objField")
public class ObjField {
    //ID
   private String id;
    //字段记录ID
    private String guid;
    //对象ID
    @Column(name="objGuid")
    private String objGuid;
    //字段物理名
    @Column(name="fieldViewName")
    private String fieldViewName;
    //字段物理名
    @Column(name="fieldName")
    private String fieldName;
    //是否是主键
    @Column(name="fieldPrimaryKey")
    private String fieldPrimaryKey;
    //字段类型
    @Column(name="fieldType")
    private String fieldType;
    //字段长度
    @Column(name="fieldLength")
    private String fieldLength;
    //字段默认值
    @Column(name="fieldDefault")
    private String fieldDefault;
    //字段是否非空
    @Column(name="fieldFillin")
    private String fieldFillin;
    //字段创建日期
    @Column(name="createDate")
    private String createDate;
    //备注
    private String remark;

}
