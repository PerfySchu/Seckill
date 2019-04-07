package com.perfyschu.seckill.service;

import com.perfyschu.seckill.dao.SeckillUserDao;
import com.perfyschu.seckill.domain.SeckillUser;
import com.perfyschu.seckill.exception.GlobalException;
import com.perfyschu.seckill.redis.RedisService;
import com.perfyschu.seckill.redis.SeckillUserKey;
import com.perfyschu.seckill.result.CodeMsg;
import com.perfyschu.seckill.util.MD5Util;
import com.perfyschu.seckill.util.UUIDUtil;
import com.perfyschu.seckill.vo.LoginVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * 文件名：SeckillUserService.java
 * 创建日期：2019/4/7 12:19
 * 说明：
 *
 * @author PerfySchu
 */
@Service
public class SeckillUserService {
    public static final String COOKIE_NAME_TOKEN = "token";

    /**SeckillUserDao*/
    @Autowired
    private SeckillUserDao userDao;
    @Autowired
    RedisService redisService;

    public SeckillUser getById(long id){
        return userDao.getById(id);
    }

    public boolean login(HttpServletResponse response, LoginVo loginVo){
        if(loginVo == null){
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        String mobile = loginVo.getMobile();
        String formPass = loginVo.getPassword();
        //判断手机号是否存在
        SeckillUser user = getById(Long.parseLong(mobile));
        if(user == null){
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        //验证密码
        String dbPass = user.getPassword();
        String dbSalt = user.getSalt();
        String calPass =  MD5Util.formPassToDBPass(formPass, dbSalt);
        if(!calPass.equals(dbPass)){
            throw new GlobalException(CodeMsg.CHECK_ERROR);
        }

        //添加cookie
        addCooike(response, user);
        return true;
    }

    public SeckillUser getByToken(HttpServletResponse response, String token) {
        if(StringUtils.isEmpty(token)){
            return null;
        }
        SeckillUser user = redisService.get(SeckillUserKey.token, token, SeckillUser.class);
        if(user != null) {
            addCooike(response, user);
        }
        return user;
    }

    private void addCooike(HttpServletResponse response, SeckillUser user){
        //生成cookie
        String token = UUIDUtil.uuid();
        redisService.set(SeckillUserKey.token, token, user);
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
        cookie.setMaxAge(SeckillUserKey.token.expireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
