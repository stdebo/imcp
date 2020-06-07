package com.imcp.objects.util;

public class StringUtil {
    /**
     * 判断是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        if(str==null || str.trim().equals("")){
            return true;
        }
        return false;
    }
}
