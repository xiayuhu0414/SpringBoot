package com.xyh.admin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xyh
 * @date 2021/10/17 15:00
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String userName;
    private String password;
}
