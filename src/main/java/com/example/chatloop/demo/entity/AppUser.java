package com.example.chatloop.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class AppUser {
    
    

    public AppUser() {
    }

    public long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    
    @Id
    @GeneratedValue(
        strategy = GenerationType.AUTO
    )
    private long userId;

    
    
    

    public AppUser(long userId, String name, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    private String name;

    


    private String email;

    private String password;




}
