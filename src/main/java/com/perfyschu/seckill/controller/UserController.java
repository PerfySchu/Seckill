package com.perfyschu.seckill.controller;

import com.perfyschu.seckill.domain.SeckillUser;
import com.perfyschu.seckill.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 文件名：UserController.java
 * 创建日期：2019/4/18 23:39
 * 说明：
 *
 * @author PerfySchu
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/info")
    @ResponseBody
    public Result<SeckillUser> info(Model model, SeckillUser user){
        System.out.println(user.getId());
        return Result.success(user);
    }
}
