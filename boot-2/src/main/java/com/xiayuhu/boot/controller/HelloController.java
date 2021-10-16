package com.xiayuhu.boot.controller;

import com.xiayuhu.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xyh
 * @date 2021/10/15 13:32
 */

@RestController
public class HelloController{
    @Autowired
    Person person;
    @RequestMapping("/person")
    public Person person(){
        return person;
    }
}
