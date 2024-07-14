package com.coderscampus.FullStackPortfolio.JavascriptPractice.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLogin(ModelMap model){
        return "login";
    }
}
