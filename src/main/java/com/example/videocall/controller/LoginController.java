package com.example.videocall.controller;

import com.example.videocall.service.LoginService;
import com.example.videocall.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @PostMapping
    public Object login(@RequestBody Map<String, String> loginRequest){
        if(CollectionUtils.isEmpty(loginRequest)) {
            return ResponseUtils.badArgument();
        }

        return loginService.login(loginRequest);
    }
}
