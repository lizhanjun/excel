package com.jason.base.dataBase;

/**
 * @Auther: Jason
 * @Date: 2020/1/7 10:08
 * @Description:
 */
public class MysqlDialect implements Dialect{


    @Override
    public boolean supportsLimit() {
        return true;
    }

    @Override
    public String getLimitString(String sql, int limit, int count) {
        StringBuilder stringBuilder = new StringBuilder(sql);
        stringBuilder.append(" limit ");
        if(limit > 0 ){
            stringBuilder.append(limit).append(",").append(count);
        }else{
            stringBuilder.append(count);
        }
        return stringBuilder.toString();
    }
}
