package com.jason.common;

import com.jason.base.dataBase.Dialect;
import com.jason.base.Page;
import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Auther: Jason
 * @Date: 2020/1/3 16:00
 * @Description:
 */
public class SQLHelper {

    private static void setParameters(PreparedStatement ps,MappedStatement mappedStatement,BoundSql boundSql,
                                      Object parameterObject) throws SQLException {
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        if(null != parameterMappings){
            Configuration configuration = mappedStatement.getConfiguration();
            TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
            MetaObject metaObject = parameterObject == null ? null : configuration.newMetaObject(parameterObject);
            for(int i = 0;i < parameterMappings.size(); i++){
                ParameterMapping parameterMapping = parameterMappings.get(i);
                if(parameterMapping.getMode() != ParameterMode.OUT){
                    Object value;
                    String property = parameterMapping.getProperty();
                    PropertyTokenizer prop = new PropertyTokenizer(property);
                    if(parameterObject == null){
                        value = null;
                    }else if(typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())){
                        value = parameterObject;
                    }else if(boundSql.hasAdditionalParameter(property)){
                        value = boundSql.getAdditionalParameter(property);
                    }else if(property.startsWith(ForEachSqlNode.ITEM_PREFIX) &&
                            boundSql.hasAdditionalParameter(prop.getName())){
                        value = boundSql.getAdditionalParameter(prop.getName());
                        if(value != null){
                            value = configuration.newMetaObject(value).
                                    getValue(property.substring(prop.getName().length()));
                        }
                    }else {
                        value = metaObject == null ? null : metaObject.getValue(property);
                    }
                    TypeHandler typeHandler = parameterMapping.getTypeHandler();
                    if(null == typeHandler){
                        throw new ExecutorException("There is no TypeHandler found for parameter " + property + "of statement " + mappedStatement.getId());
                    }
                    typeHandler.setParameter(ps,i + 1,value,parameterMapping.getJdbcType());
                }
            }
        }
    }

    public static int getCount(final String sql, final Connection connection,
                               final MappedStatement mappedStatement, final Object parameterObject,
                               final BoundSql boundSql, Log log) throws SQLException{
        final String countSql = "select count(1) from(" + sql + ") tem_count";
        Connection conn = connection;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            if(log.isDebugEnabled()){
                log.debug("COUNT SQL: " + countSql);
            }
            if(null == conn){
               conn = mappedStatement.getConfiguration().getEnvironment().getDataSource().getConnection();
            }
            ps = conn.prepareStatement(countSql);
            BoundSql countBs = new BoundSql(mappedStatement.getConfiguration(),countSql,
                    boundSql.getParameterMappings(),parameterObject);

            SQLHelper.setParameters(ps,mappedStatement,countBs,parameterObject);
            rs = ps.executeQuery();
            int count = 0;
            if(rs.next()){
                count = rs.getInt(1);
            }
            return count;
        } finally {
            try {
                if(rs != null){
                    rs.close();
                }
                if(ps != null){
                    ps.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    public static String generatePageSal(String sql, Page page, Dialect dialect){
        if(dialect.supportsLimit()){
            int end = page.getLimitNum();
            int length = page.getPageSize();
            return dialect.getLimitString(sql,end,length);
        }else{
            return sql;
        }

    }


}
