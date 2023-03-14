package com.megumi.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SupermanGameQualifier")
public class SupermanGame implements GamingConsole{

    public void up(){
        System.out.println(" 11");
    }

    public void down(){
        System.out.println("22");
    }


    public void left(){
        System.out.println("33");
    }

    public void right(){
        System.out.println("44");
    }

}
