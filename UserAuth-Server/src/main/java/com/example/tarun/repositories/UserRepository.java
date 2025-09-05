package com.example.tarun.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tarun.entities.User;
import com.example.tarun.enums.UserRole;

import java.util.Optional;


@Repository
public interface UserRepository  extends JpaRepository<User, Long>
{

	 Optional<User> findFirstByEmail(String username);

	 Optional<User> findByUserRole(UserRole admin);

}
