package com.perfyschu.seckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 文件名：Main.java
 * 创建日期：2019/4/2 21:59
 * 说明：
 *
 * @author PerfySchu
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.perfyschu.seckill.dao"})
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
