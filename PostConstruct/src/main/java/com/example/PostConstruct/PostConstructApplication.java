package com.example.PostConstruct;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class PostConstructApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostConstructApplication.class, args);
		}
}
