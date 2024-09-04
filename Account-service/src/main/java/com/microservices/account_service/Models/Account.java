package com.microservices.account_service.Models;

import com.microservices.account_service.Client.CustomerClient;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double balance;
    @CreatedDate
    @Column(updatable = false,nullable = false)
    private LocalDateTime create_At;
    private String currency;
    @Enumerated(value = EnumType.STRING)
    private AccountType type;

    @Transient
    private CustomerClient customerClient;
    private Long customer_id;
}
