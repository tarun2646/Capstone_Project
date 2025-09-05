package com.wipro.tarun.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.tarun.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
