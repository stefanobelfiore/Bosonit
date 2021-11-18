package com.example.demo.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SuppressWarnings("SpellCheckingInspection")
@RestController
public class Controlador2 {

    @Autowired
    Persona persona;

    @GetMapping("/controlador2/addPersona")
    public String getPersona(){

        return persona.getName() + persona.getEdad() * 2 + persona.getPoblacion();
    }
}
