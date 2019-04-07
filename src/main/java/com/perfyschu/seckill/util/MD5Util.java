package com.perfyschu.seckill.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 文件名：MD5Util.java
 * 创建日期：2019/4/7 11:02
 * 说明：
 *
 * @author PerfySchu
 */
public class MD5Util {

    private static final String salt = "1a2b3c4d";

    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }

    public static String inputPassToFormPass(String inputPass){
        String str = ""+salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    public static String formPassToDBPass(String inputPass, String salt){
        String str = ""+salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    public static String inputPassToDbPass(String input, String saltDB){
        String formPass = inputPassToFormPass(input);
        String dbPass = formPassToDBPass(formPass, saltDB);
        return dbPass;
    }

    public static void main(String[] args) {
        System.out.println(inputPassToFormPass("123456"));
        System.out.println(formPassToDBPass(inputPassToFormPass("123456"), "1a2b3c4d"));
        System.out.println(inputPassToDbPass("123456", "1a2b3c4d"));
    }
}
