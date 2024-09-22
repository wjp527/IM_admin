package com.example.videocall.controller;

import com.example.videocall.annotaion.LoginUser;
import com.example.videocall.pojo.Message;
import com.example.videocall.pojo.User;
import com.example.videocall.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/send")
    public Object send(@LoginUser User user, @RequestBody Message message) {
        System.out.println("message = " + message);
        message.setFrom_id(user.getId());
        return messageService.send(message);
    }
}
