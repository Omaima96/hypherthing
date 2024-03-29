package com.exercise.hypherthing.converter;

import com.exercise.hypherthing.dto.RoleDTO;
import com.exercise.hypherthing.model.Role;
import org.springframework.stereotype.Component;

    @Component
    public class RoleConverter extends AbstractConverter<Role, RoleDTO> {
        @Override
        public Role toEntity(RoleDTO roleDTO) {
            Role role = null;
            if(roleDTO != null){
                role = new Role(roleDTO.getId(), roleDTO.getType(),
                        roleDTO.getDescription());
            }
            return role;
        }

        @Override
        public RoleDTO toDTO(Role role) {
            RoleDTO roleDTO = null;
            if(role != null){
                roleDTO = new RoleDTO(role.getId(), role.getType(), role.getDescription());
            }
            return roleDTO;
        }
    }