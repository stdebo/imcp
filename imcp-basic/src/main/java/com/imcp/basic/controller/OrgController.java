package com.imcp.basic.controller;

import com.imcp.basic.bean.Org;
import com.imcp.basic.service.OrgService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Org")
public class OrgController {
    @Autowired
    private OrgService orgService;

    @ApiOperation(value = "新增组织")
    @ApiImplicitParam(name = "org", value = "Org", paramType = "query", required = true, dataType = "String")
    @RequestMapping("/addOrg")
    public int addOrg(Org org){
        return orgService.addOrg(org);
    }

    @ApiOperation(value = "修改组织")
    @ApiImplicitParam(name = "org", value = "Org", paramType = "query", required = true, dataType = "String")
    @RequestMapping("/updateOrg")
    public int updateOrg(Org org){
        return orgService.updateOrg(org);
    }

    @ApiOperation(value = "删除组织")
    @ApiImplicitParam(name = "id", value = "组织id", paramType = "query", required = true, dataType = "String")
    @RequestMapping("/delOrg")
    public int delOrg(String id){
        return orgService.delOrg(id);
    }

    @ApiOperation(value = "查询下级组织列表")
    @ApiImplicitParam(name = "parent", value = "组织父级id", paramType = "query", required = true, dataType = "String")
    @RequestMapping("/getChildOrg")
    public List<Org> getChildOrg(String parent,String orgName){
        return orgService.getChildOrg(parent,orgName);
    }
}
