package com.coderscampus.FullStackPortfolio.HibernatePractice.service;

import com.coderscampus.FullStackPortfolio.HibernatePractice.domain.User;
import com.coderscampus.FullStackPortfolio.HibernatePractice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepo;

    UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User findById(Long userId) {
        Optional<User> userOpt = userRepo.findById(userId);
        return userOpt.orElse(new User());
    }

    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public void deleteUser(Long userId) {
        userRepo.deleteById(userId);
    }

    public List<User> findByUsername(String username){
        return userRepo.findByUsername(username);
    }

    //    select * from users where name = :name and username = :username
    public List<User> findByUsernameAndName(String username, String name){
        return userRepo.findByUsernameAndName(username, name);
    }

    //    Find * from users between the two dates
    public List<User> findByCreatedDateBetween(LocalDate startDate, LocalDate endDate){
        return userRepo.findByCreatedDateBetween(startDate, endDate);
    }

    public User findExactlyOneUserByUsername(String username){
        List<User> users = userRepo.findExactlyOneUserByUsername(username);
        if(!users.isEmpty()){
            return users.getFirst();
        }
        else return new User();
    }
}
