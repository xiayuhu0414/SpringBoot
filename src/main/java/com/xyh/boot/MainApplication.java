package com.xyh.boot;

import com.xyh.boot.bean.Pet;
import com.xyh.boot.bean.User;
import com.xyh.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author xyh
 * @date 2021/10/12 16:40
 */

//主程序类
@SpringBootApplication  //这是一个Spring Boot应用
public class MainApplication {
    public static void main(String[] args) {
        //1、返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        //2、查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
//        //3、 从容器中获取组件
//        Pet tom01 = run.getBean("tom", Pet.class);
//        Pet tom02 = run.getBean("tom", Pet.class);
//        System.out.println("组件：" + (tom01 == tom02));
//
//        MyConfig bean = run.getBean(MyConfig.class);
//        System.out.println(bean);
//        //如果@Configuration(proxyBeanMethods = true) 代理对象调用方法。SpringBoot总会检查这个组件是否在容器
//        //保持组件单实例
//        User user = bean.user01();
//        User user1 = bean.user01();
//        System.out.println(user == user1);
//
//        User user01 = run.getBean("user01", User.class);
//        Pet tom = run.getBean("tom", Pet.class);
//
//        System.out.println("用户的宠物：" + (user01.getPet() == tom));

        //5、获取组件
        String[] beanNamesForType = run.getBeanNamesForType(User.class);

        System.out.println("===========");

        for (String s : beanNamesForType
        ) {
            System.out.println(s);
        }


        boolean tom = run.containsBean("tom");
        System.out.println("容器中的组件：" + tom);

        boolean user = run.containsBean("user01");
        System.out.println("容器中的组件：" + user);


        boolean hh = run.containsBean("hh");
        System.out.println("hh：" + hh);
        boolean ss = run.containsBean("ss");
        System.out.println("ss：" + ss);
    }
}
