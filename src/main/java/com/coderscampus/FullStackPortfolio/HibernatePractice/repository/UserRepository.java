package com.coderscampus.FullStackPortfolio.HibernatePractice.repository;

import com.coderscampus.FullStackPortfolio.HibernatePractice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    select * from users where username = :username
    List<User> findByUsername(String username);

//    select * from users where name = :name and username = :username
    List<User> findByUsernameAndName(String username, String name);

//    Find * from users between the two dates
    List<User> findByCreatedDateBetween(LocalDate startDate, LocalDate endDate);
}
