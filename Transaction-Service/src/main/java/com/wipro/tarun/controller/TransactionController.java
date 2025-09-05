package com.wipro.tarun.controller;


import org.springframework.web.bind.annotation.*;

import com.wipro.tarun.dto.TransactionDto;
import com.wipro.tarun.service.TransactionService;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService service;

    @PostMapping
    public ResponseEntity<TransactionDto> create(@RequestBody TransactionDto dto) {
        TransactionDto saved = service.save(dto);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDto> getById(@PathVariable Long id) {
        return service.getById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<TransactionDto> getAll() { 
    	return service.getAll(); 
    	}
}

