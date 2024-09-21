package com.example.videocall.service;

import com.example.videocall.dao.ApplyDao;
import com.example.videocall.dao.FriendDao;
import com.example.videocall.pojo.Apply;
import com.example.videocall.pojo.Friend;
import com.example.videocall.pojo.User;
import com.example.videocall.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService {

    @Autowired
    private FriendDao friendDao;

    @Autowired
    private ApplyDao applyDao;

    /**
     * 获取好友列表
     * @param user
     * @return
     */
    public Object listFriends(User user) {
        // TODO: implement logic to list friends of a user
        List<User> list = friendDao.listFriends(user.getId());
        return ResponseUtils.ok(list);
    }

    /**
     * 搜索好友列表
     * @param username
     */
    public Object searchFriends(String username) {
        List<User> list = friendDao.searchFriends(username);
        return ResponseUtils.ok(list);
    }

    /**
     * 添加好友申请
     * @param apply
     * @return
     */
    public Object addUser(Apply apply) {
        applyDao.addUser(apply);
        return ResponseUtils.ok();
    }

    /**
     * 获取好友申请列表
     * @param user
     * @return
     */
    public Object applyList(User user) {
        List<Apply> list = applyDao.listApply(user.getId());
        return ResponseUtils.ok(list);
    }

    /**
     * 同意好友申请
     * @param friend
     * @return
     */
    public Object agreeApply(Friend friend) {
//        这只是给用户甲通过好友申请
        friendDao.addUserPass(friend);

//        这是给好友乙通过好友申请
        Friend friend1 = new Friend();
        friend1.setUid(friend.getFid());
        friend1.setFid(friend.getUid());
        friendDao.addUserPass(friend1);

        return ResponseUtils.ok();
    }

    public Object refuseApply(Apply apply) {
        applyDao.deleteApply(apply.getId());
        return ResponseUtils.ok();
    }
}
