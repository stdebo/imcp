package com.imcp.objects.mapper.impl;

import com.imcp.objects.bean.ObjResult;
import com.imcp.objects.mapper.JDBCMapper;
import com.imcp.objects.util.DBUtil;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.*;

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
    public List<Map<String,Object>> executeQuery(String sql, String guid) {
        try {
            connection = DBUtil.getConnnection();
            //用PreparedStatement对象去执行sql代码
            preparedStatement = connection.prepareStatement(sql);
            //不定长参数产生的是一个数组所以我们要用for循环去遍历它的长度（不定长参数可以为空）
            preparedStatement.setObject(1,guid);
            //执行查询的方法
            resultSet = preparedStatement.executeQuery();
            List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
            Map<String,Object> map = new HashMap<String,Object>();
            //返回结果集
            //获取列数
            ResultSetMetaData md= resultSet.getMetaData();
            int columnSize = md.getColumnCount();
            while(resultSet.next()){       //循环遍历查询结果集
                for(int i = 1; i <= columnSize ; i++){
                    map.put(md.getColumnName(i),resultSet.getObject(i));
                }
                list.add(map);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closeDB(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public List<Map<String, Object>> executeQueryAll(String sql,List<Object> list) {
        try {
            connection = DBUtil.getConnnection();
            //用PreparedStatement对象去执行sql代码
            preparedStatement = connection.prepareStatement(sql);
            for (int i=0;i<list.size();i++){
                //给执行的sql语句里面的？赋值
                preparedStatement.setObject(i+1,list.get(i));
            }
            //执行查询的方法
            resultSet = preparedStatement.executeQuery();
            List<Map<String,Object>> lists = new ArrayList<Map<String,Object>>();
            Map<String,Object> map = new HashMap<String,Object>();
            //返回结果集
            //获取列数
            ResultSetMetaData md= resultSet.getMetaData();
            int columnSize = md.getColumnCount();
            while(resultSet.next()){       //循环遍历查询结果集
                for(int i = 1; i <= columnSize ; i++){
                    map.put(md.getColumnName(i),resultSet.getObject(i));
                }
                lists.add(map);
            }
            return lists;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closeDB(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public int executeAdds(ObjResult objResult) {
        return 0;
    }

    @Override
    public int executeUpdates(ObjResult objResult) {
        return 0;
    }

    @Override
    public ObjResult getOneAll(ObjResult objResult) {
        return null;
    }

    @Override
    public int deletes(ObjResult objResult) {
        return 0;
    }
}
