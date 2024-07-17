package com.coderscampus.FullStackPortfolio.JavascriptPractice.web;

import com.coderscampus.FullStackPortfolio.JavascriptPractice.domain.User;
import com.coderscampus.FullStackPortfolio.JavascriptPractice.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLogin(ModelMap model){
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

    @GetMapping("/register")
    public String getCreateUser(ModelMap model){
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping
    public String postCreateUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/login";
    }
}
