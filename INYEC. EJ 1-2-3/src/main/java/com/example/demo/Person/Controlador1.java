package com.example.demo.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


@SuppressWarnings("SpellCheckingInspection")

@RestController
public class Controlador1 {

    @Autowired
    Persona persona;

    @GetMapping("/controlador1/addPersona")
    public String getPersona(@RequestHeader String name,@RequestHeader String poblacion,@RequestHeader int edad){
        persona.setName(name);
        persona.setEdad(edad);
        persona.setPoblacion(poblacion);
        return persona.getName() + persona.getEdad() + persona.getPoblacion();
    }
}
