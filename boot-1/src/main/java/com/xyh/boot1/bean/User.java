package com.xyh.boot1.bean;

import lombok.*;

/**
 * @author xyh
 * @date 2021/10/14 13:39
 */
@ToString
@Data
@AllArgsConstructor //全参构造器
@NoArgsConstructor // 无参构造器
@EqualsAndHashCode
public class User {
    private String name;
    private Integer age;
    private Pet pet;

}
