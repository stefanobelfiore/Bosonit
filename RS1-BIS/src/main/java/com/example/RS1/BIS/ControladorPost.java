package com.example.RS1.BIS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;


@SuppressWarnings("SpellCheckingInspection")
@RestController
public class ControladorPost {
    @Autowired
    PersonInterface personService;

    @Autowired
    PersonList personList;

    @PostMapping("/persona")
    public List postBody(@RequestBody Person body ) {
        personService = body;
        int id = personList.person.size();
        body.setId(id);
        personList.person.add(personService);
        return personList.person;
    }
}


