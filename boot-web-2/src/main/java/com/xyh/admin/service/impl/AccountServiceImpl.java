package com.xyh.admin.service.impl;

import com.xyh.admin.bean.Account;
import com.xyh.admin.mapper.AccountMapper;
import com.xyh.admin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xyh
 * @date 2021/10/25 10:14
 */

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;
    @Override
    public Account getAcctById(Long id){
        return accountMapper.getAccut(id);
    }
}
