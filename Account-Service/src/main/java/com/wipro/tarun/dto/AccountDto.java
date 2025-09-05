package com.wipro.tarun.dto;


import lombok.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto {
    private Long id;
    private String username;
    private String panCardNum;
    private String aadharCardNum;
    private String bankAccNum;
    private String accountType;
    private String password;
    private BigDecimal balance;
}

