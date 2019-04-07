package com.perfyschu.seckill.controller;

import com.perfyschu.seckill.domain.SeckillUser;
import com.perfyschu.seckill.service.SeckillUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

/**
 * 文件名：GoodsController.java
 * 创建日期：2019/4/7 21:04
 * 说明：
 *
 * @author PerfySchu
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    GoodsController goodsController;
    @Autowired
    SeckillUserService userService;

    @RequestMapping("/to_list")
    public String toList(Model model, SeckillUser user){
        model.addAttribute("user", user);
        return "goods_list";
    }

    @RequestMapping("/to_detail")
    public String toDetail(HttpServletResponse response, Model model,
                         @CookieValue(value=SeckillUserService.COOKIE_NAME_TOKEN, required = false)String cookieToken,
                         @RequestParam(value=SeckillUserService.COOKIE_NAME_TOKEN, required = false)String paramToken){
        return "goods_detail";
    }
}
