package com.tykjdx.util;

/**
 * @Author 谭玥珩
 * @Date 2021/3/18 21:55
 * @Version 1.8
 * @简介：
 */
public class ServiceFactory {
    public Object getService(Object service) {
        //通过实例对象获得代理类对象
        return new Handler(service).getProxy();
    }
}
