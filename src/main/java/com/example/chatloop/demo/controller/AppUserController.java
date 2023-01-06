package com.example.chatloop.demo.controller;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chatloop.demo.Message;
import com.example.chatloop.demo.entity.AppUser;
import com.example.chatloop.demo.repository.AppUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/chatloop")
@CrossOrigin(origins = "http://192.168.0.154:3000")
public class AppUserController {
    
    @Autowired
    AppUserRepository appUserRepository; 

    @Autowired
    private Queue queue;

    @Autowired
    private RabbitTemplate template;

    @PostMapping
    public ResponseEntity<AppUser> postAppUser(@RequestBody AppUser appUser ){
        //adding the data in database
        if(appUser.getEmail()!=null){
            this.appUserRepository.save(appUser);
            return ResponseEntity.ok().body(appUser);
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }

    
    @PostMapping("/message")
    public ResponseEntity<String> sendMessage(@RequestBody Message message){
        try {

        if(message.getMessage()!= null){
            ObjectMapper mapp = new ObjectMapper();
            this.template.convertAndSend(queue.getName(), mapp.writeValueAsString(message) );
            return ResponseEntity.ok().build();
        }else{
            System.out.println("err");
            System.out.println("err");
            return ResponseEntity.badRequest().build();
        }

        } catch (Exception e) {
            System.out.println("err");
            System.out.println("err");

            return ResponseEntity.badRequest().build();
        }
    }

    // @RabbitListener
    // public void reciever(String in){
    //     // ObjectMapper mapp = new ObjectMapper();
    //     System.out.println(in);
    // }


    @RabbitListener(queues = "queue.A")
    public void listner(String in) throws Exception{
       
        System.out.println("message recevied : "+in);
    }

}
