package com.example.RS1.BIS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@SuppressWarnings("SpellCheckingInspection")
@RestController
public class ControladorPut {

    @Autowired
    PersonInterface personService;

    @Autowired
    PersonList personList;

    @PutMapping("persona/{id}")
    public Stream putPerson(@PathVariable int id,  @RequestBody Person body){
        personService = body;
        Stream mylist = personList.person.stream()
                .filter(idp ->idp.getId()==id)
                .map(obj -> {
                    if(body.getName() != null){obj.setName(body.getName());}
                    if(body.getPopulation() != null ){obj.setPoblation(body.getPopulation());}
                    if(body.getAge() != 0){obj.setAge(body.getAge());}
                    return obj
                ;});

        return mylist;
    }
}
