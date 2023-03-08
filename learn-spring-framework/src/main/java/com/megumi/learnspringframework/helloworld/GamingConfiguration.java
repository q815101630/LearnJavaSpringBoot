package com.megumi.learnspringframework.helloworld;

import com.megumi.learnspringframework.game.GameRunner;
import com.megumi.learnspringframework.game.GamingConsole;
import com.megumi.learnspringframework.game.MarioGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {

    @Bean
    public GamingConsole game(){
        var game = new MarioGame();
        return game;
    }

    @Bean
    public GameRunner gameRunner(GamingConsole game){
        // return new GameRunner(game());
        return new GameRunner(game);
    }
}
