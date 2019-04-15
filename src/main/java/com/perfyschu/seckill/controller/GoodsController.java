package com.perfyschu.seckill.controller;

import com.perfyschu.seckill.domain.SeckillUser;
import com.perfyschu.seckill.redis.RedisService;
import com.perfyschu.seckill.service.GoodsService;
import com.perfyschu.seckill.service.SeckillUserService;
import com.perfyschu.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

    @Autowired
    RedisService redisService;

    @Autowired
    GoodsService goodsService;

    @RequestMapping("/to_list")
    public String toList(Model model, SeckillUser user){
        model.addAttribute("user", user);
        //获取商品列表
        List<GoodsVo> goodsList = goodsService.listGoodsVo();
        model.addAttribute("goodsList", goodsList);
        return "goods_list";
    }

    @RequestMapping("/to_detail/{goodsId}")
    public String toDetail(Model model, SeckillUser user, @PathVariable("goodsId")long goodsId){
        model.addAttribute("user", user);

        GoodsVo goodsVo = goodsService.getGoodsVoByBoodsId(goodsId);
        model.addAttribute("goods", goodsVo);

        long startAt = goodsVo.getStartDate().getTime();
        long endAt = goodsVo.getEndDate().getTime();
        long now = System.currentTimeMillis();
        int remainSeconds;
        int seckillStatus;
        if(now < startAt){
            seckillStatus = 0;
            remainSeconds = (int) ((startAt - now)/1000);
        }else if(now > endAt){
            seckillStatus = 2;
            remainSeconds = -1;
        }else{
            seckillStatus = 1;
            remainSeconds = 0;
        }
        model.addAttribute("seckillStatus", seckillStatus);
        model.addAttribute("remainSeconds", remainSeconds);

        return "goods_detail";
    }
}
