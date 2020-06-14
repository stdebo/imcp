package com.imcp.objects.mapper.impl;

import com.imcp.objects.mapper.JDBCMapper;
import com.imcp.objects.util.DBUtil;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service("JDBCMapperImpl")
public class JDBCMapperImpl implements JDBCMapper {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Override
    public int executeUpdate(String sql, List<Object> obj) {
        try {
            connection = DBUtil.getConnnection();
            //用PreparedStatement对象去执行sql代码
            preparedStatement = connection.prepareStatement(sql);
            //不定长参数产生的是一个数组所以我们要用for循环去遍历它的长度（不定长参数可以为空）
            for (int i=0;i<obj.size();i++){
                //给执行的sql语句里面的？赋值
                preparedStatement.setObject(i+1,obj.get(i));
            }
            //执行增删改的方法
            int i = preparedStatement.executeUpdate();
            //返回行数
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
            //捕获到异常则返回-1
            return -1;
        }finally {
            DBUtil.closeDB(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public int executeDelete(String sql, List<Object> list) {
        try {
            connection = DBUtil.getConnnection();
            //用PreparedStatement对象去执行sql代码
            preparedStatement = connection.prepareStatement(sql);
            //不定长参数产生的是一个数组所以我们要用for循环去遍历它的长度（不定长参数可以为空）
            for (int i=0;i<list.size();i++){
                //给执行的sql语句里面的？赋值
                preparedStatement.setObject(i+1,list.get(i));
            }
            //执行增删改的方法
            int i = preparedStatement.executeUpdate();
            //返回行数
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
            //捕获到异常则返回-1
            return -1;
        }finally {
            DBUtil.closeDB(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public ResultSet executeQuery(String sql, Object... obj) {
        try {
            connection = DBUtil.getConnnection();
            //用PreparedStatement对象去执行sql代码
            preparedStatement = connection.prepareStatement(sql);
            //不定长参数产生的是一个数组所以我们要用for循环去遍历它的长度（不定长参数可以为空）
            for (int i=0;i<obj.length;i++){
                //给执行的sql语句里面的？赋值
                preparedStatement.setObject(i+1,obj[i]);
            }
            //执行查询的方法
            resultSet = preparedStatement.executeQuery();
            //返回结果集
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closeDB(connection, preparedStatement, resultSet);
        }
    }
}
