package com.microservices.customer_service.Services;

import com.microservices.customer_service.Models.Customer;
import com.microservices.customer_service.Models.Dto.RequestCustomer;
import com.microservices.customer_service.Models.Dto.ResponseCustomer;

import java.util.List;

public interface CustomerService {
    List<ResponseCustomer> listCustomer();
    ResponseCustomer customerById(Long id);
    ResponseCustomer addCustomer(RequestCustomer requestCustomer);
    ResponseCustomer convertEntityToDto(Customer customer);
    Customer convertDtoToEntity(RequestCustomer requestCustomer);
}
