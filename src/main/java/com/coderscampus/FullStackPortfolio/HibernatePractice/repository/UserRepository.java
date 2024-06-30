package com.coderscampus.FullStackPortfolio.HibernatePractice.repository;

import com.coderscampus.FullStackPortfolio.HibernatePractice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    select * from users where username = :username
    List<User> findByUsername(String username);

//    select * from users where name = :name and username = :username
    List<User> findByUsernameAndName(String username, String name);

//    Find * from users between the two dates
    List<User> findByCreatedDateBetween(LocalDate startDate, LocalDate endDate);

//    An example of a custom query, name does not need to exactly match a convention
//    This particular one is a mess and actually just matches findByUserName() lol
    @Query("select u from User u where u.username = :username")
    List<User> findExactlyOneUserByUsername(String username);

    @NonNull
    @Query("select u from User u " +
//            The fetch keyword will allow it to all be gotten and populated with one statement
//            As opposed to pinging the db each time it needs to populate the objects
            "left join fetch u.accounts " +
            "left join fetch u.address")
    Set<User> findAllWithAccountsAndAddress();
}
