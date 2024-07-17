package com.coderscampus.FullStackPortfolio.JavascriptPractice.web;

import com.coderscampus.FullStackPortfolio.JavascriptPractice.domain.User;
import com.coderscampus.FullStackPortfolio.JavascriptPractice.repository.UserRepository;
import com.coderscampus.FullStackPortfolio.JavascriptPractice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    UserRepository userRepo;

    public UserController(UserService userService, UserRepository userRepo) {
        this.userService = userService;
        this.userRepo = userRepo;
    }

    @GetMapping("/exists")
    public Boolean Exists(String username, String password) {
        System.out.println("username : " + username + " password : " + password);
        return true;
    }

    @PostMapping("/exists")
    public Boolean postExists(@RequestBody User user) {
        return userService.doesUsernameExist(user.getUsername());
    }

    @PostMapping("/passwordReqs")
    public Boolean passwordReqs(@RequestBody User user) {
        return userService.arePasswordReqsMet(user.getPassword());
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
