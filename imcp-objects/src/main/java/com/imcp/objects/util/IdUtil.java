package com.imcp.objects.util;

import java.util.UUID;

public class IdUtil {

    /**
     * 获取guid
     * @return
     */
    public static String getUID(){
        String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        return uuid;
    }
}