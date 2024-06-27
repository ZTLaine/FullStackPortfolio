package com.coderscampus.FullStackPortfolio.HibernatePractice.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @ManyToMany(mappedBy = "accounts")
    List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions = new ArrayList<Transaction>();

    @Column(length = 100)
    private String accountName;

}
