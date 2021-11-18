package com.example.demo.Person;

import lombok.Data;
import org.springframework.stereotype.Service;

@SuppressWarnings("SpellCheckingInspection")
@Service
@Data
public class Persona {

    String name;
    String poblacion;
    int edad;

}
