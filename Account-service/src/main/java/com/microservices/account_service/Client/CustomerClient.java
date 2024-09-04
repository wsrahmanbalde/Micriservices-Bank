package com.microservices.account_service.Client;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerClient {
    private Long customerId;
    private String firstName;
    private String lastName;
    private String email;
}
