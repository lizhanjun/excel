package com.jason.common;

import com.jason.base.BaseEntity;
import com.jason.base.PropertiesLoader;
import com.jason.base.dataBase.Dialect;
import com.jason.base.Page;
import com.jason.base.dataBase.MysqlDialect;
import com.jason.base.dataBase.OrcaleDialect;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.plugin.Interceptor;

import java.io.Serializable;

/**
 * @Auther: Jason
 * @Date: 2020/1/3 14:55
 * @Description:
 */
public abstract class BaseInterceptor implements Interceptor, Serializable {

    protected Log log = LogFactory.getLog(getClass());
    protected Dialect Dialect;


    protected static Page convertParameter(Object parameterObjcet){
        try {
            if(parameterObjcet instanceof Page){
                return (Page) parameterObjcet;
            }else if(parameterObjcet instanceof BaseEntity){
                return ((BaseEntity) parameterObjcet).getPage();
            }else {
                return null;
            }
        }catch (Exception e){
            return null;
        }
    }

    protected void initProperties(){
        String type = PropertiesLoader.getProperty("jdbc.type");
        if("oracle".equals(type)){
            Dialect = new OrcaleDialect();
        }else if("mysql".equals(type)){
            Dialect = new MysqlDialect();
        }
    }
}
