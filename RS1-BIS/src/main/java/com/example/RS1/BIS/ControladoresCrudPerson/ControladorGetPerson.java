package com.example.RS1.BIS.ControladoresCrudPerson;


import com.example.RS1.BIS.PersonInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@SuppressWarnings("SpellCheckingInspection")
@RestController
public class ControladorGetPerson {

    @Autowired
    PersonInterface personService;

    @GetMapping("persona/{id}")
    public Stream getPersonId(@PathVariable int id) {

        Stream mylist = personService.getPersonId(id);
        return mylist;
    }
    @GetMapping("persona/nombre/{nombre}")
    public Stream getPersonNombre(@PathVariable String nombre) {

        Stream mylist = personService.getPersonNombre(nombre);

        return mylist;
    }
}
