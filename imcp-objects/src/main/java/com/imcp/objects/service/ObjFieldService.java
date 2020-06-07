package com.imcp.objects.service;

import com.imcp.objects.bean.ObjField;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface ObjFieldService {
    //新增
    public int addObjField(ObjField objField);
    //修改
    public int updateObjField(ObjField objField,@Param("example") Object example);
    //查询
    public List<ObjField> getAll(@Param("example") Object example, RowBounds rowBounds);
    //删除
    public int delObjField(@Param("example") Object example);
}
