package com.exercise.hypherthing.service;

import com.exercise.hypherthing.converter.EmployeeConverter;
import com.exercise.hypherthing.dao.EmployeeDAO;
import com.exercise.hypherthing.dto.EmployeeDTO;
import com.exercise.hypherthing.model.Employee;
import com.exercise.hypherthing.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService extends AbstractService<Employee, EmployeeDTO> {

    @Autowired
    private EmployeeConverter converter;

    @Autowired
    private EmployeeDAO repository;

    public Employee update(Long id, EmployeeDTO employeeDto) {
        Optional<Employee> existingEmployee = repository.findById(id);

        if (existingEmployee.isPresent()) {
            Employee employee = existingEmployee.get();
            employee.setName(employeeDto.getName());
            employee.setLastName(employeeDto.getLastName());
            employee.setBirthday(employeeDto.getBirthday());
            employee.setHiringDate(employeeDto.getHiringDate());
            employee.setContractDuration(employeeDto.getContractDuration());
            employee.setPhoneNumber(employeeDto.getPhoneNumber());
            employee.setEmail(employeeDto.getEmail());

            return repository.save(employee);
        } else {
            return null;
        }
    }

    public List<Employee> getByRoleFilter(String role) {
        role = "%" + role + "%";
        return repository.filterByRole(role);
    }
}