package com.wipro.tarun.feign;


import java.time.LocalDateTime;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditLogDto {
    private Long auditId;
    private Double amount;
    private String senderName;
    private String senderAccNum;
    private String receiverName;
    private String receiverAccNum;
    private String transactionType;
    private LocalDateTime transactionTime;
    private String remarks;
    // ... other fields as needed
}

