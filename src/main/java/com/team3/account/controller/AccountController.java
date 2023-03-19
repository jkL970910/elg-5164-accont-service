package com.team3.account.controller;

import java.util.List;
import java.util.Optional;

import com.team3.account.dto.AccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.team3.account.model.Account;
import com.team3.account.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable("id") Long id) {
        Optional<Account> optionalAccount = accountService.getAccountById(id);

        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            return new ResponseEntity<>(account, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody AccountRequest accountRequest) {
        Account savedAccount = accountService.createAccount(accountRequest.getUsername(),
                accountRequest.getPassword());
        return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Account> deleteAccountById(@PathVariable("id") Long id) {
        Optional<Account> optionalAccount = accountService.deleteAccountById(id);

        if (optionalAccount.isPresent()) {
            Account deletedAccount = optionalAccount.get();
            return new ResponseEntity<>(deletedAccount, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllAccounts() {
        accountService.deleteAllAccounts();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}