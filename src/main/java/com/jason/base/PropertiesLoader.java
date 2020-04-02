package com.jason.base;

import java.util.NoSuchElementException;
import java.util.ResourceBundle;

/**
 * @Auther: Jason
 * @Date: 2020/1/7 09:22
 * @Description:
 */
public class PropertiesLoader {

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("config");


    private static String getValue(String key){
        String systemProperty = System.getProperty(key);
        if(null != systemProperty){
            return  systemProperty;
        }
        if(resourceBundle.containsKey(key)){
            return resourceBundle.getString(key);
        }
        return "";
    }

    public static String getProperty(String key){
        String value = getValue(key);
        if(null == value){
            throw new NoSuchElementException();
        }
        return value;
    }
}
