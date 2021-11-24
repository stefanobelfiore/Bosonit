package com.example.RS1.BIS.ControladoresCrudPerson;


import com.example.RS1.BIS.PersonInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@SuppressWarnings("SpellCheckingInspection")
@RestController
public class ControladorDeletePerson {

    @Autowired
    PersonInterface personService;

    @DeleteMapping("persona/{id}")
    public String deletePerson(@PathVariable int id){
<<<<<<< HEAD:RS1-BIS/src/main/java/com/example/RS1/BIS/ControladoresCrudPerson/ControladorDeletePerson.java
        
        personService.deletePerson(id);
=======

        personList.person.removeIf(person -> person.getId() == id);
>>>>>>> 54fc65d1a0f3f8d8c5e4f3e25df7edb08ba000b1:RS1-BIS/src/main/java/com/example/RS1/BIS/ControladorDelete.java

        return "La persona con el id "+ id + " ha sido eliminada";
    }

}
