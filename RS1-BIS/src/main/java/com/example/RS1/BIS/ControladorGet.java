package com.example.RS1.BIS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@SuppressWarnings("SpellCheckingInspection")
@RestController
public class ControladorGet {

    @Autowired
    PersonList personList;

    @GetMapping("persona/{id}")
    public Stream getPersonId(@PathVariable int id) {

        Stream mylist = personList.person.stream().filter(idp ->idp.getId()==id);

        return mylist;
    }
    @GetMapping("persona/nombre/{nombre}")
    public Stream getPersonNombre(@PathVariable String nombre) {

        Stream mylist = personList.person.stream().filter(idp ->idp.getName().equals(nombre));

        return mylist;
    }
}
