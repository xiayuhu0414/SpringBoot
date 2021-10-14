package com.xyh.boot.bean;

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
//@Component  注册到容器中
@ConfigurationProperties(prefix = "mycar")
public class Car {
    private String brand;
    private Integer price;

    public Car(String brand, Integer price) {
        this.brand = brand;
        this.price = price;
    }

    public Car() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
