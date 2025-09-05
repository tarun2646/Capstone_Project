package com.wipro.tarun.dto;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditLogDto {
    private Long auditId;
    private BigDecimal amount;
    private String senderName;
    private String senderAccNum;
    private String receiverName;
    private String receiverAccNum;
    private LocalDateTime transactionTime;
    private String transactionType;
    private String remarks;
}


