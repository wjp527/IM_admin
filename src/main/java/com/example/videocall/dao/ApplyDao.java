package com.example.videocall.dao;

import com.example.videocall.pojo.Apply;
import com.example.videocall.pojo.User;

import java.util.List;

public interface ApplyDao {
    /**
     * 添加好友申请
     * @param apply
     */
    public void addUser(Apply apply);

    List<Apply> listApply(Long id);

    void deleteApply(Long id);
}
