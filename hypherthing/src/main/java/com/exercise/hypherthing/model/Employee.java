package com.exercise.hypherthing.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

    @Entity
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Employee {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, updatable = false, unique = true)
        private String name;
        private String lastName;
        private Date birthday;
        private Date hiringDate;
        private int contractDuration;
        private String phoneNumber;
        private String email;

        @OneToOne
        private Role role;

        @OneToOne
        private Office office;
    }