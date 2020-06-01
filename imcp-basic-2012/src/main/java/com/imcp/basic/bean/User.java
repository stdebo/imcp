package com.imcp.basic.bean;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * 用户实体类
 */
@Data
public class User {
    //用户id
    @Id
    private String id;
    //用户guid
    @Column(name="guid")
    private String guid;
    //用户code
    @Column(name="userCode")
    private String userCode;
    //用户名称
    @Column(name="userName")
    private String userName;
    //用户密码
    @Column(name="passWord")
    private String passWord;
    //性别
    @Column(name="sex")
    private Integer sex;
    //电子邮箱
    @Column(name="email")
    private String email;
    //出生日期
    @Column(name="userBirth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date userBirth;
    //身份证号
    @Column(name="idCard")
    private String idCard;
    //手机号
    @Column(name="mobileno")
    private String mobileno;
    //家庭住址
    @Column(name="address")
    private String address;
    //创建日期
    @Column(name="createDate")
    private Date createDate;
    //状态
    @Column(name="status")
    private Integer status;
    //描述
    @Column(name="remark")
    private String remark;

}
