package com.example.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@SuppressWarnings("SpellCheckingInspection")
@Configuration
public class ConfigurationProgram {


    @PostConstruct
    public void printOne() {
        System.out.println("Hola desde clase inicial");
    }

}
