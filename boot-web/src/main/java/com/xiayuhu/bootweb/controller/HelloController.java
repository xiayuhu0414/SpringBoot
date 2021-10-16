package com.xiayuhu.bootweb.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author xyh
 * @date 2021/10/15 14:26
 */
@RestController
public class HelloController {
    @RequestMapping("/1.jpg")
    //从请求参数位置拿到 username 并赋值给name
    public String hello(@RequestParam("username") String name){
        return "aaa";
    }
    //    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @GetMapping("/user")
    public String getUser(){

        return "GET-张三";
    }

    //    @RequestMapping(value = "/user",method = RequestMethod.POST)
    @PostMapping("/user")
    public String saveUser(){
        return "POST-张三";
    }


    //    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    @PutMapping("/user")
    public String putUser(){

        return "PUT-张三";
    }

    @DeleteMapping("/user")
//    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String deleteUser(){
        return "DELETE-张三";
    }

    //扩展点：如何把 _method 这个名字换成我们自己喜欢的




}
