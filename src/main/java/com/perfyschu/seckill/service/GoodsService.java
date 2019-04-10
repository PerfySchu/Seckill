package com.perfyschu.seckill.service;

import com.perfyschu.seckill.dao.GoodsDao;
import com.perfyschu.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
