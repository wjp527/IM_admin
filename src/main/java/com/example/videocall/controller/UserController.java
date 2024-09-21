package com.example.videocall.controller;

import com.example.videocall.annotaion.LoginUser;
import com.example.videocall.pojo.User;
import com.example.videocall.service.UserService;
import com.example.videocall.utils.ResponseUtils;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 获取当前登录用户信息
     * @param user
     * @return
     */
    @GetMapping
    public Object user(@LoginUser User user) {
        return ResponseUtils.ok(user);
    }



}
