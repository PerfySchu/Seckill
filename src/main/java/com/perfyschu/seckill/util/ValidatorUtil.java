package com.perfyschu.seckill.util;

import org.thymeleaf.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 文件名：ValidatorUtil.java
 * 创建日期：2019/4/7 12:09
 * 说明：
 *
 * @author PerfySchu
 */
public class ValidatorUtil {

    private static final Pattern mobile_pattern = Pattern.compile("1\\d{10}");

    public static boolean isMobile(String mobile){
        if(StringUtils.isEmpty(mobile)){
            return false;
        }
        Matcher m = mobile_pattern.matcher(mobile);
        return m.matches();
    }


    public static void main(String[] args) {
        System.out.println(isMobile("15527186096"));
        System.out.println(isMobile("155271096"));
    }
}
