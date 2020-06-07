package com.imcp.objects.service;


import com.imcp.objects.bean.ObjBase;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ObjBaseService {
    //新增
    public int addObjBase(ObjBase objBase);
    //修改
    public int updateObjBase(ObjBase objBase,@Param("example") Object example);
    //删除
    public int delObjBase(@Param("example") Object example);
    //查询
    public List getAllList(ObjBase objBase);
    public List getAll();
}
