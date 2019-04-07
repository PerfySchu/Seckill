package com.perfyschu.seckill.exception;

import com.perfyschu.seckill.result.CodeMsg;

/**
 * 文件名：GlobalException.java
 * 创建日期：2019/4/7 17:15
 * 说明：
 *
 * @author PerfySchu
 */
public class GlobalException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private CodeMsg codeMsg;

    public GlobalException(CodeMsg codeMsg){
        super(codeMsg.toString());
        this.codeMsg = codeMsg;
    }

    public CodeMsg getCodeMsg() {
        return codeMsg;
    }
}
