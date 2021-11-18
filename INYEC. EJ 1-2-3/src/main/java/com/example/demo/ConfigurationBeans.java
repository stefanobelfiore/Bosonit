package com.example.demo;


import com.example.demo.Ciudad.CiudadInterface;
import com.example.demo.Ciudad.CiudadInterfaceImp;
import com.example.demo.Person1_2_3.Person1;
import com.example.demo.Person1_2_3.Person2;
import com.example.demo.Person1_2_3.Person3;
import com.example.demo.Person1_2_3.PersonService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("SpellCheckingInspection")
@Configuration
public class ConfigurationBeans {

    @Bean
    CiudadInterface ciudadesClass(){
        CiudadInterface c = new CiudadInterfaceImp();
        ArrayList<String> ciudadesIniciales =  new ArrayList<>();
        ArrayList <Integer> habitantesIniciales = new ArrayList<>();
        Collections. addAll(ciudadesIniciales, "Roma","Napoli","Pisa","Milano","Parma");
        Collections. addAll(habitantesIniciales, 1200000,2500000,200000,2000000,250000);
        c.setCiudades(ciudadesIniciales);
        c.setNumeroHabitantes(habitantesIniciales);

        return c;
    }

    @Bean
    @Qualifier("Person1")
    public PersonService person1ServiceConfiguration(){
        PersonService person1Returned = new Person1();
        person1Returned.setNamePerson("Matteo");
        person1Returned.setLastNamePerson("Cassano");
        person1Returned.setEdadPerson(36);

        return person1Returned;
    }
    @Bean
    @Qualifier("Person2")
    public PersonService person2ServiceConfiguration(){
        PersonService person2Returned = new Person2();
        person2Returned.setNamePerson("Alessio");
        person2Returned.setLastNamePerson("Curcio");
        person2Returned.setEdadPerson(34);
        return person2Returned;
    }
    @Bean
    @Qualifier("Person3")
    public PersonService person3ServiceConfiguration(){
        PersonService person3Returned = new Person3();
        person3Returned.setNamePerson("Khalid");
        person3Returned.setLastNamePerson("Selloum");
        person3Returned.setEdadPerson(26);
        return person3Returned;
    }

}
