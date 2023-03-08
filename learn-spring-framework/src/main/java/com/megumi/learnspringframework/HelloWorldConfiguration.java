package com.megumi.learnspringframework;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


record Person (String name, int age, Address address) {};
record Address(String firstLine, String city){};

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        return "Hugh";
    }

    @Bean
    public int age() {
        return 15;
    }

    @Bean
    public Person person(){
        return new Person("Ali", 20, new Address("Abc", "Abc"));
    }

    @Bean
    public Person person2MethodCall(){ // managed with method call
        return new Person(name(), age(), address());
    }

    @Bean
    public Person person3Parameters(String name, int age, Address address2){ //managed with name
        return new Person(name, age, address2);
    }

    @Bean(name = "address3")
    public Address address(){
        return new Address("Road 123", "Chengdu");
    }

    @Bean(name = "address4")
    public Address address4(){
        return new Address("Road 123", "Chengdu");
    }


}
