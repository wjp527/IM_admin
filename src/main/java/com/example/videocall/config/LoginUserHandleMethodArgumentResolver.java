package com.example.videocall.config;

import com.example.videocall.annotaion.LoginUser;
import com.example.videocall.pojo.User;
import com.example.videocall.utils.JwtUtil;
import com.example.videocall.utils.TokenExcption;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;


// 自定义参数解析器，用于解析@LoginUser注解的参数，从请求头中获取token，并解析出用户信息
@Configuration
public class LoginUserHandleMethodArgumentResolver implements HandlerMethodArgumentResolver {
    // 注入JwtUtil
    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 判断参数是否有@LoginUser注解
     * @param parameter
     * @return
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // 判断参数类型是否是User，并且有@LoginUser注解
        return parameter.getParameterType().isAssignableFrom(User.class) && parameter.hasParameterAnnotation(LoginUser.class);
    }

    /**
     * 解析参数，从请求头中获取token，并解析出用户信息
     * @param parameter
     * @param mavContainer
     * @param webRequest
     * @param binderFactory
     * @return
     * @throws Exception
     */

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        // 从请求头中获取token
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        // 解析token
        String token = request.getHeader("Authorization");
        // 判断token是否为空
        if(StringUtils.isEmpty(token)) {
            throw new TokenExcption();
        }
        return jwtUtil.getToken(token);
    }
}
