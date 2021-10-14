package com.xyh.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author xyh
 * @date 2021/10/14 13:38
 */
@ToString
@Data
@AllArgsConstructor //全参构造器
@NoArgsConstructor // 无参构造器
public class Pet {
    private String name;
}
