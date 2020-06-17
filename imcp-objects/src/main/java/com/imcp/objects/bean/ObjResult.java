package com.imcp.objects.bean;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 封装结果类
 */
@Data
public class ObjResult {
    //状态
    private int status;
    //消息
    private String msg;
    //Object类型的data
    private Object data;
    //Object类型的data
    private Object dataB;
    //
    private Object datac;
    //Object类型的data
    private Set<Object> set;
    //
    private List<Object> dataList;
    //
    private List<List> fileList;
    //
    private List<Map<String,Object>> dataMap;
}
