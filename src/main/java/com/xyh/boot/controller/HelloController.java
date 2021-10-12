package com.xyh.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xyh
 * @date 2021/10/12 16:54
 */

//@Controller
//@ResponseBody  写在类上表示类的方法都返回字符串
@RestController  //以上两种注解的合体
public class HelloController {
    @RequestMapping("/hello") //映射请求
   // @ResponseBody 表示浏览器返回字符串
    public String handle01(){
        return "hello!";
    }
}
