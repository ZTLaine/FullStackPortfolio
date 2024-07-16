package com.coderscampus.FullStackPortfolio.JavascriptPractice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {
    @GetMapping("/user/exists")
    public Boolean Exists() {
        return true;
    }
}
