package com.microservices.account_service.Controllers;

import com.microservices.account_service.Models.Dto.RequestAccount;
import com.microservices.account_service.Models.Dto.ResponseAccount;
import com.microservices.account_service.Services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public List<ResponseAccount> findAccounts(){
        return accountService.listAccount();
    }

    @GetMapping("/{id}")
    public ResponseAccount account(@PathVariable Long id){
        return accountService.findById(id);
    }

    @PostMapping
    public ResponseAccount addAccount(@RequestBody RequestAccount requestAccount){
        return accountService.addAccount(requestAccount);
    }

    @GetMapping("/test/{id}")
    public ResponseAccount findAccountAndCustomer(@PathVariable Long id){
        return accountService.findByIdAccountAndCustomer(id);
    }
}
