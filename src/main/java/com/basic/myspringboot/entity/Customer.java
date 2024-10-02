package com.basic.myspringboot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 전략은 네 가지가 있다. AUTO, TABLE, SEQUENCE, IDENTITY
    // 오라클, PostgreSQL : SEQUENCE, Mysql, MariaDB : IDENTITY
    private Long id;

    @Column(name = "cust_id", unique = true, nullable = false)
    private String customerId;

    @Column(name = "cust_name", nullable = false)
    private String customerName;

//    private String test;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt = LocalDateTime.now();
}
