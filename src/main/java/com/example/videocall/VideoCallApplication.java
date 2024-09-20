package com.example.videocall;

import com.example.videocall.netty.CoordinationNettyServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 启动类
public class VideoCallApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(VideoCallApplication.class, args);
    }

    // 注入Netty服务
    @Autowired
    private CoordinationNettyServer nettyServer;

    // 启动Netty服务
    @Override
    public void run(String... args) throws Exception {
        nettyServer.start();
    }
}
