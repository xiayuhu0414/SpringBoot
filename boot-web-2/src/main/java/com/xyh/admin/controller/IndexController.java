package com.xyh.admin.controller;

import com.xyh.admin.bean.Account;
import com.xyh.admin.bean.City;
import com.xyh.admin.bean.User;
import com.xyh.admin.service.AccountService;
import com.xyh.admin.service.CityService;
import com.xyh.admin.service.impl.AccountServiceImpl;
import com.xyh.admin.service.impl.CityServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
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
    @Autowired
    StringRedisTemplate redisTemplate;

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


    //????????????????????????
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {
        if (StringUtils.hasLength(user.getUserName()) && "123456".equals(user.getPassword())) {
            //????????????????????????????????????
            session.setAttribute("loginUser", user);
            //????????????????????????main.html;  ?????????????????????????????????
            return "redirect:/index.html";
        } else {
            model.addAttribute("msg", "??????????????????");
            //??????????????????
            return "login";

        }
    }
    @GetMapping("/index.html")
    public String mainPage(HttpSession session,Model model){
         log.info("???????????????{}","mainpage");
      /*  //????????????????????????????????????
        Object loginUser = session.getAttribute("loginUser");
        if(loginUser!=null){
            return "index";
        }else{
            //??????????????????
            model.addAttribute("msg","??????????????????");
            return "login";
        }

*/
        ValueOperations<String,String> opsForValue= redisTemplate.opsForValue();
        String s = opsForValue.get("/index.html");
        String s1 = opsForValue.get("/sql");

        model.addAttribute("indexCount",s);
        model.addAttribute("sqlCount",s1);
        return "index";
    }
}
