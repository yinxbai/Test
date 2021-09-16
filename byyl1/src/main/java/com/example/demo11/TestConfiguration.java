package com.example.demo11;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:/application.yml")
public class TestConfiguration {
    @Value("${person.dog.name}")
    public String name;
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }


}
