package com.microservices.account_service.Services;

import com.microservices.account_service.Models.Account;
import com.microservices.account_service.Models.Dto.RequestAccount;
import com.microservices.account_service.Models.Dto.ResponseAccount;

import java.util.List;

public interface AccountService {
    List<ResponseAccount> listAccount();
    ResponseAccount findById(Long id);
    ResponseAccount addAccount(RequestAccount requestAccount);

    ResponseAccount findByIdAccountAndCustomer(Long id);
    ResponseAccount convertEntityToDto(Account account);
    Account convertDtoToEntity(RequestAccount requestAccount);
}
