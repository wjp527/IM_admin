package com.example.videocall.controller;

import com.example.videocall.annotaion.LoginUser;
import com.example.videocall.pojo.Apply;
import com.example.videocall.pojo.Friend;
import com.example.videocall.pojo.User;
import com.example.videocall.service.FriendService;
import com.example.videocall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/friend")
public class FriendController {

    @Autowired
    private FriendService friendService;

    @Autowired
    private UserService userService;

    /**
     * 获取好友列表
 }
     * @return
     */
    @GetMapping("/list")
    public Object listFriends(@LoginUser User user) {
        return friendService.listFriends(user);

    }

    /**
     * 搜索好友列表
     * @param username
     * @return
     */
    @GetMapping("/search")
    public Object searchFriends(@RequestParam("username") String username) {
        return friendService.searchFriends(username);
    }

    /**
     * 添加好友
     * @param user
     * @return
     */
    @PostMapping("/add")
    public Object addUser(@LoginUser User user, Apply apply) {
        apply.setUid(user.getId());
        return friendService.addUser(apply);
    }


    /**
     * 获取好友申请列表
     * @param user
     * @return
     */
    @GetMapping("/apply")
    public Object applyList(@LoginUser User user) {
        return friendService.applyList(user);
    }


    /**
     * 同意好友申请
     * @param user
     * @param friend
     * @return
     */
    @PostMapping("/agree")
    public Object agreeApply(@LoginUser User user, @RequestBody Friend friend) {
        friend.setUid(user.getId());
        return friendService.agreeApply(friend);
    }

    /**
     * 拒绝好友申请
     * @param user
     * @param apply
     * @return
     */
    @PostMapping("/refuse")
    public Object refuseApply(@LoginUser User user, @RequestBody Apply apply) {
        return friendService.refuseApply(apply);
    }
}
