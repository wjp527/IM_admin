package com.example.videocall.dao;

import com.example.videocall.pojo.User;

public interface UserDao {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    User selectByUsername(String username);
}
