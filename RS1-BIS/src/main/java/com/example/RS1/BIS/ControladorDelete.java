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
        
        for (Iterator<PersonInterface> it = personList.person.iterator(); it.hasNext();) {
            PersonInterface person = it.next();
            if (person.getId() == id){
                it.remove();
            }
        }

        return "La persona con el id "+ id + "ha sido eliminada";
    }

}
