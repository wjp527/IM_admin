package com.example.videocall.service;

import com.example.videocall.dao.MessageDao;
import com.example.videocall.pojo.Message;
import com.example.videocall.pojo.User;
import com.example.videocall.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService
{

    @Autowired
    private MessageDao messageDao;

    /**
     * 获取聊天消息
     * @param user
     * @param to
     * @return
     */
    public Object Chatlist(User user, Long to) {
        List<Message> list= messageDao.Chatlist(user.getId(), to);
        return ResponseUtils.ok(list);
    }
}
