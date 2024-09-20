package com.example.videocall.exception;

import com.example.videocall.utils.ResponseUtils;
import com.example.videocall.utils.TokenExcption;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

// 全局异常处理
@RestControllerAdvice
public class MyExceptionHandler {


    // 处理所有异常
    @ExceptionHandler(value = Exception.class)
    // 返回json格式的异常信息
    @ResponseBody
    public Object exceptionHandler(HttpServletRequest req, Exception e) {
        // 打印异常信息
        e.printStackTrace();
        // 根据不同异常返回不同错误信息
        if (e instanceof TokenExcption){
            // token异常
            return ResponseUtils.unlogin();
        }else if (e instanceof MalformedJwtException) {
            // token格式异常
            return ResponseUtils.unlogin();
        }else if (e instanceof ExpiredJwtException){
            // token过期异常
            return ResponseUtils.unlogin();
        }else {
            // 其他异常
            return ResponseUtils.fail();
        }
    }

}