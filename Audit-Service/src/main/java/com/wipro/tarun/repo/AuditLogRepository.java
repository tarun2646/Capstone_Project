package com.wipro.tarun.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.tarun.entity.AuditLog;
@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {

	List<AuditLog> findBySenderAccNum(String senderAccNum);

	List<AuditLog> findByReceiverAccNum(String receiverAccNum);

}
