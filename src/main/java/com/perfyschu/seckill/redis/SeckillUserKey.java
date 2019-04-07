package com.perfyschu.seckill.redis;

/**
 * 文件名：SeckillUserKey.java
 * 创建日期：2019/4/7 20:53
 * 说明：
 *
 * @author PerfySchu
 */
public class SeckillUserKey extends BasePrefix{

    public static final int TOKEN_EXPIRE = 3600*24*2;

    private SeckillUserKey(int expireSeconds,String prefix){
        super(expireSeconds, prefix);

    }

    public static SeckillUserKey token = new SeckillUserKey(TOKEN_EXPIRE,"tk");
}
