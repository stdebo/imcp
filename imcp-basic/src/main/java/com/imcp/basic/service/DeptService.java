package com.imcp.basic.service;

import com.imcp.basic.bean.Dept;

import java.util.List;

public interface DeptService {
    //新增部门
    public int addDept(Dept dept);
    //修改部门
    public int updateDept(Dept dept);
    //删除部门
    public int delDept(String id);
    //查询下级部门
    public List<Dept> getChildDept(String parent,String deptName);
    //查询所有部门
    public List<Dept> getAllDept();
}
