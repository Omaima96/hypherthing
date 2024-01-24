package com.exercise.hypherthing.controller;

import com.exercise.hypherthing.dto.RoleDTO;
import com.exercise.hypherthing.model.Role;
import com.exercise.hypherthing.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService service;

    @GetMapping("/read/{id}")
    public RoleDTO read(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/getall")
    public List<RoleDTO> getRoles(){
        return service.getAll();
    }

    @PostMapping("/insert")
    public RoleDTO createRole (@RequestBody RoleDTO dto) {
        service.create(dto);
        return dto;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Role> update(@PathVariable Long id, @RequestBody RoleDTO dto) throws ChangeSetPersister.NotFoundException {
        Role updatedRole = service.updateRole(id, dto);
        return ResponseEntity.ok(updatedRole);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
