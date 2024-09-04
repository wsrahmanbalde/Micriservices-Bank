package com.microservices.account_service.Models.Dto;

import com.microservices.account_service.Client.CustomerClient;
import com.microservices.account_service.Models.AccountType;
import jakarta.persistence.Column;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestAccount {

    private Double balance;
    private String currency;
    private AccountType type;
    private Long customer_id;
}
