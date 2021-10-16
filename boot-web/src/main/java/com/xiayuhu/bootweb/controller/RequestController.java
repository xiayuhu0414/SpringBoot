package com.xiayuhu.bootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xyh
 * @date 2021/10/16 15:50
 */
@Controller
public class RequestController {

    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request){
        request.setAttribute("msg","成功了");
        request.setAttribute("code",200);
        return "forward:/success";
    }

    @ResponseBody
    @GetMapping("/success")
    public Map success(@RequestAttribute("msg") String msg,
                                       @RequestAttribute("code") Integer code,
                                        HttpServletRequest request){
        Object m = request.getAttribute("msg");

        Map<String,Object> map=new HashMap<>();
        map.put("reqMethod_msg",m);
        map.put("annotation_msg",msg);
        map.put("annotation_code",code);

        return map;
    }
}


