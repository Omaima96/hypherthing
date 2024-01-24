package com.exercise.hypherthing.dao;

import com.exercise.hypherthing.model.Office;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface OfficeDAO extends CrudRepository<Office,Long> {
}