package com.xyh.admin;

import com.xyh.admin.bean.User1;
import com.xyh.admin.mapper.User1Mapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import redis.clients.jedis.Jedis;

import javax.sql.DataSource;


@Slf4j
@SpringBootTest
class BootWeb2ApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    DataSource dataSource;
    @Autowired
    User1Mapper user1Mapper;
    @Autowired
    StringRedisTemplate redisTemplate;
    @Autowired
    RedisConnectionFactory redisConnectionFactory;


    @Test
    void contextLoads() {
        Long al = jdbcTemplate.queryForObject("select count(*) from user", Long.class);
        log.info("数据条数" + al);
        log.info("数据源类型：{}", dataSource.getClass());

    }

    @Test
    void testUserMapper() {
        User1 user1 = user1Mapper.selectById(1L);
        log.info("用户信息：{}", user1);
    }

    @Test
    void testRedis(){
        ValueOperations<String,String> operations = redisTemplate.opsForValue();
        operations.set("hello","world");
        String hello = operations.get("hello");
        System.out.println(hello);
        System.out.println(redisConnectionFactory.getClass());
        //创建Jedis对象
        /*Jedis jedis = new Jedis("192.168.19.129", 6379);
        //测试
        String value = jedis.ping();
        System.out.println(value);*/
    }
}
