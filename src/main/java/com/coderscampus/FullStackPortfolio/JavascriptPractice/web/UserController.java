package com.coderscampus.FullStackPortfolio.JavascriptPractice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("/exists")
    public Boolean Exists(String username, String password) {
        System.out.println("username : " + username + " password : " + password);
        return true;
    }

    @GetMapping("validateUsername")
    public Boolean validateUsername(String username) {
        return true;
    }

    @GetMapping("/validatePassword")
    public Boolean validatePassword(String password) {
        return true;
    }
}
