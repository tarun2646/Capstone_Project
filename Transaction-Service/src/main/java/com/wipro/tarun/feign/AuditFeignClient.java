package com.wipro.tarun.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "AUDIT-SERVICE") // should match spring.application.name in audit service
public interface AuditFeignClient {

    @PostMapping("/api/audit-logs")
    AuditLogDto createAuditLog(@RequestBody AuditLogDto auditLogDto);
}


