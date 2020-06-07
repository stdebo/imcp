package com.imcp.objects.mapper;



import com.imcp.objects.bean.ObjBase;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ObjBaseMapper extends Mapper<ObjBase> {
    //根据数据对象名和数据对象物理名查询
    public List<ObjBase> selectAllObj(ObjBase objBase);
}