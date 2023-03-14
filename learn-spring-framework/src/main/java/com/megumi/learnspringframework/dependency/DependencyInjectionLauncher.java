package com.megumi.learnspringframework.dependency;

import com.megumi.learnspringframework.game.GameRunner;
import com.megumi.learnspringframework.game.GamingConsole;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// Lazy: not initialized until someone uses this class
// Default to Eager initialization

//@Lazy
@Component
class BusinessClass{

    // 1. Field DI
//    @Autowired
    Dependency1 dependency1;


//    @Autowired
    Dependency2 dependency2;

    PrototypeClass prototypeClass;


    // 2. Constructor-based DI (Autowired is not necessary)
    public BusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        System.out.println("Initialized");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    @Autowired
    public void setPrototypeClass(PrototypeClass prototypeClass) {
        this.prototypeClass = prototypeClass;
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

    // Run immediately after Dependency injection
    @PostConstruct
    public void initialize(){
        dependency1.getReady();
    }

    @PreDestroy
    public void cleanUp(){
        System.out.println("Business logic ends");
    }


    public String toString(){
        return "Using " + dependency1 + " and " + dependency2;
    }
}

@Component
@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PrototypeClass{
    // Many instances per Spring IoC container
}


@Component
class Dependency1{
    public void getReady(){
        System.out.println("Dependency1 is ready to run!");
    }
}

@Component
class Dependency2{

}


//@Configuration
@ComponentScan
public class DependencyInjectionLauncher {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(DependencyInjectionLauncher.class);

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        System.out.println(context.getBean(BusinessClass.class));
        System.out.println(context.getBean(PrototypeClass.class)); // Each time a different prototype class is created upon request
        System.out.println(context.getBean(PrototypeClass.class));
        System.out.println(context.getBean(PrototypeClass.class));

        context.close();
    }
}
