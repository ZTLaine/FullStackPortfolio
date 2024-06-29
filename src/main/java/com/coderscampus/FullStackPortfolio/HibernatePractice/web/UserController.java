package com.coderscampus.FullStackPortfolio.HibernatePractice.web;

import com.coderscampus.FullStackPortfolio.HibernatePractice.domain.User;
import com.coderscampus.FullStackPortfolio.HibernatePractice.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;

@Controller
public class UserController {

    UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAllUsers(ModelMap model) {
        model.addAttribute("users", userService.findAll());

        return "users";
    }

    @GetMapping("/users/{userId}")
    public String getById(@PathVariable Long userId, ModelMap model) {
        User user = userService.findById(userId);
        model.addAttribute("users", Arrays.asList(user));
        return "users";
    }
}
