package com.wipro.tarun.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.tarun.dto.NotificationDto;
import com.wipro.tarun.entity.Notification;
import com.wipro.tarun.repo.NotificationRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository repo;

    public NotificationDto create(NotificationDto dto) {
        Notification entity = Notification.builder()
            .userId(dto.getUserId())
            .message(dto.getMessage())
            
            .notificationDate(dto.getNotificationDate() != null ? dto.getNotificationDate() : java.time.LocalDateTime.now())
            .build();

        Notification saved = repo.save(entity);
        return toDto(saved);
    }

    public Optional<NotificationDto> getById(Long id) {
        return repo.findById(id).map(this::toDto);
    }

    public List<NotificationDto> getAll() {
        return repo.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    

    private NotificationDto toDto(Notification n) {
        return NotificationDto.builder()
            .notificationId(n.getNotificationId())
            .userId(n.getUserId())
            .message(n.getMessage())
            
            .notificationDate(n.getNotificationDate())
            .build();
    }

	
}

