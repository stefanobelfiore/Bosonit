package com.example.demo.Person1_2_3;

import com.example.demo.Person1_2_3.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("SpellCheckingInspection")
@RestController
public class ControladorPersonas123 {

    @Autowired
    @Qualifier("Person1")
    PersonService personService1;

    @Autowired
    @Qualifier("Person2")
    PersonService personService2;

    @Autowired
    @Qualifier("Person3")
    PersonService personService3;

    @GetMapping("/controladorPersonas123/{bean}")
    public PersonService printPersona1(@PathVariable String bean){

        if(bean.matches("bean1")){
          return personService1;
        };
        if(bean.matches("bean2")){
            return personService2;
        };
        if(bean.matches("bean3")){
            return personService3;
        };

        return null;

    }

}
