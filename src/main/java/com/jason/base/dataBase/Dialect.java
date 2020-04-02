package com.jason.base.dataBase;

/**
 * @Auther: Jason
 * @Date: 2020/1/7 08:51
 * @Description:
 * 数据库方言
 */
public interface Dialect {

    /**
    * @author Jason
    * @date 2020/1/7 8:53
    * @params []
    * @return boolean
    * 数据库是否支持分页
    */
    public boolean supportsLimit();

    /**
     * 将sql转化为分页sql
     * @param sql
     * @param limit
     * @param count
     * @return 分页查询的sql
     */
    public String getLimitString(String sql,int limit,int count);
}
