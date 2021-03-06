package com.perfyschu.seckill.vo;

import com.perfyschu.seckill.domain.Goods;

import java.util.Date;

/**
 * @ClassName GoodsVo
 * @Author PerfySchu
 * @Date 2019/4/10 16:55
 * @Version 1.0
 **/
public class GoodsVo extends Goods {
    private Integer stockCount;
    private Double seckillPrice;
    private Date startDate;
    private Date endDate;


    public Double getSeckillPrice() {
        return seckillPrice;
    }

    public void setSeckillPrice(Double seckillPrice) {
        this.seckillPrice = seckillPrice;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
