package com.jason.base.dataBase;

/**
 * @Auther: Jason
 * @Date: 2020/1/7 08:56
 * @Description:
 */
public class OrcaleDialect implements Dialect {

    @Override
    public boolean supportsLimit() {
        return true;
    }

    @Override
    public String getLimitString(String sql, int limit, int count) {
        StringBuilder pageSql = new StringBuilder(sql.length() + 100);
        if(limit > 0){
            pageSql.append("select * from ( select row_.*, rownum rownum_ from ( ");
        }else{
            pageSql.append("select * from ( ");
        }
        pageSql.append(sql);
        if(limit > 0){
            pageSql.append(" ) row_ where rownum <= " + (limit + count) +" ) where rownum_ > ").append(limit);
        }else{
            pageSql.append(" ) where rownum <= " + count);
        }
        return pageSql.toString();
    }
}
