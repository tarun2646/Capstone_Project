package com.wipro.tarun.service;

import org.springframework.stereotype.Service;

import com.wipro.tarun.dto.AccountDto;
import com.wipro.tarun.entity.Account;
import com.wipro.tarun.repo.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    // Save/Create account
    public AccountDto saveAccount(AccountDto dto) {
        Account account = Account.builder()
            .username(dto.getUsername())
            .panCardNum(dto.getPanCardNum())
            .aadharCardNum(dto.getAadharCardNum())
            .bankAccNum(dto.getBankAccNum())
            .accountType(Account.AccountType.valueOf(dto.getAccountType()))
            .password(dto.getPassword())
            .balance(dto.getBalance())
            .build();
        Account saved = repository.save(account);
        return toDto(saved);
    }

    // Get account by ID
    public Optional<AccountDto> getAccountById(Long id) {
        return repository.findById(id).map(this::toDto);
    }

    // Get all accounts
    public List<AccountDto> getAllAccounts() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    // Utility: Entity to DTO mapping
    private AccountDto toDto(Account acc) {
        return AccountDto.builder()
            .id(acc.getId())
            .username(acc.getUsername())
            .panCardNum(acc.getPanCardNum())
            .aadharCardNum(acc.getAadharCardNum())
            .bankAccNum(acc.getBankAccNum())
            .accountType(acc.getAccountType().name())
            .password(acc.getPassword())
            .balance(acc.getBalance())
            .build();
    }
}


