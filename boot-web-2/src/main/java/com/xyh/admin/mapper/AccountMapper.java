package com.xyh.admin.mapper;

import com.xyh.admin.bean.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xyh
 * @date 2021/10/25 9:59
 */

//@Mapper
public interface AccountMapper {
    public Account getAccut(Long id);
}
