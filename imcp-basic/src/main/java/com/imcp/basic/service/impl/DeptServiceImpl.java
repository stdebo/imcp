package com.imcp.basic.service.impl;

import com.imcp.basic.bean.Dept;
import com.imcp.basic.mapper.DeptMapper;
import com.imcp.basic.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public int addDept(Dept dept) {
        return deptMapper.insert(dept);
    }

    @Override
    public int updateDept(Dept dept) {
        return deptMapper.updateByPrimaryKey(dept);
    }

    @Override
    public int delDept(String id) {
        return deptMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Dept> getChildDept(String parent,String deptName) {
        return deptMapper.getClildDept(parent,deptName);
    }

    @Override
    public List<Dept> getAllDept() {
        return deptMapper.selectAll();
    }
}
