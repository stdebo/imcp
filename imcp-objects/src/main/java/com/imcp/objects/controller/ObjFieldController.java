package com.imcp.objects.controller;

import com.imcp.objects.bean.ObjBase;
import com.imcp.objects.bean.ObjField;
import com.imcp.objects.service.ObjFieldService;
import com.imcp.objects.util.IdUtil;
import com.imcp.objects.util.StringUtil;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ObjField")
public class ObjFieldController {
    @Autowired
    private ObjFieldService objFieldService;

    @RequestMapping("/getAll")
    public List<ObjField> getAll(ObjField objField, Integer pageSize, Integer pageNum){
        Example example = new Example(ObjField.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("fieldViewName","%"+objField.getFieldViewName()+"%")
                .andLike("fieldName","%"+objField.getFieldName()+"%");
        RowBounds rowBounds= new RowBounds(pageNum,pageSize);
        return objFieldService.getAll(example,rowBounds);
    }

    @RequestMapping("/addUpdateObjField")
    public int addUpdateObjField(ObjField objField){
        if(StringUtil.isEmpty(objField.getGuid())){
            objField.setGuid(IdUtil.getUID());
            return objFieldService.addObjField(objField);
        }else {
            Example example = new Example(ObjField.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("guid",objField.getGuid());
            return objFieldService.updateObjField(objField,example);
        }
    }
    @RequestMapping("/delObjField")
    public int delObjField(String guid){
        Example example = new Example(ObjField.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("guid",guid);
        return objFieldService.delObjField(example);
    }
}
