package com.imcp.objects.service.impl;

import com.imcp.objects.mapper.JDBCMapper;
import com.imcp.objects.service.JDBCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.List;

@Component
public class JDBCServiceImpl implements JDBCService {
    @Autowired
    private JDBCMapper jdbcMapper;
    @Override
    public int save(String sql, String dataBase, Object... obj) {
        System.out.println("12345");
        return jdbcMapper.executeUpdate(sql,dataBase,obj);
    }

    @Override
    public int delete() {
        return 0;
    }

    @Override
    public int update() {
        return 0;
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
