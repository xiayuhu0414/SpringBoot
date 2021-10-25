package com.xyh.admin.controller;

import com.xyh.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

/**
 * @author xyh
 * @date 2021/10/17 15:38
 */
@Controller
public class TableController {

    @GetMapping("/basic_table")
    public String basic_table() {
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model) {
        //表格内容遍历
        List<User> users = Arrays.asList(new User("zhangs", "123456"),
                new User("23", "123456"),
                new User("223", "123456"),
                new User("233", "123456"),
                new User("243", "123456")
        );
        model.addAttribute("users", users);
        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table() {
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table() {
        return "table/editable_table";
    }
}
