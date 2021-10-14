package com.xyh.boot.config;

import com.xyh.boot.bean.Car;
import com.xyh.boot.bean.Pet;
import com.xyh.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import javax.naming.Name;

/**
 * @author xyh
 * @date 2021/10/14 13:42
 */

/*
* 1.配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
* 2.配置类本身也是组件
* 3.ProxyBeanMethods：代理Bean的方法
*       Full(proxyBeanMethods = true)
*       Lite(proxyBeanMethods = flase)
*      组件依赖
* 4、@Import({User.class,})
*     给容器中自动创建出这两个类型的组件、默认组件的名字就是全类名
*
* 5.@ImportResource("classpath:beans.xml")导入spring的配置文件，
* */

@Import({User.class,})
@Configuration(proxyBeanMethods = true)  //这是一个配置类
//@ConditionalOnBean(name = "tom")
@ImportResource("classpath:beans.xml")
@EnableConfigurationProperties(Car.class)//1.开启Car配置绑定功能 2.把Car这个组件自动注册到容器中
public class MyConfig {

    /*
    * 外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
    * */
    //@ConditionalOnBean(name = "tom")//条件装配：当容器中有名为“tom”的组件才会注册组件，也可以标注在类上
    //@ConditionalOnMissingBean(name = "tom")// 没有的时候才会装配
    @Bean  //给容器中添加组件。以方法名作为组件的id。返回类型就是组件类型。返回的值，就是组件在容器中的实例。
    public User user01(){
        User xiayuhu=new User("xiayuhu",22);
        //user 组件依赖了Pet组件
        xiayuhu.setPet(tomcatPet());
        return xiayuhu;
    }
   // @Bean("tom")
    public Pet tomcatPet(){
        return new Pet("cat");
    }
}
