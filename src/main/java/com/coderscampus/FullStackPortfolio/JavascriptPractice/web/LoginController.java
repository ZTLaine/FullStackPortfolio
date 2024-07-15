package com.coderscampus.FullStackPortfolio.JavascriptPractice.web;

import com.coderscampus.FullStackPortfolio.JavascriptPractice.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLogin(ModelMap model){
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }
}
