package com.xyh.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xyh
 * @date 2021/10/25 19:30
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user1")//指定表名
public class User1 {
    private Long id;
    private String name;
    private Integer age;
    private String email;

    /*
    表示在表中不存在
     */
    @TableField(exist = false)
    private String qa;
}
