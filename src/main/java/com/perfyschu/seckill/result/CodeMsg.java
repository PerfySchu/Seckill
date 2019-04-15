package com.perfyschu.seckill.result;

/**
 * 文件名：CodeMsg.java
 * 创建日期：2019/4/3 20:32
 * 说明：
 *
 * @author PerfySchu
 */
public class CodeMsg {
    private int code;
    private String msg;

    //通用异常
    /**通用成功*/
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    /**通用错误码*/
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务异常");
    public static CodeMsg BIND_ERROR = new CodeMsg(500100, "%s");

    //登录异常
    /** session失效 */
    public static CodeMsg SESSION_ERROR = new CodeMsg(500210, "Session不存在或已经失效");
    /** 密码为空 */
    public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500211, "登录密码不能为空");
    /**手机号码为空*/
    public static CodeMsg MOBILE_EMPTY = new CodeMsg(500212, "手机号码不能为空");
    /**手机号码格式错误*/
    public static CodeMsg MOBILE_ERROR = new CodeMsg(500213, "手机号码格式错误");
    /**用户名或密码错误*/
    public static CodeMsg CHECK_ERROR = new CodeMsg(500214, "用户名或密码错误");
    /**手机号码不存在*/
    public static CodeMsg MOBILE_NOT_EXIST = new CodeMsg(500215, "手机号码不存在");
    /**秒杀商品已售罄*/
    public static CodeMsg SECKILL_END = new CodeMsg(500500, "秒杀商品已售罄");
    /**已参与秒杀*/
    public static CodeMsg SECKILL_REPEAT = new CodeMsg(500501, "您已秒杀过该商品");

    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CodeMsg fillArgs(Object...args){
        int code = this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
