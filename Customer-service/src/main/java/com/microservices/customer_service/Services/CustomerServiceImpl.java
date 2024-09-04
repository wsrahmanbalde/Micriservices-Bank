package com.microservices.customer_service.Services;

import com.microservices.customer_service.Models.Customer;
import com.microservices.customer_service.Models.Dto.RequestCustomer;
import com.microservices.customer_service.Models.Dto.ResponseCustomer;
import com.microservices.customer_service.Repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<ResponseCustomer> listCustomer() {

         return customerRepository.findAll()
                 .stream()
                 .map(this::convertEntityToDto)
                 .collect(Collectors.toList());
    }

    @Override
    public ResponseCustomer customerById(Long id) {
        return convertEntityToDto(customerRepository.findById(id).get());
    }

    @Override
    public ResponseCustomer addCustomer(RequestCustomer requestCustomer) {
        return convertEntityToDto(customerRepository.save(convertDtoToEntity(requestCustomer)));
    }

    @Override
    public ResponseCustomer convertEntityToDto(Customer customer) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(customer,ResponseCustomer.class);
    }

    @Override
    public Customer convertDtoToEntity(RequestCustomer requestCustomer) {
        return modelMapper.map(requestCustomer,Customer.class);
    }
}
