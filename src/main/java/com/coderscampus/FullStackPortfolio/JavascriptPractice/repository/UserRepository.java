package com.coderscampus.FullStackPortfolio.JavascriptPractice.repository;

import com.coderscampus.FullStackPortfolio.JavascriptPractice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
