package com.jason.util;

/**
 * @Auther: Jason
 * @Date: 2020/1/2 17:18
 * @Description:
 */
public class StringUtil {

    public static boolean isBlank(String str){
        return null == str || 0 == str.trim().length();
    }

    public static boolean isNotBlank(String str){
        return !isBlank(str);
    }

    public static boolean isNumeric(String str){
        if(isBlank(str)){
            return false;
        }
        int length = str.length();

        for(int i = 0;i < length; ++i){
            if(!Character.isDigit(str.charAt(i))){
               return false;
            }
        }
        return true;
    }
}
