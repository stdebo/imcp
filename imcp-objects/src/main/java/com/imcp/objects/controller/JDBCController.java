package com.imcp.objects.controller;

        import com.imcp.objects.service.JDBCService;
        import com.imcp.objects.util.StringUtil;
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

    //新增单表数据
    @RequestMapping("/add")
    public int add(@RequestParam Map<String, Object> map){
        if (map.isEmpty()){
            return 0;
        }
        String tableName = (String) map.get("tableName");
        map.remove("tableName");
        return jdbcService.save(map,tableName);
    }

    //根据guid修改单表
    @RequestMapping("/updateOne")
    public int updateOne(@RequestParam Map<String, Object> map){
        if (map.isEmpty()){
            return 0;
        }
        String guid = (String)map.get("guid"),tableName = (String)map.get("tableName");
        map.remove("guid");map.remove("tableName");
        return jdbcService.updateOne(map,tableName,guid);
    }

    //根据guid删除单表
    @RequestMapping("/deleteOne")
    public int deleteOne(String tableName,@RequestParam String guids){
        if (StringUtil.isEmpty(tableName) || StringUtil.isEmpty(guids)){
            return 0;
        }
        return jdbcService.deleteOne(tableName,guids);
    }

    //根据guid和tableName查询单条数据
    @RequestMapping("/getAllOne")
    public Object getAllOne(String tableName, String guid){
        if (StringUtil.isEmpty(tableName) || StringUtil.isEmpty(guid)){
            return null;
        }
        return jdbcService.findById(tableName,guid);
    }
    //根据where和tableName查询数据
    @RequestMapping("/getAllList")
    public Object getAllList(@RequestParam Map<String, Object> map){
        if (StringUtil.isEmpty((String) map.get("tableName"))){
            return null;
        }
        String tableName = (String) map.get("tableName");
        map.remove("tableName");
        return jdbcService.findAll(tableName,map);
    }
}
