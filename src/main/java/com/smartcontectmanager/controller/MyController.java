package com.smartcontectmanager.controller;

import com.smartcontectmanager.entity.Contact;
import com.smartcontectmanager.entity.User;
import com.smartcontectmanager.healper.Message;
import com.smartcontectmanager.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
        model.addAttribute("user",new User());
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("signup");
        return modelAndView;
    }

    @RequestMapping(value = "/do_register",method = RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute("user")User user, @RequestParam(value = "agreement",defaultValue = "false")boolean agreement, Model model, HttpSession session){
        ModelAndView modelAndView= new ModelAndView();
       try{

           if(!agreement){
               System.out.println("you have not agreed the terms and condition");
               throw new Exception( "you have not agreed the terms and condition");
           }
           user.setRole("ROLE_USER");
           user.setEnable(true);
           user.setImagesUrl("Default.png");
           System.out.println("Agreement" +agreement);
           System.out.println("user"+user);
           User result= this.userRepository.save(user);
           model.addAttribute("user",new User());
           session.setAttribute("message",new Message("Successfully Register","alert success"));
           modelAndView.setViewName("signup");
           return modelAndView;

       }catch (Exception e){
        e.printStackTrace();
        model.addAttribute("user",user);
        session.setAttribute("message",new Message("Something went wrong!!"+e.getMessage(),"alert-danger"));
           modelAndView.setViewName("signup");
           return modelAndView;

       }


    }


}
