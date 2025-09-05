package com.wipro.tarun.dto;


import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationDto {
    private Long notificationId;
    private Long userId;
    private String message;
    
    private LocalDateTime notificationDate;
}
