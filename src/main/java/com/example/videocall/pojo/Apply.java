package com.example.videocall.pojo;

public class Apply {
    private Long id;
    private Long uid;
    private Long tid;

    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Apply{" +
                "id=" + id +
                ", uid=" + uid +
                ", tid=" + tid +
                ", user=" + user +
                '}';
    }
}
