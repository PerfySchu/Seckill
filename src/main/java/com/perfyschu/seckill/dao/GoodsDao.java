package com.perfyschu.seckill.dao;

import com.perfyschu.seckill.domain.Goods;
import com.perfyschu.seckill.domain.SeckillGoods;
import com.perfyschu.seckill.vo.GoodsVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @ClassName GoodsDao
 * @Author PerfySchu
 * @Date 2019/4/10 16:52
 * @Version 1.0
 **/
public interface GoodsDao {

    /**
     * 查询商品列表
     * @return
     */
    @Select("select g.*, sg.stock_count, sg.seckill_price, sg.start_date, sg.end_date from seckill_goods sg left join goods g on sg.goods_id = g.id")
    List<GoodsVo> listGoodsVo();

    @Select("select g.*, sg.stock_count, sg.seckill_price, sg.start_date, sg.end_date from seckill_goods sg left join goods g on sg.goods_id = g.id " +
            "where g.id = #{goodsId}")
    GoodsVo getGoodsVoByBoodsId(@Param("goodsId")long goodsId);

    @Update("update seckill_goods set stock_count = stock_count -1 where goods_id = #{goodsId}")
    int reduceStock(SeckillGoods goods);
}
