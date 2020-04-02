package com.jason.util;

import java.util.UUID;

/**
 * @Auther: Jason
 * @Date: 2020/1/1 17:25
 * @Description:
 */
public class IDUtils {

    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
