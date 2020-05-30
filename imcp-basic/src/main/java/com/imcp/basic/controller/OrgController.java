package com.imcp.basic.controller;

import com.imcp.basic.bean.Org;
import com.imcp.basic.bean.Role;
import com.imcp.basic.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Org")
public class OrgController {
    @Autowired
    private OrgService orgService;
    /**
     * 新增组织
     * @param org
     * @return
     */
    @RequestMapping("/addOrg")
    public int addOrg(Org org){
        return orgService.addOrg(org);
    }

    /**
     * 修改组织
     * @param org
     * @return
     */
    @RequestMapping("/updateOrg")
    public int updateOrg(Org org){
        return orgService.updateOrg(org);
    }

    /**
     * 删除组织
     * @param id
     * @return
     */
    @RequestMapping("/delOrg")
    public int delOrg(String id){
        return orgService.delOrg(id);
    }

    /**
     * 查询所有组织
     * @return
     */
    @RequestMapping("/getChildOrg")
    public List<Org> getChildOrg(String parent){
        return orgService.getChildOrg(parent);
    }
}
