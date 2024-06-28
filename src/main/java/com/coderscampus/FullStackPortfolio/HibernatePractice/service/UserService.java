package com.coderscampus.FullStackPortfolio.HibernatePractice.service;

import com.coderscampus.FullStackPortfolio.HibernatePractice.domain.User;
import com.coderscampus.FullStackPortfolio.HibernatePractice.repository.UserRepository;

import java.util.List;

public class UserService {

    private UserRepository userRepo;

    UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User findById(Long id) {
        return userRepo.findById(id).get();
    }
}
