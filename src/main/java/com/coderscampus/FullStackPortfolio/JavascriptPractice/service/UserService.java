package com.coderscampus.FullStackPortfolio.JavascriptPractice.service;

import com.coderscampus.FullStackPortfolio.JavascriptPractice.domain.User;
import com.coderscampus.FullStackPortfolio.JavascriptPractice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
        User testUser = new User();
        testUser.setUsername("Test");
        testUser.setPassword("pw");
        userRepo.save(testUser);
    }

    public Boolean doesUsernameExist(String username) {
        if (username == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }
        List<User> foundUsername = userRepo.findByUsername(username);
        if(foundUsername != null && foundUsername.isEmpty()) {
            return false;
        } else return true;
    }

    public  Boolean arePasswordReqsMet(String password) {
        String regex = "^.{6,24}$";
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        return password.matches(regex);
    }
}
