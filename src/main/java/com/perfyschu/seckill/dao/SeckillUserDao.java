package com.perfyschu.seckill.dao;

import com.perfyschu.seckill.domain.SeckillUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 文件名：SeckillUserDao.java
 * 创建日期：2019/4/7 12:18
 * 说明：
 *
 * @author PerfySchu
 */
public interface SeckillUserDao {

    @Select("select * from seckill_user where id = #{id}")
    SeckillUser getById(@Param("id") long id);
}
