package com.exercise.hypherthing.converter;

import com.exercise.hypherthing.dto.EmployeeDTO;
import com.exercise.hypherthing.model.Employee;
import org.springframework.stereotype.Component;

@Component
    public class EmployeeConverter extends AbstractConverter<Employee, EmployeeDTO>{

        @Override
        public Employee toEntity(EmployeeDTO employeeDTO) {
            Employee employee = null;
            if(employeeDTO!=null){
                employee = new Employee(employee.getId(), employee.getName(), employee.getLastName(), employee.getBirthday(),
                        employee.getHiringDate(), employee.getContractDuration(), employee.getPhoneNumber(), employee.getEmail(), employee.getRole(), employee.getOffice());
            }
            return employee;
        }

        @Override
        public EmployeeDTO toDTO(Employee employee) {
            EmployeeDTO employeeDTO = null;
            if(employee!= null){
                employeeDTO = new EmployeeDTO(employeeDTO.getId(), employeeDTO.getName(), employeeDTO.getLastName(), employeeDTO.getBirthday(),
                        employeeDTO.getHiringDate(), employee.getContractDuration(), employeeDTO.getPhoneNumber(), employeeDTO.getEmail(), employeeDTO.getRole(), employeeDTO.getOffice());
            }
            return employeeDTO;
        }
    }