package com.imcp.basic.mapper;

import com.imcp.basic.bean.Dept;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DeptMapper extends Mapper<Dept> {
    public List<Dept> getClildDept(String parent,String deptName);
}
