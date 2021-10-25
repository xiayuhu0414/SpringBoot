package com.xyh.admin;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class BootWeb2ApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads() {
        Long al=jdbcTemplate.queryForObject("select count(*) from user",Long.class);
        log.info("数据条数"+al);
        log.info("数据源类型：{}",dataSource.getClass());

    }

}
