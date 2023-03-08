package com.megumi.learnspringframework.helloworld;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


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
    public Person person3Parameters(String name, int age, Address address3){ //managed with name
        return new Person(name, age, address3);
    }
    @Bean
    public Person person4Parameters(String name, int age, Address address){ //managed with name
        return new Person(name, age, address);
    }

    @Bean(name = "address3")
    @Primary
    public Address address(){
        return new Address("Road 123", "Chengdu");
    }

    @Bean(name = "address4")
    @Qualifier("address4Qualifier")
    public Address address4(){
        return new Address("Road 123", "Chengdu");
    }

    @Bean
    public Person person4Qualifier(String name, int age, @Qualifier("address4Qualifier") Address address
    ){
        return new Person(name, age, address);
    }

}
