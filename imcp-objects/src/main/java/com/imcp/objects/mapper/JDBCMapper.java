package com.imcp.objects.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.sql.ResultSet;

@Mapper
public interface JDBCMapper {
    //增删改  里面需要传入一个sql语句还有一个不定长参数（是为sql语句里面？准备的）
    int executeUpdate(String sql,String dataBase,Object...obj);
    //查询   里面需要传入一个sql语句还有一个不定长参数（是为sql语句里面？准备的）
    ResultSet executeQuery(String sql,String dataBase, Object...obj);
}
