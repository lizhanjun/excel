package com.jason.common;

import com.jason.base.Page;
import com.jason.util.StringUtil;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * @Auther: Jason
 * @Date: 2020/1/3 13:30
 * @Description:
 */
@Intercepts({@Signature(type = Executor.class,method = "query"
        ,args = {MappedStatement.class,Object.class, RowBounds.class, ResultHandler.class})})
public class SQLInterceptor extends BaseInterceptor{
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        MappedStatement mappedStatement = (MappedStatement) args[0];
        Object parameter = args[1];
        BoundSql boundSql = mappedStatement.getBoundSql(parameter);
        Object parameterObject = boundSql.getParameterObject();
        System.out.println(3);
        Page page = null;
        if(null != parameterObject){
            page = convertParameter(parameterObject);
        }

        if(null != page && page.getPageSize() > 0){
            if(StringUtil.isBlank(boundSql.getSql())){
                return null;
            }
            String sql = boundSql.getSql().trim();
            page.setCount(SQLHelper.getCount(sql,null,mappedStatement,
                    parameterObject,boundSql,log));

            String pageSlq = SQLHelper.generatePageSal(sql,page,Dialect);
            invocation.getArgs()[2] = new RowBounds(RowBounds.NO_ROW_OFFSET, RowBounds.NO_ROW_LIMIT);
            BoundSql newBoundSql = new BoundSql(mappedStatement.getConfiguration(),
                    pageSlq,boundSql.getParameterMappings(),boundSql.getParameterObject());

            MappedStatement newMs = copyFromMappedStatement(mappedStatement, new BoundSqlSource(newBoundSql));

            invocation.getArgs()[0] = newMs;
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        System.out.println(1);
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println(2);
        super.initProperties();
    }

    private MappedStatement copyFromMappedStatement(MappedStatement ms, SqlSource newSqlSource){
        MappedStatement.Builder builder = new MappedStatement.Builder(
                ms.getConfiguration(), ms.getId(), newSqlSource, ms.getSqlCommandType());
        builder.resource(ms.getResource());
        builder.fetchSize(ms.getFetchSize());
        builder.statementType(ms.getStatementType());
        builder.keyGenerator(ms.getKeyGenerator());
        if(ms.getKeyProperties() != null){
            for(String key : ms.getKeyProperties()){
                builder.keyProperty(key);
            }
        }
        builder.timeout(ms.getTimeout());
        builder.parameterMap(ms.getParameterMap());
        builder.resultMaps(ms.getResultMaps());
        builder.cache(ms.getCache());
        builder.useCache(ms.isUseCache());
        return builder.build();
    }


    public static class BoundSqlSource implements SqlSource{
        BoundSql boundSql;

        public BoundSqlSource(BoundSql boundSql){
            this.boundSql = boundSql;
        }

        @Override
        public BoundSql getBoundSql(Object o) {
            return boundSql;
        }
    }
}
