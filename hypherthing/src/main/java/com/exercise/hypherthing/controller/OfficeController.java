package com.exercise.hypherthing.controller;

import com.exercise.hypherthing.dto.OfficeDTO;
import com.exercise.hypherthing.model.Office;
import com.exercise.hypherthing.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/office")
public class OfficeController {

    @Autowired
    private OfficeService service;

    @GetMapping("/read/{id}")
    public OfficeDTO read(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/getall")
    public List<OfficeDTO> getOffices(){
        return service.getAll();
    }

    @PostMapping("/insert")
    public OfficeDTO createOffice (@RequestBody OfficeDTO dto) {
        service.create(dto);
        return dto;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Office> update(@PathVariable Long id, @RequestBody OfficeDTO dto) throws ChangeSetPersister.NotFoundException {
        Office updatedOffice = service.update(id, dto);
        return ResponseEntity.ok(updatedOffice);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}