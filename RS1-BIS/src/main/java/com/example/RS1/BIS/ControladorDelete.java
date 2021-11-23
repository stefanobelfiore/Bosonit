package com.example.RS1.BIS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

@SuppressWarnings("SpellCheckingInspection")
@RestController
public class ControladorDelete {

    @Autowired
    PersonList personList;

    @DeleteMapping("persona/{id}")
    public List deletePerson(@PathVariable int id){

        Stream mylist = personList.person.stream().filter(idp ->idp.getId() !=id);
        int indexToDelete = personList.person.indexOf(mylist);
        personList.person.remove(indexToDelete + 1);

        return personList.person;

    }
}
