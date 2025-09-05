package com.wipro.tarun.entity;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String senderName;
    private String senderAccNum;
    private String receiverName;
    private String receiverAccNum;
    private Double amount;
    private LocalDateTime timeOfPayment;
}

