package com.wipro.tarun.dto;


import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDto {
    private Long id;
    private String senderName;
    private String senderAccNum;
    private String receiverName;
    private String receiverAccNum;
    private Double amount;
    private LocalDateTime timeOfPayment;
}

