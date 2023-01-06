package com.example.chatloop.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chatloop.demo.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser,Long>{
    
}
