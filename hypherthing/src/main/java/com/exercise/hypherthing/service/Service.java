package com.exercise.hypherthing.service;

import java.util.List;

public interface Service<DTO> {

    public DTO getById(Long id);
    public List<DTO> getAll();
    public DTO insert (DTO dto);
    public  DTO create(DTO dto);
    public void delete(Long id);
}