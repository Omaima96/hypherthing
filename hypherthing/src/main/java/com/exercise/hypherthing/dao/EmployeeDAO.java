package com.exercise.hypherthing.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;
import com.exercise.hypherthing.model.Employee;
import java.util.List;

@Repository
@Transactional
public interface EmployeeDAO extends CrudRepository<Employee,Long> {

    @Query("SELECT e FROM Employee e WHERE e.role.type LIKE :role")
    List<Employee> filterByRole(@Param("role") String role);

}