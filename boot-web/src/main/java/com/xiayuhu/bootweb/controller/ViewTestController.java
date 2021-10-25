package com.xiayuhu.bootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author xyh
 * @date 2021/10/17 14:14
 */
@Controller
public class ViewTestController {
    @GetMapping("/xyh")
    public String xyh(Model model){

        //mode中的数据会被放到请求域中 request.setAttribute("a",aa)
        model.addAttribute("msg","你好");
        model.addAttribute("link","http://www.baidu.com");
        return "success";
    }
}
