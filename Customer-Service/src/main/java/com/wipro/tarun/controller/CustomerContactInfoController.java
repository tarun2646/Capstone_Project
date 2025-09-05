package com.wipro.tarun.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.tarun.dto.CustomerContactInfoDto;
import com.wipro.tarun.service.CustomerContactInfoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customers")
public class CustomerContactInfoController {

    private final CustomerContactInfoService service;

    @Autowired
    public CustomerContactInfoController(CustomerContactInfoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CustomerContactInfoDto> create(@Valid @RequestBody CustomerContactInfoDto dto) {
        CustomerContactInfoDto saved = service.createAndSave(dto);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerContactInfoDto> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}


