package com.megumi.learnspringframework;

import com.megumi.learnspringframework.game.GameRunner;
import com.megumi.learnspringframework.game.MarioGame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLOutput;

public class App02HelloWorldSpring {
    public static void main(String[] args) {
        // Launch a Spring Context

        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        // Configure what to manage @Configuration
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));
        System.out.println(context.getBean("person"));
//        System.out.println(context.getBean(Address.class));

        System.out.println(context.getBean("person2MethodCall"));
        System.out.println(context.getBean("person3Parameters"));
    }
}
