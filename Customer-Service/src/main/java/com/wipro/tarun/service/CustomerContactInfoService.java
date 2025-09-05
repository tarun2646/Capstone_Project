package com.wipro.tarun.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.tarun.dto.CustomerContactInfoDto;
import com.wipro.tarun.entities.CustomerContactInfo;
import com.wipro.tarun.repo.CustomerContactInfoRepository;

import java.util.Optional;

@Service
public class CustomerContactInfoService {

    @Autowired
    private CustomerContactInfoRepository repository;

    public CustomerContactInfoDto createAndSave(CustomerContactInfoDto dto) {
        CustomerContactInfo entity = CustomerContactInfo.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .number(dto.getNumber())
                .age(dto.getAge())
                .address(dto.getAddress())
                .kycStatus(dto.getKycStatus())
                .build();
        CustomerContactInfo saved = repository.save(entity);

        return CustomerContactInfoDto.builder()
                .contactId(saved.getContactId())
                .name(saved.getName())
                .email(saved.getEmail())
                .number(saved.getNumber())
                .age(saved.getAge())
                .address(saved.getAddress())
                .kycStatus(saved.getKycStatus())
                .build();
    }

    public Optional<CustomerContactInfoDto> getById(Long id) {
        return repository.findById(id)
            .map(saved -> CustomerContactInfoDto.builder()
                .contactId(saved.getContactId())
                .name(saved.getName())
                .email(saved.getEmail())
                .number(saved.getNumber())
                .age(saved.getAge())
                .address(saved.getAddress())
                .kycStatus(saved.getKycStatus())
                .build());
    }
}


