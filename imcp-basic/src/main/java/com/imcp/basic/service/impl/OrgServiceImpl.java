package com.imcp.basic.service.impl;

import com.imcp.basic.bean.Org;
import com.imcp.basic.mapper.OrgMapper;
import com.imcp.basic.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrgServiceImpl implements OrgService {
    @Autowired
    private OrgMapper orgMapper;

    @Override
    public int addOrg(Org org) {
        return orgMapper.insert(org);
    }

    @Override
    public int updateOrg(Org org) {
        return orgMapper.updateByPrimaryKey(org);
    }

    @Override
    public int delOrg(String id) {
        return orgMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Org> getChildOrg(String parent,String orgName) {
        return orgMapper.getChildOrg(parent,orgName);
    }
}
