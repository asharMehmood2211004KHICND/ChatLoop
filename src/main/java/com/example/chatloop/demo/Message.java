package com.example.chatloop.demo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
    
    private String message;
    private String userName;

    public Message(String message, String userName) {
        this.message = message;
        this.userName = userName;
    }
    
    public Message() {
    }


}
