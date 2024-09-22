package com.example.videocall.pojo;

public class Message {
    private Long id;
    private Long from_id;
    private Long to_id;
    private Integer type;
    private String content;
    private String time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public Long getFrom_id() {
        return from_id;
    }

    public void setFrom_id(Long from_id) {
        this.from_id = from_id;
    }

    public Long getTo_id() {
        return to_id;
    }

    public void setTo_id(Long to_id) {
        this.to_id = to_id;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", from_id=" + from_id +
                ", to_id=" + to_id +
                ", type=" + type +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
