package com.exercise.hypherthing.service;

import com.exercise.hypherthing.converter.OfficeConverter;
import com.exercise.hypherthing.dao.OfficeDAO;
import com.exercise.hypherthing.dto.OfficeDTO;
import com.exercise.hypherthing.model.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OfficeService extends AbstractService<Office, OfficeDTO>{
    @Autowired
    private OfficeConverter converter;

    @Autowired
    private OfficeDAO repository;


    public Office update(Long id, OfficeDTO officeDto) throws ChangeSetPersister.NotFoundException {
        Optional<Office> existingOffice = repository.findById(id);

        if (existingOffice.isPresent()) {
            Office office = existingOffice.get();
            office.setStreet(officeDto.getStreet());
            office.setCity(officeDto.getCity());
            office.setCap(officeDto.getCap());

            return repository.save(office);
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }
}