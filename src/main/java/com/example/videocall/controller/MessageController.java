package com.example.videocall.controller;

import com.example.videocall.annotaion.LoginUser;
import com.example.videocall.pojo.User;
import com.example.videocall.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     * 获取消息列表
     * @return
     */
    @GetMapping("/list")
    public Object Chatlist(@LoginUser User user, Long to) {
        return messageService.Chatlist(user, to);
    }

    /**
     * 发送消息
     * @param message
     * @return
     */
//    @PostMapping("/send")
//    public Object send(String message) {
//        return messageService.send(message);
//    }
}
