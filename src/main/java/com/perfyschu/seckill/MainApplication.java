package com.perfyschu.seckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 文件名：Main.java
 * 创建日期：2019/4/2 21:59
 * 说明：
 *
 * @author PerfySchu
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.perfyschu.seckill.dao"})
public class MainApplication
//        extends SpringBootServletInitializer
{
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(MainApplication.class);
//    }
}
