package com.example.tarun.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tarun.dto.Token;

@Repository
public interface VerificationTokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findByToken(String token);
}
