package com.wipro.tarun.service;



import org.springframework.stereotype.Service;

import com.wipro.tarun.dto.TransactionDto;
import com.wipro.tarun.entity.Transaction;
import com.wipro.tarun.feign.AuditFeignClient;
import com.wipro.tarun.feign.AuditLogDto;
import com.wipro.tarun.repo.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository repo;
    
    @Autowired
    private AuditFeignClient auditFeignClient;
    
    

        public TransactionDto save(TransactionDto dto) {
            Transaction transaction = new Transaction();
                
           

            Transaction saved = repo.save(transaction);

            // After saving transaction, create audit log
            AuditLogDto auditLogDto = AuditLogDto.builder()
                .amount(saved.getAmount())
                .senderName(saved.getSenderName())
                .senderAccNum(saved.getSenderAccNum())
                .receiverName(saved.getReceiverName())
                .receiverAccNum(saved.getReceiverAccNum())
                .transactionTime(saved.getTimeOfPayment())
                .transactionType("TRANSFER")
                .remarks("Transaction successful")
                .build();

            try {
                auditFeignClient.createAuditLog(auditLogDto);
            } catch (Exception ex) {
                // Optionally handle/report Feign errors
            }

            return toDto(saved); // your normal return
        }

        // ...other methods...
    
    
    

    public TransactionDto save1(TransactionDto dto) {
        Transaction t = Transaction.builder()
            .senderName(dto.getSenderName())
            .senderAccNum(dto.getSenderAccNum())
            .receiverName(dto.getReceiverName())
            .receiverAccNum(dto.getReceiverAccNum())
            .amount(dto.getAmount())
            .timeOfPayment(dto.getTimeOfPayment() != null ? dto.getTimeOfPayment() : java.time.LocalDateTime.now())
            .build();
        Transaction saved = repo.save(t);
        return toDto(saved);
    }

    public Optional<TransactionDto> getById(Long id) {
        return repo.findById(id).map(this::toDto);
    }

    public List<TransactionDto> getAll() {
        return repo.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    private TransactionDto toDto(Transaction t) {
        return TransactionDto.builder()
            .id(t.getId())
            .senderName(t.getSenderName())
            .senderAccNum(t.getSenderAccNum())
            .receiverName(t.getReceiverName())
            .receiverAccNum(t.getReceiverAccNum())
            .amount(t.getAmount())
            .timeOfPayment(t.getTimeOfPayment())
            .build();
    }
}

