package com.xyh.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author xyh
 * @date 2021/10/14 15:29
 */

/*
*  只有在容器中的组件，才会有SpringBoot提供的强大功能
* 自动配置：
* 方法1.@Component + @ConfigurationProperties
* 方法2.@EnableConfigurationProperties + @ConfigurationProperties
* */
@ToString
@Data
@AllArgsConstructor //全参构造器
@NoArgsConstructor // 无参构造器
//@Component  注册到容器中
@ConfigurationProperties(prefix = "mycar")
public class Car {
    private String brand;
    private Integer price;



}
