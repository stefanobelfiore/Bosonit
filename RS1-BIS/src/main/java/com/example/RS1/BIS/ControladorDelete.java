package com.example.RS1.BIS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Iterator;

@SuppressWarnings("SpellCheckingInspection")
@RestController
public class ControladorDelete {

    @Autowired
    PersonList personList;

    @DeleteMapping("persona/{id}")
    public String deletePerson(@PathVariable int id){
<<<<<<< HEAD
        
=======

>>>>>>> 4074796ac5851553d94aada8ac1629370c0515b2
        personList.person.removeIf(person -> person.getId() == id);

        return "La persona con el id "+ id + " ha sido eliminada";
    }

}



/**Iterator<PersonInterface> iter = personList.person.iterator();
 for(PersonInterface person: personList.person) {
 if(person.getId() == id){
 personList.person.remove(person);
 System.out.println(person.getId());
 }
 }*/