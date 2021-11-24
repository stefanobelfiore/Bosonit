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
        
        personService.deletePerson(id);

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