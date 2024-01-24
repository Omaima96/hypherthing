package com.exercise.hypherthing.service;

import com.exercise.hypherthing.converter.RoleConverter;
import com.exercise.hypherthing.dao.RoleDAO;
import com.exercise.hypherthing.dto.RoleDTO;
import com.exercise.hypherthing.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService  extends AbstractService<Role, RoleDTO> {

    @Autowired
    private RoleConverter converter;
    @Autowired
    private RoleDAO repository;

    public Role updateRole(Long id, RoleDTO roleDto) {
        Optional<Role> existingRole = repository.findById(id);

        if (existingRole.isPresent()) {
            Role role = existingRole.get();
            role.setType(roleDto.getType());
            role.setDescription(roleDto.getDescription());
            return repository.save(role);
        } else {
            return null;
        }
    }
}