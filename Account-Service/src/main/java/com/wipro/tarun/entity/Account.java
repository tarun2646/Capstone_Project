package com.wipro.tarun.entity;


import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String panCardNum;

    @Column(nullable = false, unique = true)
    private String aadharCardNum;

    @Column(nullable = false, unique = true)
    private String bankAccNum;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountType accountType; // SAVINGS, CURRENT

    @Column(nullable = false)
    private String password; // Note: In real projects, always store hashed, not plain text!

    @Column(nullable = false)
    private BigDecimal balance;
    
    public enum AccountType {
        SAVINGS, CURRENT
    }
}

