package com.microservices.account_service.Client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/api/v1/customers")
    List<CustomerClient> customerClient();
    @CircuitBreaker(name = "customerService" , fallbackMethod = "getDefaultCustomer")
    @GetMapping("/api/v1/customers/{id}")
    CustomerClient customer(@PathVariable Long id);

    default CustomerClient getDefaultCustomer(Long id, Exception e){
        return CustomerClient
                .builder()
                .customerId(id)
                .firstName("null")
                .lastName("null")
                .email("null")
                .build();
    }
}
