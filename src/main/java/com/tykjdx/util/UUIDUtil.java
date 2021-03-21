package com.tykjdx.util;

import java.util.UUID;

/**
 * @Author 谭玥珩
 * @Date 2021/3/18 21:03
 * @Version 1.8
 * @简介：
 */
public class UUIDUtil {
    public String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
