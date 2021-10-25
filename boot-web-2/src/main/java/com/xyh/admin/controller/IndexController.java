package com.xyh.admin.controller;

import com.xyh.admin.bean.Account;
import com.xyh.admin.bean.City;
import com.xyh.admin.bean.User;
import com.xyh.admin.service.AccountService;
import com.xyh.admin.service.CityService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author xyh
 * @date 2021/10/17 14:44
 */
@Controller
@Log4j2
public class IndexController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountService accountService;
    @Autowired
    CityService cityService;

    @PostMapping("/city")
    @ResponseBody
    public City saveCity(City city){
        cityService.saveCity(city);
        return city;
    }

    @ResponseBody
    @GetMapping("/city")
    public City getCityById(@RequestParam("id") Long id){
        return cityService.getById(id);
    }

    @GetMapping("/acct")
    @ResponseBody
    public Account getById(@RequestParam("id") Long id){
        return accountService.getAcctById(id);
    }

    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb(){
        Long al=jdbcTemplate.queryForObject("select count(*) from user",Long.class);
        return al.toString();

    }

    @GetMapping(value = {"/","/login"})
    public String login(){
        return "login";
    }


    //解决表单重复提交
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {
        if (StringUtils.hasLength(user.getUserName()) && "123456".equals(user.getPassword())) {
            //把登陆成功的用户保存起来
            session.setAttribute("loginUser", user);
            //登录成功重定向到main.html;  重定向防止表单重复提交
            return "redirect:/index.html";
        } else {
            model.addAttribute("msg", "账号密码错误");
            //回到登录页面
            return "login";

        }
    }
    @GetMapping("/index.html")
    public String mainPage(HttpSession session,Model model){
         log.info("当前方法是{}","mainpage");
      /*  //是否登录。拦截器，过滤器
        Object loginUser = session.getAttribute("loginUser");
        if(loginUser!=null){
            return "index";
        }else{
            //回到登录页面
            model.addAttribute("msg","请重新登录！");
            return "login";
        }
*/
      return "index";
    }
}
