package com.coderscampus.FullStackPortfolio.HibernatePractice.web;

import com.coderscampus.FullStackPortfolio.HibernatePractice.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

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
}
