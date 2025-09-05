package com.wipro.tarun.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.tarun.dto.NotificationDto;
import com.wipro.tarun.entity.Notification;
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

	List<NotificationDto> findByUserId(Long userId);

 

}
