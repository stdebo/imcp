package com.imcp.objects.service.impl;

import com.imcp.objects.bean.ObjFile;
import com.imcp.objects.mapper.FileMapper;
import com.imcp.objects.service.FileServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FileServerImpl implements FileServer {
    @Autowired
    private FileMapper fileMapper;

    @Override
    public int addFile(ObjFile objFile) {
        return fileMapper.insert(objFile);
    }

    @Override
    public int deleteByMsgId(String msgId) {
        return fileMapper.deleteByExample(msgId);
    }

    @Override
    public List<ObjFile> getByMsgidList(String msgId) {
        return fileMapper.selectByExample(msgId);
    }

    @Override
    public int deleteByFileName(String fileName) {
        return fileMapper.deleteByExample(fileName);
    }
}
