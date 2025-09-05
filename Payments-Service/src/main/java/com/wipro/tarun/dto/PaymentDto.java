package com.wipro.tarun.dto;


import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.wipro.tarun.enums.PaymentMode;
import com.wipro.tarun.enums.PaymentStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDto {
    private Long paymentId;
    private Long transactionId;
    private BigDecimal amount;
    private PaymentMode paymentMode;
    private PaymentStatus status;
    private LocalDateTime paymentDate;
}

