package com.exercise.hypherthing.dto;

import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {

    private Long id;

    private String type;
    private String description;
}