package com.megumi.learnspringframework;

import com.megumi.learnspringframework.game.GameRunner;
import com.megumi.learnspringframework.game.MarioGame;

public class App01GamingBasicJava {
    public static void main(String[] args) {

        var game = new MarioGame();


        // Injecting GamingConsole into GameRunner
        // game is a dependency of GameRunner
        var gameRunner = new GameRunner(game);

        gameRunner.run();
    }
}
