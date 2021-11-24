package com.example.RS1.BIS.ControladoresCrudPerson;

import com.example.RS1.BIS.Person;
import com.example.RS1.BIS.PersonInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@SuppressWarnings("SpellCheckingInspection")
@RestController
public class ControladorPutPerson {

@Autowired
PersonInterface personService;

    @PutMapping("persona/{id}")
    public Stream putPerson(@PathVariable int id,  @RequestBody Person body){

        Stream mylist = personService.putPerson(id,body);

        return mylist;
    }
}
