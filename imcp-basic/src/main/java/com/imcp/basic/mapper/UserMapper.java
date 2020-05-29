package com.imcp.basic.mapper;

import com.imcp.basic.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 新增用户
     * @param user
     * @return
     */
    public int addUser(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    public int delUser(String id);

    /**
     * 修改用户
     * @param user
     * @return
     */
    public int updateUser(User user);

    /**
     * 根据用户code和密码查询用户
     * @param userName
     * @param passWord
     * @return
     */
    public User queryUser(String userName,String passWord);

    /**
     * 查询用户列表
     * @return
     */
    public List<User> getAllUser();

    /**
     * 根据guid查询用户
     * @param guid
     * @return
     */
    public User getUserByGuid(String guid);
}
