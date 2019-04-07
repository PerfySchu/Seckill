package com.perfyschu.seckill.redis;

/**
 * 文件名：OrderKey.java
 * 创建日期：2019/4/5 18:04
 * 说明：
 *
 * @author PerfySchu
 */
public class OrderKey extends BasePrefix {

    public OrderKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
}
