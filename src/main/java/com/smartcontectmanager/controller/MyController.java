package com.smartcontectmanager.controller;

import com.smartcontectmanager.entity.Contact;
import com.smartcontectmanager.entity.User;
import com.smartcontectmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    UserRepository userRepository;
//    @GetMapping("/test")
//    @ResponseBody
//    public String addContact(){
//        User user= new User();
//        user.setName("Ankur Singh");
//        user.setEmail("ankur@123.gmail.com");
//
//        Contact contact= new Contact();
//        user.getContacts().add(contact);
//        userRepository.save(user);
//
//        return "working ";
//
//    }


}
