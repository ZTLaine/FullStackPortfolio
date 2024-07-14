package com.coderscampus.FullStackPortfolio.HibernatePractice.web;

import com.coderscampus.FullStackPortfolio.HibernatePractice.domain.User;
import com.coderscampus.FullStackPortfolio.HibernatePractice.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.Set;

@Controller
public class UserController {

    UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAllUsers(ModelMap model) {
        //See assignment 13 for better fix. this is just to get the example working again
        Set<User> users = userService.findAll();
        model.addAttribute("users", userService.findAll());
        if(userService.findAll().size() == 1) {
            model.addAttribute("user", users.iterator().next());
        }

        return "users";
    }

    @GetMapping("/users/{userId}")
    public String getUpdateUser(@PathVariable Long userId, ModelMap model) {
//        This is here for testing and the whole finding by exactly one thing is a hot mess lol
//        User user = userService.findExactlyOneUserByUsername("Ztl");
        User user = userService.findById(userId);
        model.addAttribute("users", Arrays.asList(user));
        model.addAttribute("user", user);

        return "users";
    }

    @PostMapping("users/{userId}")
    public String postUpdateUser(@PathVariable Long userId, User user) {
        userService.saveUser(user);

        return "redirect:/users/" + user.getUserId();
    }

    @PostMapping("users/{userId}/delete")
    public String deleteOneUser(@PathVariable Long userId) {
        userService.deleteUser(userId);

        return "redirect:/users";
    }

    @GetMapping("/register")
    public String getCreateUser(ModelMap model) {
        model.addAttribute("users", new User());

        return "register";
    }

    @PostMapping("/register")
    public String postCreateUser(User user) {
        System.out.println(user);
        userService.saveUser(user);

        return "redirect:/register";
    }
}
