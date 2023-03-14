package com.megumi.learnspringframework.game;


import org.springframework.stereotype.Component;

@Component
public class MarioGame implements GamingConsole {

    public void up(){
        System.out.println("Jump");
    }

    public void down(){
        System.out.println("down");
    }


    public void left(){
        System.out.println("back");
    }

    public void right(){
        System.out.println("back");
    }
}


