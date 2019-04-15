package com.perfyschu.seckill.service;

import com.perfyschu.seckill.dao.GoodsDao;
import com.perfyschu.seckill.domain.Goods;
import com.perfyschu.seckill.domain.SeckillGoods;
import com.perfyschu.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName GoodsService
 * @Author PerfySchu
 * @Date 2019/4/10 16:52
 * @Version 1.0
 **/
@Service
public class GoodsService {

    @Autowired
    GoodsDao goodsDao;

    public List<GoodsVo> listGoodsVo (){
        return goodsDao.listGoodsVo();
    }

    public GoodsVo getGoodsVoByBoodsId(long goodsId) {
        return goodsDao.getGoodsVoByBoodsId(goodsId);
    }

    @Transactional
    public void reduceStock(GoodsVo goodsVo) {
        SeckillGoods goods = new SeckillGoods();
        goods.setGoodsId(goodsVo.getId());
        goodsDao.reduceStock(goods);
    }
}
