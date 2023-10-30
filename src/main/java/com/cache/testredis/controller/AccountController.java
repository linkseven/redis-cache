package com.cache.testredis.controller;

import com.cache.testredis.annotation.Cache;
import com.cache.testredis.common.Result;
import com.cache.testredis.entity.Account;
import com.cache.testredis.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/get/{id}")
    @Cache(name = "accounts")
    public Result getInfo(@PathVariable("id") Integer id){
        Account byId = accountService.getById(id);
        accountService.getAccountById(id);
        return Result.success(byId);
    }
}

