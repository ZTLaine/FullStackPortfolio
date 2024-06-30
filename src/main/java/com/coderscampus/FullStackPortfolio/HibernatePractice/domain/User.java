package com.coderscampus.FullStackPortfolio.HibernatePractice.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity //Class name = User, DB Table name = user
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @ManyToMany
    @JoinTable(name = "user_account",
//        join needs to point to THIS class's id
        joinColumns = @JoinColumn(name = "user_id"),
//        inverseJoin needs to point to the OTHER class's id
        inverseJoinColumns = @JoinColumn(name = "account_id"))
    List<Account> accounts = new ArrayList<Account>();

    @OneToOne(mappedBy = "user")
    private Address address;

    private String username;
    private String password;
    private String name;
    private LocalDate createdDate;
}
