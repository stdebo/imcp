package com.imcp.objects.controller;

import com.imcp.objects.service.JDBCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jdbc")
public class JDBCController {
    @Autowired
    private JDBCService jdbcService;
    @RequestMapping("/add")
    public int add(@RequestParam Map<String, String> map){
        if (map.isEmpty()){
            return 0;
        }
        String dataBase = map.get("dataBase");
        String tableName = map.get("tableName");
        String sql ="insert into "+tableName+" (";
        List<Object> list = new ArrayList<Object>();
        String value="";
        map.remove("dataBase");map.remove("tableName");
        for(Map.Entry<String, String> entry:map.entrySet()){
            sql +=entry.getKey()+",";
            list.add(entry.getValue());
            value +="?,";
        }
        value = value.substring(0,value.length()-1);
        sql =sql.substring(0,sql.length()-1)+") values("+value+")";
        return jdbcService.save(sql,dataBase,list);
    }
}
