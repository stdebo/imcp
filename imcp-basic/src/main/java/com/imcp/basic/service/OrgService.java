package com.imcp.basic.service;

import com.imcp.basic.bean.Org;

import java.util.List;

public interface OrgService {
    //新增组织
    public int addOrg(Org org);
    //修改组织
    public int updateOrg(Org org);
    //删除组织
    public int delOrg(String id);
    //查询子级组织列表
    public List<Org> getChildOrg(String parent);
}
