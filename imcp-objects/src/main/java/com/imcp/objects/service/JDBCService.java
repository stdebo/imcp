package com.imcp.objects.service;

import com.imcp.objects.bean.ObjResult;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public interface JDBCService {
    //新增单表数据
    int save(Map<String,Object> map, String tableName);
    //根据guid批量修改单表字段
    int updateOne(Map<String,Object> map, String tableName,String guids);

    //根据guid批量删除单表数据
    int deleteOne(String tableName,String guids);

    List<Map<String,Object>> findById(String tableName,String guid);

    List<Map<String,Object>> findAll(String tableName,Map<String,Object> map);
    //一对多新增
    int executeAdds(ObjResult objResult);
    //一对多修改
    int executeUpdates(ObjResult objResult);
    //一对多查询
    ObjResult getOneAll(ObjResult objResult);
    //一对多删除
    int deletes(ObjResult objResult);
}
