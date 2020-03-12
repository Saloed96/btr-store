package com.btr.service.impl;

import com.btr.domain.Account;
import com.btr.repository.AccountRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class AccountSecurityService implements UserDetailsService {

    private static final Logger LOG = LogManager.getLogger();
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOG.info("Looking for user with name " + username + " in the DB.");
        Account account = accountRepository.findByUsername(username);

        if (account == null) {
            LOG.error("Username " + username + " not found in the DB.");
            throw new UsernameNotFoundException("Username not found");
        }
        return account;
    }
}
