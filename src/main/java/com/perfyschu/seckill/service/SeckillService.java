package com.perfyschu.seckill.service;

import com.perfyschu.seckill.domain.Goods;
import com.perfyschu.seckill.domain.OrderInfo;
import com.perfyschu.seckill.domain.SeckillUser;
import com.perfyschu.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName SeckillService
 * @Author PerfySchu
 * @Date 2019/4/15 14:12
 * @Version 1.0
 **/
@Service
public class SeckillService {

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;

    @Transactional
    public OrderInfo seckill(SeckillUser user, GoodsVo goodsVo) {
        //减库存， 下订单， 写入秒杀订单
        goodsService.reduceStock(goodsVo);

        return orderService.createOrder(user, goodsVo);

    }
}
