package com.wipro.tarun.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.tarun.entities.CustomerContactInfo;;
@Repository
public interface CustomerContactInfoRepository extends JpaRepository<CustomerContactInfo, Long> {
}


