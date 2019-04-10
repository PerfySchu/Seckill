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
    private String seckillPrice;
    private Date startDate;
    private Date endDate;


    public String getSeckillPrice() {
        return seckillPrice;
    }

    public void setSeckillPrice(String seckillPrice) {
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
