package com.tykjdx.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author 谭玥珩
 * @Date 2021/3/18 19:28
 * @Version 1.8
 * @简介：
 */
public class SqlSessionUtil {
    private static SqlSessionFactory factory;
    static {
        {
            try {
                String resource = "mybatis-config.xml";
                InputStream in = Resources.getResourceAsStream(resource);
                SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
                //工厂模式只需要加载一次即可，所以写在Static中
                factory = builder.build(in);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //创建一个本地线程t
    private static ThreadLocal<SqlSession> t = new ThreadLocal<>();

    public static SqlSession getSqlSession(){
        SqlSession sqlSession = t.get();
        if (sqlSession==null){
            //设置为自动提交事务
            sqlSession=factory.openSession(true);
            t.set(sqlSession);
        }
        return sqlSession;
    }

    public static void myClose(SqlSession sqlSession){
        if (sqlSession!=null){
            sqlSession.close();
            //将线程池中sqlSession剔除掉
            t.remove();
        }
    }
}
