package com.xyh.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan("com.xyh.admin.mapper")
@ServletComponentScan(basePackages = "com.xyh.admin")
@SpringBootApplication
public class BootWeb2Application {

    public static void main(String[] args) {
        SpringApplication.run(BootWeb2Application.class, args);
    }

}
