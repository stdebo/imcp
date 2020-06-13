package com.imcp.objects.service;

import java.sql.ResultSet;
import java.util.List;

public interface JDBCService {

    int save(String sql,String dataBase,Object...obj);

    int delete();

    int update();

    ResultSet findById();

    ResultSet findAll();
}
