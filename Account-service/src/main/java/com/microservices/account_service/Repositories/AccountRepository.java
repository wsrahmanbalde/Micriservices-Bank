package com.microservices.account_service.Repositories;

import com.microservices.account_service.Models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
