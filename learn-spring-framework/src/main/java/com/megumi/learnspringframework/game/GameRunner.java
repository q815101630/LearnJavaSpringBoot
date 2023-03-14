package com.megumi.learnspringframework.game;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

    private GamingConsole game;

    // Constructor based DI
    public GameRunner(@Qualifier("SupermanGameQualifier") GamingConsole game) {
        // Constructor Injection
        this.game = game;
    }

    public void run() {
        System.out.println("Running game: " + game);
    }
}
