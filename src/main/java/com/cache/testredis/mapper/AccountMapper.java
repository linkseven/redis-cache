package com.cache.testredis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cache.testredis.entity.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMapper extends BaseMapper<Account> {
}
