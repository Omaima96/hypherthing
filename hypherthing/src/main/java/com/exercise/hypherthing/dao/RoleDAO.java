package com.exercise.hypherthing.dao;

import com.exercise.hypherthing.model.Role;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface RoleDAO extends CrudRepository<Role,Long> {
}