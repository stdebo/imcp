package com.imcp.objects.service;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public interface JDBCService {
    //新增单表数据
    int save(String sql ,List<Object> list);
    //根据guid修改单表字段
    int updateOne(Map<String,Object> map, String tableName,String where);

    int updateAll();
    //根据guid删除单表数据
    int deleteOne(String tableName,List<Object> guids);

    ResultSet findById();

    ResultSet findAll();
}
