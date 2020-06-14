package com.imcp.objects.util;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 判断List1是否包含list2
     * @param actualList
     * @param expectList
     * @return
     */
    public static boolean containsList(List<Object> actualList, List<Object> expectList){
        if(actualList.containsAll(expectList)){
            return true;
        } else{
            return false;
        }
    }
}
