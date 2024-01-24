package com.exercise.hypherthing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public class OfficeDTO {
        private Long id;

        private String street;
        private String city;
        private String cap;
    }