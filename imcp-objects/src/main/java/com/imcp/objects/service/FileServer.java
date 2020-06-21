package com.imcp.objects.service;

import com.imcp.objects.bean.ObjFile;
import org.springframework.stereotype.Component;

import java.util.List;

public interface FileServer {

    /**
     * 新增附件
     * @param objFile
     * @return
     */
    int addFile(ObjFile objFile);

    /**
     *  通过MSGID删除附件信息
     *  @param: guid
     *  @param: Integer
     *  @return
     */
    int deleteByMsgId(String msgId);

    /**
     *  通过MSGID查找附件
     *  @param: msgId
     *  @param: List
     *  @return
     */
    List<ObjFile> getByMsgidList(String msgId);

    /**
     *  通过FILE_NAME删除附件信息
     *  @param: guid
     *  @param: Integer
     *  @return
     */
    int deleteByFileName(String fileName);
}
