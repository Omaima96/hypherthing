package com.exercise.hypherthing.model;

import jakarta.persistence.*;
import lombok.*;

    @Entity
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Office {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, updatable = false, unique = true)
        private String street;
        private String city;
        private String cap;
}