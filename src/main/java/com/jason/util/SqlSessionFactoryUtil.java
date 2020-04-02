package com.jason.util;

import com.jason.constant.ConfigureConstant;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @Auther: Jason
 * @Date: 2019/12/30 13:41
 * @Description:
 */
public class SqlSessionFactoryUtil {

    private static SqlSession sqlSession;

    static {
        String resource = ConfigureConstant.MYBATIS_CONFIG;
        try {
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = sessionFactory.openSession(true);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession(){
        return sqlSession;
    }

    public static <T> T getMapper(Class<T> t){
        return sqlSession.getMapper(t);
    }

    public static void commit(){
        sqlSession.commit();
    }
}
