package com.wipro.tarun.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.tarun.dto.PaymentDto;
import com.wipro.tarun.entity.Payment;
import com.wipro.tarun.repo.PaymentRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repo;

    public PaymentDto save(PaymentDto dto) {
        Payment entity = Payment.builder()
            .transactionId(dto.getTransactionId())
            .amount(dto.getAmount())
            .paymentMode(dto.getPaymentMode())
            .status(dto.getStatus())
            .paymentDate(dto.getPaymentDate() != null ? dto.getPaymentDate() : java.time.LocalDateTime.now())
            .build();
        Payment saved = repo.save(entity);
        return toDto(saved);
    }

    public Optional<PaymentDto> getById(Long id) {
        return repo.findById(id).map(this::toDto);
    }

    public List<PaymentDto> getAll() {
        return repo.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    private PaymentDto toDto(Payment p) {
        return PaymentDto.builder()
            .paymentId(p.getPaymentId())
            .transactionId(p.getTransactionId())
            .amount(p.getAmount())
            .paymentMode(p.getPaymentMode())
            .status(p.getStatus())
            .paymentDate(p.getPaymentDate())
            .build();
    }
}

