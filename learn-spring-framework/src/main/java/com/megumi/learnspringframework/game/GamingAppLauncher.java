package com.megumi.learnspringframework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.megumi.learnspringframework.game")
public class GamingAppLauncher {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(GamingAppLauncher.class);

        // retrieve the unique GamingConsole bean from the Spring environment

        // get primary one
        context.getBean(GamingConsole.class).down();

        // not primary one
        context.getBean(GameRunner.class).run();
    }
}
