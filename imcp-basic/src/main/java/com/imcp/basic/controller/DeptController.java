package com.imcp.basic.controller;

import com.imcp.basic.bean.Dept;
import com.imcp.basic.bean.Org;
import com.imcp.basic.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;
    /**
     * 新增部门
     * @param dept
     * @return
     */
    @RequestMapping("/addDept")
    public int addOrg(Dept dept){
        return deptService.addDept(dept);
    }

    /**
     * 修改部门
     * @param dept
     * @return
     */
    @RequestMapping("/updateDept")
    public int updateOrg(Dept dept){
        return deptService.updateDept(dept);
    }

    /**
     * 删除部门
     * @param id
     * @return
     */
    @RequestMapping("/delDept")
    public int delOrg(String id){
        return deptService.delDept(id);
    }

    /**
     * 查询所有部门
     * @return
     */
    @RequestMapping("/getAllDept")
    public List<Dept> getAllDept(){
        return deptService.getAllDept();
    }

    /**
     * 查询所有子级部门
     * @return
     */
    @RequestMapping("/getChildDept")
    public List<Dept> getChildDept(String parent){
        return deptService.getChildDept(parent);
    }
}
