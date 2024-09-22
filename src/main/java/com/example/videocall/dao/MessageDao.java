package com.example.videocall.dao;

import com.example.videocall.pojo.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageDao {

    /**
     * 获取聊天消息
     * @param id
     * @param to
     * @return
     */
    List<Message> Chatlist(@Param("id") Long id, @Param("to") Long to);

    /**
     * 发送消息
     * @param message
     * @return
     */
    int send(Message message);
}
