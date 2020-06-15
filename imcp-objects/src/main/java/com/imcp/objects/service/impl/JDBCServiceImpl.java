package com.imcp.objects.service.impl;

import com.imcp.objects.mapper.JDBCMapper;
import com.imcp.objects.service.JDBCService;
import com.imcp.objects.util.IdUtil;
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
    public int save(Map<String,Object> map, String tableName) {
        String sql ="insert into "+tableName+" (guid,";
        List<Object> list = new ArrayList<Object>();
        list.add(IdUtil.getUID());
        String value="?,";
        for(Map.Entry<String, Object> entry:map.entrySet()){
            sql +=entry.getKey()+",";
            list.add(entry.getValue());
            value +="?,";
        }
        value = value.substring(0,value.length()-1);
        sql =sql.substring(0,sql.length()-1)+") values("+value+")";
        return jdbcMapper.executeUpdate(sql,list);
    }

    @Override
    public int updateOne(Map<String,Object> map, String tableName,String guid) {
        String sql ="update "+tableName+" set ";
        String whereAll = " where 1=1 and guid in (";
        List<Object> list = new ArrayList<Object>();
        for(Map.Entry<String, Object> entry:map.entrySet()){
            sql +=entry.getKey()+"=?,";
            list.add(entry.getValue());
        }
        String[] guids=guid.split(",");
        for(int i=0;i<guids.length;i++){
            whereAll += "?,";
            list.add(guids[i]);
        }
        sql =sql.substring(0,sql.length()-1)+whereAll.substring(0,whereAll.length()-1)+")";
        return jdbcMapper.executeUpdate(sql,list);
    }


    @Override
    public int deleteOne(String tableName, String guids) {
        String sql ="delete from "+tableName+" where guid in(";
        String[] guid = guids.split(",");
        List<Object> list = new ArrayList<Object>();
        for(int i = 0;i<guid.length;i++){
            sql += "?,";
            list.add(guid[i]);
        }
        sql = sql.substring(0,sql.length()-1)+")";
        return jdbcMapper.executeDelete(sql,list);
    }

    @Override
    public List<Map<String,Object>> findById(String tableName, String guid) {
        String sql ="select * from "+tableName+" where guid =?";
        return jdbcMapper.executeQuery(sql,guid);
    }

    @Override
    public List<Map<String, Object>> findAll(String tableName, Map<String,Object> map) {
        String sql ="select * from "+tableName+" where 1=1 ";
        List<Object> list = new ArrayList<Object>();
        for(Map.Entry<String, Object> entry:map.entrySet()){
            String value = (String) entry.getValue();
            if(StringUtil.isEmpty(value)){
                continue;
            } else if(value.toUpperCase().equals("IS NULL")){
                sql+=" and "+entry.getKey()+" IS NULL";
                continue;
            } else if(value.toUpperCase().equals("IS NOT NULL")){
                sql+=" and "+entry.getKey()+" IS NOT NULL";
                continue;
            }else{
                sql+=" and "+entry.getKey()+"=?";
            }
            list.add(entry.getValue());
        }
        return jdbcMapper.executeQueryAll(sql,list);
    }
}
