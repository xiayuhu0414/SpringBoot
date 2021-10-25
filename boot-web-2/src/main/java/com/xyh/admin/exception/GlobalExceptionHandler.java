package com.xyh.admin.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author xyh
 * @date 2021/10/19 13:48
 *
 * 处理整个web controller的异常
 */

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ArithmeticException.class,NullPointerException.class})//处理异常
    public String handleArithExceptionHandler(Exception e){

       log.error("异常是：{}", e);
        return "login";
    }
}
