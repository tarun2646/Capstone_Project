package com.wipro.tarun.controller;


import org.springframework.web.bind.annotation.*;

import com.wipro.tarun.dto.AccountDto;
import com.wipro.tarun.service.AccountService;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService service;

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto dto) {
        AccountDto saved = service.saveAccount(dto);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        return service.getAccountById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<AccountDto> getAllAccounts() {
        return service.getAllAccounts();
    }
}


