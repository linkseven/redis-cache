package com.cache.testredis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cache.testredis.entity.Account;

public interface AccountService extends IService<Account> {
    Account getAccountById(Integer id);
}
