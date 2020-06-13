package com.imcp.objects.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imcp.objects.bean.ObjBase;
import com.imcp.objects.service.ObjBaseService;
import com.imcp.objects.util.IdUtil;
import com.imcp.objects.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ObjBase")
public class ObjBaseController {
    @Autowired
    private ObjBaseService objBaseService;

    @RequestMapping("/getAll")
    public List getAll(){
        return objBaseService.getAll();
    }

    @RequestMapping("/selectAll")
    public Object selectAll(@RequestParam Map<String,String> map){
        Integer pageSize = Integer.parseInt(map.get("pageSize"));
        Integer pageNum = Integer.parseInt(map.get("pageNum"));
        PageHelper.startPage(pageNum,pageSize);
        ObjBase objBase = new ObjBase();
        objBase.setObjName(map.get("objNames"));
        List<ObjBase> list = objBaseService.getAllList(objBase);
        PageInfo<ObjBase> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
    @RequestMapping("/addUpdateObjBase")
    public int addObjBase(ObjBase objBase){
        if(StringUtil.isEmpty(objBase.getGuid())){
            objBase.setGuid(IdUtil.getUID());
            return objBaseService.addObjBase(objBase);
        }else{
            Example example = new Example(ObjBase.class);
            // 创建Criteria
            Example.Criteria criteria = example.createCriteria();
            // 添加条件
            criteria.andEqualTo("guid",objBase.getGuid());
            return objBaseService.updateObjBase(objBase,example);
        }
    }
    @RequestMapping("/delObjBase")
    public int delObjBase(String guid){
        Example example = new Example(ObjBase.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("guid",guid);
        return objBaseService.delObjBase(example);
    }
}
