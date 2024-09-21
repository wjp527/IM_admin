package com.example.videocall.dao;

import com.example.videocall.pojo.Friend;
import com.example.videocall.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FriendDao {
    /**
     * 获取好友列表
     * @param id
     * @return
     */
    List<User> listFriends(Long id);

    /**
     * 搜索好友列表
     * @param username
     * @return
     */
    List<User> searchFriends(String username);

    /**
     * 添加好友申请
     * @param user
     */
    void addUser(User user);

    /**
     * 添加好友
     * @param friend
     */
    void addUserPass(Friend friend);
}
