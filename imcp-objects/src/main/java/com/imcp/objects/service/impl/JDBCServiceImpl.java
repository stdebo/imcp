package com.imcp.objects.service.impl;

import com.imcp.objects.mapper.JDBCMapper;
import com.imcp.objects.service.JDBCService;
import com.imcp.objects.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class JDBCServiceImpl implements JDBCService {
    @Autowired
    @Qualifier("JDBCMapperImpl")
    private JDBCMapper jdbcMapper;

    @Override
    public int save(String sql, List<Object> list) {
        return jdbcMapper.executeUpdate(sql,list);
    }

    @Override
    public int updateOne(Map<String,Object> map, String tableName,String guid) {
        String sql ="update "+tableName+" set ";
        String whereAll = " where 1=1 and guid = ?";
        List<Object> list = new ArrayList<Object>();
        for(Map.Entry<String, Object> entry:map.entrySet()){
            sql +=entry.getKey()+"=?,";
            list.add(entry.getValue());
        }
        list.add(guid);
        sql =sql.substring(0,sql.length()-1)+whereAll;
        return jdbcMapper.executeUpdate(sql,list);
    }

    @Override
    public int updateAll() {
        return 0;
    }

    @Override
    public int deleteOne(String tableName, List<Object> guids) {
        String sql ="delete from "+tableName+" wgere guid in( ?";
        for(int i = 0;i<guids.size();i++){
            sql += "?,";
        }
        sql = sql.substring(0,sql.length()-1)+")";
        return jdbcMapper.executeUpdate(sql,guids);
    }

    @Override
    public ResultSet findById() {
        return null;
    }

    @Override
    public ResultSet findAll() {
        return null;
    }
}
