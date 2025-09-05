package com.wipro.tarun.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationId;

    @Column(nullable = false)
    private Long userId; // The user/customer to notify

    @Column(nullable = false)
    private String message; // Message content

 
    private LocalDateTime notificationDate; // When it was sent
}


