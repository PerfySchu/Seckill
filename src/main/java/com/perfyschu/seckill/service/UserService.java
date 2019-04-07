package com.perfyschu.seckill.service;

import com.perfyschu.seckill.dao.UserDao;
import com.perfyschu.seckill.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 文件名：UserService.java
 * 创建日期：2019/4/3 20:54
 * 说明：
 *
 * @author PerfySchu
 */
@Service
public class UserService {

    /**
     * userDao
     */
    @Autowired
    private UserDao userDao;

    public User getById(int id){
        return userDao.getById(id);
    }


    public boolean tx(){
        User user = new User();
        user.setId(2);
        user.setName("2222");
        userDao.insert(user);

        User user2 = new User();
        user2.setId(1);
        user2.setName("1111");
        userDao.insert(user2);

        return true;
    }
}
