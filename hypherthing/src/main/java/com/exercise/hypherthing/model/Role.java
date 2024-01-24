package com.exercise.hypherthing.model;

import jakarta.persistence.*;
import lombok.*;

    @Data
    @Entity
    @NoArgsConstructor
    @AllArgsConstructor
    public class Role {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, updatable = false, unique = true)
        private String type;
        private String description;
}