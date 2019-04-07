package com.perfyschu.seckill.redis;

/**
 * 文件名：KeyPrefix.java
 * 创建日期：2019/4/5 17:57
 * 说明：
 *
 * @author PerfySchu
 */
public interface KeyPrefix {
    int expireSeconds();

    String getPrefix();
}
