package com.microservices.customer_service.Models.Dto;

import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCustomer {

    private Long customerId;
    private String firstName;
    private String lastName;
    private String email;

}
