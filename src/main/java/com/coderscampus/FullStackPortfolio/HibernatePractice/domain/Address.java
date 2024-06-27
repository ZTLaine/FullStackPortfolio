package com.coderscampus.FullStackPortfolio.HibernatePractice.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "addresses")
public class Address {
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    private Long userId;

    @Column(length = 200)
    private String addressLine1;
    @Column(length = 200)
    private String addressLine2;
    @Column(length = 100)
    private String city;
    @Column(length = 100)
    private String region;
    @Column(length = 100)
    private String country;
    @Column(length = 15)
    private String zipCode;
}
