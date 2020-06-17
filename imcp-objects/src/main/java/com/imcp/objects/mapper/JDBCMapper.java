package com.imcp.objects.mapper;

import com.imcp.objects.bean.ObjResult;
import org.apache.ibatis.annotations.Mapper;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

@Mapper
public interface JDBCMapper {
    //增改
    int executeUpdate(String sql, List<Object> list);
    //单表批量删除
    int executeDelete(String sql, List<Object> list);
    //查询
    List<Map<String,Object>> executeQuery(String sql, String guid);
    //查询
    List<Map<String,Object>> executeQueryAll(String sql,List<Object> list);
    //一对多新增
    int executeAdds(ObjResult objResult);
    //一对多修改
    int executeUpdates(ObjResult objResult);
    //一对多查询
    ObjResult getOneAll(ObjResult objResult);
    //一对多删除
    int deletes(ObjResult objResult);
}
