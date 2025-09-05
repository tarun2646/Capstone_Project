package com.wipro.tarun.controller;


import org.springframework.web.bind.annotation.*;

import com.wipro.tarun.dto.AuditLogDto;
import com.wipro.tarun.service.AuditLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/audit-logs")
public class AuditLogController {

    @Autowired
    private AuditLogService service;

    @PostMapping
    public ResponseEntity<AuditLogDto> create(@RequestBody AuditLogDto dto) {
        AuditLogDto saved = service.save(dto);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuditLogDto> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<AuditLogDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/by-sender/{senderAccNum}")
    public List<AuditLogDto> getBySender(@PathVariable String senderAccNum) {
        return service.getBySender(senderAccNum);
    }

    @GetMapping("/by-receiver/{receiverAccNum}")
    public List<AuditLogDto> getByReceiver(@PathVariable String receiverAccNum) {
        return service.getByReceiver(receiverAccNum);
    }
}