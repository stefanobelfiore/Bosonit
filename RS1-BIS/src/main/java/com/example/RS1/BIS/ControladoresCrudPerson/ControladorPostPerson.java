package com.example.RS1.BIS.ControladoresCrudPerson;
import com.example.RS1.BIS.Person;
import com.example.RS1.BIS.PersonInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@SuppressWarnings("SpellCheckingInspection")
@RestController
public class ControladorPostPerson {
    @Autowired
    PersonInterface personService;


    @PostMapping("/persona")
    public Person postBody(@RequestBody Person body ) {

        int id = personService.getPersonLista().size();
        body.setId(id);
        personService.addPersonLista(body);
        return body;
    }
}


