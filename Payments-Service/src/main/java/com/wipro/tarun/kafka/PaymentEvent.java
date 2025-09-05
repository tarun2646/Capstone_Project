package com.wipro.tarun.kafka;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentEvent {
    private Long paymentId;
    private Long transactionId;
    private String status;       // Or PaymentStatus enum as String
    private String message;      // Custom, e.g. "Payment successful!"
}

