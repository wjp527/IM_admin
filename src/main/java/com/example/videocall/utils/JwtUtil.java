package com.example.videocall.utils;


import com.alibaba.fastjson.JSON;
import com.example.videocall.pojo.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class JwtUtil {



   /**
     * 用户登录成功后生成Jwt
     * 使用Hs256算法  私匙使用用户密码
     *
     * @return
     */
    public  String createJWT(User user) {
        Map<String, Object> map = new HashMap<>();
        map.put("user",user);
        return generatorToken(map);
    }

    private String generatorToken(Map<String, Object> map) {
        return Jwts.builder().setClaims(map)
                .setExpiration(generatorExpiration())
                .signWith(SignatureAlgorithm.HS512, "232312fjwaijfoa")
                .compact();
    }

    public User getToken(String token){
        Claims body = Jwts.parser().setSigningKey("232312fjwaijfoa").parseClaimsJws(token).getBody();
        LinkedHashMap user = (LinkedHashMap) body.get("user");
        return JSON.parseObject(JSON.toJSONString(user), User.class);
    }

    private Date generatorExpiration() {
        return new Date(System.currentTimeMillis() + 9000000);
    }





}