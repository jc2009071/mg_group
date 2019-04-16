package com.master.group.application.bean;

import lombok.Data;

@Data
public class Message {
    private String msg;
    private String tag;

    public Message() { }

    public Message(String msg, String tag) {
        this.msg = msg;
        this.tag = tag;
    }
}
