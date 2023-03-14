package com.megumi.learnspringframework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PacmanGame implements GamingConsole{

    public void up(){
        System.out.println(" 1");
    }

    public void down(){
        System.out.println("2");
    }


    public void left(){
        System.out.println("3");
    }

    public void right(){
        System.out.println("4");
    }

}
