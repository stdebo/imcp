package com.imcp.objects.bean;

import lombok.Data;

/**
 * 附件类
 */
@Data
public class ObjFile {
    //附件id
    private String id;
    //附件guid
    private String guid;
    //附件名称
    private String fileName;
    //附件后缀名
    private String fileSuffix;
    //附件路径
    private String filePath;
    //关联id
    private String msgId;
    //创建时间
    private String createDate;
    //关联字段
    private String fieldName;
}
