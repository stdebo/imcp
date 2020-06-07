package com.imcp.objects.service.impl;
import com.imcp.objects.bean.ObjBase;
import com.imcp.objects.mapper.ObjBaseMapper;
import com.imcp.objects.service.ObjBaseService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ObjBaseServiceImpl implements ObjBaseService {
    @Autowired
    private ObjBaseMapper objBaseMapper;


    @Override
    public int addObjBase(ObjBase objBase) {
        return objBaseMapper.insertSelective(objBase);
    }

    @Override
    public int updateObjBase(ObjBase objBase,@Param("example") Object example) {
        return objBaseMapper.updateByExampleSelective(objBase,example);
}

    @Override
    public int delObjBase(Object example) {
        return objBaseMapper.deleteByExample(example);
    }


    @Override
    public List getAllList(ObjBase objBase) {
        return objBaseMapper.selectAllObj(objBase);
    }

    @Override
    public List getAll() {
        return objBaseMapper.selectAll();
    }


}
