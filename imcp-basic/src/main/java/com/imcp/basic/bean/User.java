package com.imcp.basic.bean;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 用户实体类
 */
@Data
public class User {
    //用户id
    private String id;
    //用户guid
    private String guid;
    //用户code
    private String userCode;
    //用户名称
    private String userName;
    //用户密码
    private String passWord;
    //性别
    private Integer sex;
    //电子邮箱
    private String email;
    //出生日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date userBirth;
    //身份证号
    private String idCard;
    //手机号
    private String mobileno;
    //家庭住址
    private String address;
    //创建日期
    private Date createDate;
    //状态
    private Integer status;
    //描述
    private String remark;

}
