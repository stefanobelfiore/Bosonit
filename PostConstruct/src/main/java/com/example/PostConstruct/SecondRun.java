package com.example.PostConstruct;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@SuppressWarnings("SpellCheckingInspection")


@Component
public class SecondRun implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Soy la tercera clase");
        System.out.println(args[0] +" "+ args[1]+" "+args[2]);

    }
}
