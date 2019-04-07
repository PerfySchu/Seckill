package com.perfyschu.seckill.controller;

import com.perfyschu.seckill.result.CodeMsg;
import com.perfyschu.seckill.result.Result;
import com.perfyschu.seckill.service.SeckillUserService;
import com.perfyschu.seckill.util.ValidatorUtil;
import com.perfyschu.seckill.vo.LoginVo;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.groovy.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * 文件名：LoginController.java
 * 创建日期：2019/4/7 11:13
 * 说明：
 *
 * @author PerfySchu
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    SeckillUserService userService;

    @RequestMapping("/to_login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/do_login")
    @ResponseBody
    public Result doLogin(HttpServletResponse response, @Valid LoginVo loginVo){
        log.info(loginVo.toString());
        userService.login(response, loginVo);
        return Result.success(true);
    }
}
