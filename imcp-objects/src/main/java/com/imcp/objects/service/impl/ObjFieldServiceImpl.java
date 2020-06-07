package com.imcp.objects.service.impl;

import com.imcp.objects.bean.ObjField;
import com.imcp.objects.mapper.ObjFieldMapper;
import com.imcp.objects.service.ObjFieldService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ObjFieldServiceImpl implements ObjFieldService {
    @Autowired
    private ObjFieldMapper objFieldMapper;
    @Override
    public int addObjField(ObjField objField) {
        return objFieldMapper.insert(objField);
    }

    @Override
    public int updateObjField(ObjField objField, Object example) {
        return objFieldMapper.updateByExampleSelective(objField,example);
    }

    @Override
    public List<ObjField> getAll(Object example, RowBounds rowBounds) {
        return objFieldMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    @Override
    public int delObjField(Object example) {
        return objFieldMapper.deleteByExample(example);
    }
}
