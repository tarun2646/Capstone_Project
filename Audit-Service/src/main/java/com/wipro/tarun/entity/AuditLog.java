package com.wipro.tarun.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auditId;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private String senderName;

    @Column(nullable = false)
    private String senderAccNum;

    @Column(nullable = false)
    private String receiverName;

    @Column(nullable = false)
    private String receiverAccNum;

    @Column(nullable = false)
    private LocalDateTime transactionTime;

    @Column(nullable = false)
    private String transactionType; // e.g. "TRANSFER", "PAYMENT", etc.

    private String remarks; // optional: "successful", "failed", etc.
}


