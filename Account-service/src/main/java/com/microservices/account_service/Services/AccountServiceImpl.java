package com.microservices.account_service.Services;

import com.microservices.account_service.Client.CustomerClient;
import com.microservices.account_service.Client.CustomerRestClient;
import com.microservices.account_service.Models.Account;
import com.microservices.account_service.Models.Dto.RequestAccount;
import com.microservices.account_service.Models.Dto.ResponseAccount;
import com.microservices.account_service.Repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;
    private final CustomerRestClient customerRestClient;

    @Override
    public List<ResponseAccount> listAccount() {
        List<ResponseAccount> listAccount =  accountRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .toList();
        listAccount.forEach(ac -> {
            ac.setCustomerClient(customerRestClient.customer(ac.getCustomer_id()));
        });

        return listAccount;
    }

    @Override
    public ResponseAccount findById(Long id) {
        return convertEntityToDto(accountRepository.findById(id).get());
    }

    @Override
    public ResponseAccount addAccount(RequestAccount requestAccount) {
        Account account = convertDtoToEntity(requestAccount);
        account.setCreate_At(LocalDateTime.now());
        accountRepository.save(account);
      return convertEntityToDto(account);
    }

    @Override
    public ResponseAccount findByIdAccountAndCustomer(Long id) {
        Account account = accountRepository.findById(id).get();
        CustomerClient customerClient = customerRestClient.customer(account.getCustomer_id());
        account.setCustomerClient(customerClient);
        return convertEntityToDto(account);
    }

    @Override
    public ResponseAccount convertEntityToDto(Account account) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(account,ResponseAccount.class);
    }

    @Override
    public Account convertDtoToEntity(RequestAccount requestAccount) {
        return modelMapper.map(requestAccount,Account.class);
    }
}
