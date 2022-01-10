package com.example.JpaCRUD.Persona.infrastructure;

import com.example.JpaCRUD.Persona.application.IPersonaService;
import com.example.JpaCRUD.Persona.domain.PersonaRepositorio;
import com.example.JpaCRUD.Persona.infrastructure.controller.dto.input.PersonaInputDto;
import com.example.JpaCRUD.Persona.infrastructure.controller.dto.output.PersonaOutputDto;
import com.example.JpaCRUD.Persona.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("SpellCheckingInspection")
@RestController
public class ControladorPersona {

    @Autowired
    IPersonaService personaService;

    @Autowired
    PersonaRepositorio personaRepositorio;

    @GetMapping("id/{id}")
    public PersonaOutputDto getPersonaId(@PathVariable Integer id) throws Exception{
        PersonaOutputDto persona = personaService.getPersonasById(id) ;

        return persona;
    }

    @GetMapping("usuario/{usuario}")
    public List<PersonaOutputDto> getPersonaUser(@PathVariable String usuario) throws Exception{

        return personaService.getPersonasByName(usuario);
    }

    @GetMapping("personas")
    public List<PersonaOutputDto> getPersonas(){

        List<PersonaOutputDto> listaPersonas = personaService.getAllPersonas();

        return listaPersonas;
    }

    @DeleteMapping("delete/{id}")
    public String deletePersona(@PathVariable int id) throws Exception{
        personaService.del(id);
        return "La persona con el id "+ id + " ha sido eliminada";
    }

    @PutMapping("edit/{id}")
    public PersonaOutputDto editP(@RequestBody PersonaInputDto personaInputDto, @PathVariable int id) throws Exception {

           PersonaOutputDto personaEditada = personaService.editPersona(personaInputDto,id);

        return personaEditada;
    }


    @PostMapping("addPersona")
    public PersonaOutputDto addPersona(@RequestBody PersonaInputDto personaInputDto) throws Exception{

        return personaService.add(personaInputDto);
    }
}


