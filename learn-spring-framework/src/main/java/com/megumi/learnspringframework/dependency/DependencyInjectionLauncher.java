package com.megumi.learnspringframework.dependency;

import com.megumi.learnspringframework.game.GameRunner;
import com.megumi.learnspringframework.game.GamingConsole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// Lazy: not initialized until someone uses this class
// Default to Eager initialization
@Component
@Lazy
class BusinessClass{

    // 1. Field DI
//    @Autowired
    Dependency1 dependency1;


//    @Autowired
    Dependency2 dependency2;


    // 2. Constructor-based DI (Autowired is not necessary)
    public BusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        System.out.println("Initialized");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }



    // 3. Setter-based DI
//    @Autowired
//    public void setDependency1(Dependency1 dependency1) {
//        this.dependency1 = dependency1;
//    }
//    @Autowired
//    public void setDependency2(Dependency1 dependency2) {
//        this.dependency2 = dependency2;
//    }


    public String toString(){
        return "Using " + dependency1 + " and " + dependency2;
    }
}


@Component
class Dependency1{

}

@Component
class Dependency2{

}


@Configuration
@ComponentScan
public class DependencyInjectionLauncher {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(DependencyInjectionLauncher.class);

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

//        System.out.println(context.getBean(BusinessClass.class));
    }
}
