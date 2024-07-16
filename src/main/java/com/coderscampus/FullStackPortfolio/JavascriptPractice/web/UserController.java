package com.coderscampus.FullStackPortfolio.JavascriptPractice.web;

import com.coderscampus.FullStackPortfolio.JavascriptPractice.domain.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("/exists")
    public Boolean Exists(String username, String password) {
        System.out.println("username : " + username + " password : " + password);
        return true;
    }

    @PostMapping("/exists")
    public Boolean postExists(@RequestBody User user) {
        System.out.println("username : " + user.getUsername() + " password : " + user.getPassword());
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
