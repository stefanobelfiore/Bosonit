package com.example.demo.Person1_2_3;

import org.springframework.stereotype.Service;

@SuppressWarnings("SpellCheckingInspection")

@Service
public class Person1 implements PersonService{

    String name;
    String lastName;
    int edad;

    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public int getEdad() {
        return edad;
    }
    
    @Override
    public void setNamePerson(String namePerson) {
        this.name = namePerson;
    }

    @Override
    public void setLastNamePerson(String lastNamePerson) {
        this.lastName = lastNamePerson;
    }

    @Override
    public void setEdadPerson(Integer edadPerson) {
        this.edad = edadPerson;
    }

}
