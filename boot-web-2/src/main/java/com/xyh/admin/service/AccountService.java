package com.xyh.admin.service;

import com.xyh.admin.bean.Account;
import com.xyh.admin.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xyh
 * @date 2021/10/25 10:14
 */

@Service
public class AccountService {

    @Autowired
    AccountMapper accountMapper;
    public Account getAcctById(Long id){
        return accountMapper.getAccut(id);
    }
}
