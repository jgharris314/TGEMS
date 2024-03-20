package com.jgharris314.tgems.services;

import com.jgharris314.tgems.models.Account;
import com.jgharris314.tgems.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        return new ArrayList<>(accountRepository.findAll());
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }
}
