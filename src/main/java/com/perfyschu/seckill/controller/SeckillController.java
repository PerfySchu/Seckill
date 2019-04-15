package com.perfyschu.seckill.controller;

import com.perfyschu.seckill.domain.OrderInfo;
import com.perfyschu.seckill.domain.SeckillOrder;
import com.perfyschu.seckill.domain.SeckillUser;
import com.perfyschu.seckill.redis.RedisService;
import com.perfyschu.seckill.result.CodeMsg;
import com.perfyschu.seckill.service.GoodsService;
import com.perfyschu.seckill.service.OrderService;
import com.perfyschu.seckill.service.SeckillService;
import com.perfyschu.seckill.service.SeckillUserService;
import com.perfyschu.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName SeckillController
 * @Author PerfySchu
 * @Date 2019/4/15 12:52
 * @Version 1.0
 **/
@Controller
@RequestMapping("/seckill")
public class SeckillController {

    @Autowired
    SeckillUserService userService;
    @Autowired
    RedisService redisService;
    @Autowired
    GoodsService goodsService;
    @Autowired
    OrderService orderService;
    @Autowired
    SeckillService seckillService;

    @RequestMapping("/to_seckill")
    public String list(Model model, SeckillUser user,
                       @RequestParam("goodsId")long goodsId){
        model.addAttribute("user", user);
        if(user == null){
            return "login";
        }
        //判断库存
        GoodsVo goodsVo = goodsService.getGoodsVoByBoodsId(goodsId);
        if(goodsVo.getStockCount() <= 0){
            model.addAttribute("errmsg", CodeMsg.SECKILL_END.getMsg());
            return "seckill_fail";
        }

        //判断用户是否已秒杀该商品
        SeckillOrder order = orderService.getSeckillOrderByUserIdGoodsId(user.getId(), goodsVo.getId());
        if(order != null){
            model.addAttribute("errmsg", CodeMsg.SECKILL_REPEAT.getMsg());
            return "seckill_fail";
        }

        //开始秒杀 减库存，下订单，写入秒杀订单
        OrderInfo orderInfo = seckillService.seckill(user, goodsVo);
        model.addAttribute("orderInfo", orderInfo);
        model.addAttribute("goods", goodsVo);
        return "order_detail";
    }
}
