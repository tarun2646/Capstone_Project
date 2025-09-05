package com.wipro.tarun.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerContactInfoDto {
    private Long contactId;
    private String name;
    private String email;
    private String number;
    private int age;
    private String address;
    private String kycStatus;
}


