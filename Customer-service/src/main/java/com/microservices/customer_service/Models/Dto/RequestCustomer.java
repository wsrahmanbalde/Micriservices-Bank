package com.microservices.customer_service.Models.Dto;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestCustomer {

    private String firstName;
    private String lastName;
    private String email;

}
