package com.coderscampus.FullStackPortfolio.HibernatePractice.repository;

import com.coderscampus.FullStackPortfolio.HibernatePractice.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
