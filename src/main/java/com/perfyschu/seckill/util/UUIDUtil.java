package com.perfyschu.seckill.util;

import java.util.UUID;

/**
 * 文件名：UUIDUtil.java
 * 创建日期：2019/4/7 20:50
 * 说明：
 *
 * @author PerfySchu
 */
public class UUIDUtil {

    public static String uuid(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
