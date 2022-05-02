package com.example.emos.wx.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ExceptionAdive.java
 * @Description
 * @createTime 2022-04-30 15:56:00
 */
@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public String ExceptionHandler(Exception e){
        log.error("执行异常",e);
        if (e instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) e;
           return exception.getBindingResult().getFieldError().getDefaultMessage();
        }else if (e instanceof EmosException){
            EmosException exception = (EmosException) e;
            return exception.getMsg();
        }else if (e instanceof UnauthenticatedException){
            return "未登录";
        }else {
            return "未知异常,服务器内部异常";
        }
    }
}
