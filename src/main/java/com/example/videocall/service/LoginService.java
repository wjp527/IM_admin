package com.example.videocall.service;

import com.example.videocall.dao.UserDao;
import com.example.videocall.pojo.User;
import com.example.videocall.utils.JwtUtil;
import com.example.videocall.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoginService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 登录
     * @param loginRequest
     * @return
     */
    public Object login(Map<String, String> loginRequest) {
        String username = loginRequest.get("username");
        String password = loginRequest.get("password");

        User user = userDao.selectByUsername(username);

        // 用户不存在
        if(user == null) {
            return ResponseUtils.username();
        }

        // 密码错误
        if(!user.getPassword().equals(password)) {
            return ResponseUtils.username();
        }

        return ResponseUtils.ok(jwtUtil.createJWT(user));
    }
}
