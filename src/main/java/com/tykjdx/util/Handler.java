package com.tykjdx.util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author 谭玥珩
 * @Date 2021/3/18 20:51
 * @Version 1.8
 * @简介：
 */
public class Handler implements InvocationHandler {
    Object target;

    public Handler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj = null;
        SqlSession sqlSession = null;
        try {
            obj = method.invoke(target, args);
            sqlSession = SqlSessionUtil.getSqlSession();
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
        } finally {
            SqlSessionUtil.myClose(sqlSession);
        }
        return obj;
    }

    //获取代理对象
    public Object getProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }
}
