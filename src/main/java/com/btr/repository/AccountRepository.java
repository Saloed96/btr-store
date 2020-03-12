package com.btr.repository;

import com.btr.domain.Account;
import org.springframework.data.repository.CrudRepository;


public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findByUsername(String username);

}