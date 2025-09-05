package com.wipro.tarun.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.tarun.entity.Payment;


@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long>
{
	
}

