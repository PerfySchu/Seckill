package com.perfyschu.seckill.controller;

import com.perfyschu.seckill.domain.User;
import com.perfyschu.seckill.redis.KeyPrefix;
import com.perfyschu.seckill.redis.RedisService;
import com.perfyschu.seckill.redis.UserKey;
import com.perfyschu.seckill.result.CodeMsg;
import com.perfyschu.seckill.result.Result;
import com.perfyschu.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 文件名：SampleController.java
 * 创建日期：2019/4/2 22:01
 * 说明：
 *
 * @author PerfySchu
 */
@Controller
@RequestMapping("/demo")
public class SampleController {

    @Autowired
    UserService userService;
    @Autowired
    RedisService redisService;


    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model){
        model.addAttribute("name", "PerfySchu");
        return "hello";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public Result<String> hello(){
        return Result.success("hello Perfyschu");
    }

    @RequestMapping("/error")
    @ResponseBody
    public Result<String> error(){
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @RequestMapping("/db/get")
    @ResponseBody
    public Result<User> dbGet(){
        User user = userService.getById(1);
        return Result.success(user);
    }

    @RequestMapping("/db/tx")
    @ResponseBody
    public Result<Boolean> dbTx(){
         return Result.success(userService.tx());
    }

    @RequestMapping("/redis/get")
    @ResponseBody
    public Result<User> redisGet(){
        User v1 = redisService.get(UserKey.getById, ""+1, User.class);
        return Result.success(v1);
    }

    @RequestMapping("/redis/set")
    @ResponseBody
    public Result<Boolean> redisSet(){
        User user = new User();
        user.setId(1);
        user.setName("perfyschu");
        boolean ret = redisService.set(UserKey.getById,""+1, user);
        return Result.success(ret);
    }
}
