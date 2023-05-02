package com.smartcontectmanager.controller;

import com.smartcontectmanager.entity.Contact;
import com.smartcontectmanager.entity.User;
import com.smartcontectmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/")
    public ModelAndView homePage(Model model){
        model.addAttribute("title","Home - Smart Contact Manager");
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @GetMapping("/about")
    public ModelAndView aboutPage(Model model){
        model.addAttribute("title","About - Smart Contact Manager");
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("about");
        return modelAndView;
    }
    @GetMapping("/signup")
    public ModelAndView signupPage(Model model){
        model.addAttribute("title","Register - Smart Contact Manager");
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("signup");
        return modelAndView;
    }


}
