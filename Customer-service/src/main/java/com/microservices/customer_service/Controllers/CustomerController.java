package com.microservices.customer_service.Controllers;

import com.microservices.customer_service.Models.Dto.RequestCustomer;
import com.microservices.customer_service.Models.Dto.ResponseCustomer;
import com.microservices.customer_service.Services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseCustomer getCustomer(@PathVariable Long id){
        return customerService.customerById(id);
    }

    @GetMapping
    public List<ResponseCustomer> getCustomers(){
        return customerService.listCustomer();
    }

    @PostMapping
    public ResponseCustomer saveCustomer(@RequestBody RequestCustomer requestCustomer){
        return customerService.addCustomer(requestCustomer);
    }

}
