package com.lucfzy.webdemo.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetService {

    @RequestMapping("/")
    public String returnIndex(){
        return "index";
    }

    @RequestMapping("/login")
    public String returnLogin(){
        return "login";
    }
    @RequestMapping("/register")
    public String returnRegister(){
        return "register";
    }
}
