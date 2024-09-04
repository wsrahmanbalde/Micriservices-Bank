package com.microservices.account_service.Models.Dto;

import com.microservices.account_service.Client.CustomerClient;
import com.microservices.account_service.Models.AccountType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAccount {

    private Double balance;
    private LocalDateTime create_At;
    private String currency;
    private AccountType type;
    private CustomerClient customerClient;
    private Long customer_id;
}
