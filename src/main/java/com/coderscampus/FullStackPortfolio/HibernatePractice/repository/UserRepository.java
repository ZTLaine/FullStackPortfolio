package com.coderscampus.FullStackPortfolio.HibernatePractice.repository;

import com.coderscampus.FullStackPortfolio.HibernatePractice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
