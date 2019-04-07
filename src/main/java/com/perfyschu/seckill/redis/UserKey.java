package com.perfyschu.seckill.redis;

/**
 * 文件名：UserKey.java
 * 创建日期：2019/4/5 18:03
 * 说明：
 *
 * @author PerfySchu
 */
public class UserKey extends BasePrefix {

    private UserKey(String prefix){
        super(prefix);
    }

    public static UserKey getById = new UserKey("id");
    public static UserKey getByName = new UserKey("name");
}
