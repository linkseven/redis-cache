package com.cache.testredis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cache.testredis.annotation.Cache;
import com.cache.testredis.entity.Account;
import com.cache.testredis.mapper.AccountMapper;
import com.cache.testredis.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {
    @Resource
    private AccountMapper accountMapper;

    //@Cacheable("accounts")
    public Account getAccountById(Integer id){
        LambdaQueryWrapper<Account> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Account::getId,id);
        Account account = accountMapper.selectById(id);
        return account;
    }
}
