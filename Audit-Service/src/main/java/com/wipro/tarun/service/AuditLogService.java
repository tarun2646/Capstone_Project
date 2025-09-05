package com.wipro.tarun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.tarun.dto.AuditLogDto;
import com.wipro.tarun.entity.AuditLog;
import com.wipro.tarun.repo.AuditLogRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuditLogService {

    @Autowired
    private AuditLogRepository repository;

    public AuditLogDto save(AuditLogDto dto) {
        AuditLog log = AuditLog.builder()
            .amount(dto.getAmount())
            .senderName(dto.getSenderName())
            .senderAccNum(dto.getSenderAccNum())
            .receiverName(dto.getReceiverName())
            .receiverAccNum(dto.getReceiverAccNum())
            .transactionTime(dto.getTransactionTime() != null ? dto.getTransactionTime() : java.time.LocalDateTime.now())
            .transactionType(dto.getTransactionType())
            .remarks(dto.getRemarks())
            .build();
        AuditLog saved = repository.save(log);
        return toDto(saved);
    }

    public Optional<AuditLogDto> getById(Long id) {
        return repository.findById(id).map(this::toDto);
    }

    public List<AuditLogDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<AuditLogDto> getBySender(String senderAccNum) {
        return repository.findBySenderAccNum(senderAccNum).stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<AuditLogDto> getByReceiver(String receiverAccNum) {
        return repository.findByReceiverAccNum(receiverAccNum).stream().map(this::toDto).collect(Collectors.toList());
    }

    private AuditLogDto toDto(AuditLog l) {
        return AuditLogDto.builder()
            .auditId(l.getAuditId())
            .amount(l.getAmount())
            .senderName(l.getSenderName())
            .senderAccNum(l.getSenderAccNum())
            .receiverName(l.getReceiverName())
            .receiverAccNum(l.getReceiverAccNum())
            .transactionTime(l.getTransactionTime())
            .transactionType(l.getTransactionType())
            .remarks(l.getRemarks())
            .build();
    }
}



