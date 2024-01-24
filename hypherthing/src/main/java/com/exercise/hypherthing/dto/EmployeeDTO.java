package com.exercise.hypherthing.dto;

import com.exercise.hypherthing.model.Office;
import com.exercise.hypherthing.model.Role;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import java.util.Date;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    public class EmployeeDTO {

        private Long id;

        private String name;
        private String lastName;
        private Date birthday;
        private Date hiringDate;
        private int contractDuration;
        private String phoneNumber;
        private String email;
        private Role role;
        private Office office;
}