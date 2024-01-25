package com.exercise.hypherthing.service;

import com.exercise.hypherthing.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * Questa classe astratta implementa tutti i metodi CRUD firmati in Service.
 * Il converter agisce due volte nei metodi  insert e update per avere sia come input che come output
 * un oggetto DTO.
 *
 * @param
 * @param
 *
 * @see Service
 */
public abstract class AbstractService <Entity,DTO> implements Service<DTO>{

    @Autowired
    protected CrudRepository<Entity,Long> repository;
    @Autowired
    protected Converter<Entity,DTO> converter;

    public AbstractService(){

    }
    @Override
    public DTO insert(DTO dto) {
        return converter.toDTO(repository.save(converter.toEntity(dto)));
    }

    @Override
    public DTO getById(Long id) {
        return converter.toDTO(repository.findById(id).get());
    }

    @Override
    public List<DTO> getAll() {
        return converter.toDTOList(repository.findAll());
    }

    @Override
    public DTO create(DTO dto) {
        return converter.toDTO(repository.save(converter.toEntity(dto)));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}