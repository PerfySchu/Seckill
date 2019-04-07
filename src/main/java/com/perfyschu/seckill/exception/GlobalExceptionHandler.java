package com.perfyschu.seckill.exception;

import com.perfyschu.seckill.result.CodeMsg;
import com.perfyschu.seckill.result.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 文件名：GlobalExceptionHandler.java
 * 创建日期：2019/4/7 17:02
 * 说明：
 *
 * @author PerfySchu
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value=Exception.class)
    public Result<String> exceptionHandler(HttpServletRequest request, Exception e){
        if(e instanceof GlobalException){
            GlobalException globalException = (GlobalException) e;
            return Result.error(globalException.getCodeMsg());
        }else if(e instanceof BindException){
            BindException ex = (BindException) e;
            ObjectError error = ex.getAllErrors().get(0);
            String msg = error.getDefaultMessage();
            return Result.error(CodeMsg.BIND_ERROR.fillArgs(msg));
        }else{
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
}
