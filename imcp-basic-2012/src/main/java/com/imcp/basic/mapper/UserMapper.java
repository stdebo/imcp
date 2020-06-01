package com.imcp.basic.mapper;

import com.imcp.basic.bean.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface UserMapper extends Mapper<User> {
    /**
     *
     * @param userCode
     * @param passWord
     * @return
     */
    public User queryUser(String userCode,String passWord);

}
