package com.perfyschu.seckill.dao;

import com.perfyschu.seckill.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 文件名：UserDao.java
 * 创建日期：2019/4/3 20:52
 * 说明：
 *
 * @author PerfySchu
 */
public interface UserDao {

    /**
     * select by id
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    User getById(@Param("id")int id);

    /**
     * insert user
     * @param user
     * @return
     */
    @Insert("insert into user(id, name) values(#{id},#{name})")
    int insert(User user);
}
