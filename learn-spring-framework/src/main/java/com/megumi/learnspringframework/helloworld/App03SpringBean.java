package com.megumi.learnspringframework.helloworld;

import com.megumi.learnspringframework.game.GameRunner;
import com.megumi.learnspringframework.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03SpringBean {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(GamingConfiguration.class);


        // retrieve the unique GamingConsole bean from the Spring environment
        context.getBean(GamingConsole.class).down();

        context.getBean(GameRunner.class).run();
    }
}
