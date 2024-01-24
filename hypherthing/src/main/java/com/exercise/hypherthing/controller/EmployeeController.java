package com.exercise.hypherthing.controller;

import com.exercise.hypherthing.dto.EmployeeDTO;
import com.exercise.hypherthing.model.Employee;
import com.exercise.hypherthing.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController  {

    @Autowired
    private EmployeeService service;

    @GetMapping("/read/{id}")
    public EmployeeDTO read(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/insert")
    public EmployeeDTO createEmployee (@RequestBody EmployeeDTO dto) {
        service.create(dto);
        return dto;
    }

    @PutMapping("/update/{id}")
        public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody EmployeeDTO dto) {
            Employee updatedEmployee = service.update(id, dto);
            return ResponseEntity.ok(updatedEmployee);

    }

    @DeleteMapping("/delete/{id}")
    public void delete(@RequestParam("id") Long id) {
        service.delete(id);
    }

    @GetMapping("/getByRole")
    public List<Employee> getAllByFilter(@RequestParam String role){
        return service.getByRoleFilter(role);
    }
}