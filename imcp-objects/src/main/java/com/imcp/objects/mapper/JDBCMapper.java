package com.imcp.objects.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.sql.ResultSet;
import java.util.List;

@Mapper
public interface JDBCMapper {
    //增改
    int executeUpdate(String sql, List<Object> list);
    //单表批量删除
    int executeDelete(String sql, List<Object> list);
    //查询
    ResultSet executeQuery(String sql, Object...obj);
}
