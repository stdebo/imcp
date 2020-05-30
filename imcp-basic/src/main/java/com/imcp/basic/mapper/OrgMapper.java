package com.imcp.basic.mapper;

import com.imcp.basic.bean.Org;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface OrgMapper extends Mapper<Org> {
    //查询下级组织
    public List<Org> getChildOrg(String parent);
}
