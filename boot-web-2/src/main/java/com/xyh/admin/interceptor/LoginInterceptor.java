package com.xyh.admin.interceptor;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author xyh
 * @date 2021/10/18 15:53
 */
/*
* 1.配置好拦截器要拦截哪些请求
* 2.把这些配置放在容器中
* */
@Log4j2
public class LoginInterceptor implements HandlerInterceptor {

  //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI=request.getRequestURI();
        log.info("拦截的请求路径是{}",requestURI);
        //登录检查逻辑
        HttpSession session =request.getSession();
        Object loginUser =session.getAttribute("loginUser");
        if (loginUser!=null){
            return true;
        }
        request.setAttribute("msg","请先登录！");
        //response.sendRedirect("/");
        request.getRequestDispatcher("/").forward(request,response);
        return false;
    }

    //目标方法执行之后
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle执行",modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion执行异常",ex);
    }
}
