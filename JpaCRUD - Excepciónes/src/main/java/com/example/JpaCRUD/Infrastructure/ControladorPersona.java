package com.example.JpaCRUD.Infrastructure;

import com.example.JpaCRUD.Infrastructure.controller.dto.input.PersonaInputDto;
import com.example.JpaCRUD.Infrastructure.controller.dto.output.PersonaOutputDto;
import com.example.JpaCRUD.Persona;
import com.example.JpaCRUD.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("SpellCheckingInspection")
@RestController
public class ControladorPersona {

    @Autowired
    IPersonaService personaService;

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

        Persona persona = new Persona();

        persona.setUsuario(personaInputDto.getUsuario());
        persona.setPassword(personaInputDto.getPassword());
        persona.setName(personaInputDto.getName());
        persona.setSurname(personaInputDto.getSurname());
        persona.setCompanyEmail(personaInputDto.getCompanyEmail());
        persona.setPersonalEmail(personaInputDto.getPersonalEmail());
        persona.setCity(personaInputDto.getCity());
        persona.setActive(personaInputDto.isActive());
        persona.setCreatedDate(personaInputDto.getCreatedDate());
        persona.setImagenUrl(personaInputDto.getImagenUrl());
        persona.setTerminationDate(personaInputDto.getTerminationDate());

        personaService.add(persona);

        PersonaOutputDto personaOutputDto= new PersonaOutputDto();
        personaOutputDto.setId(persona.getId());
        personaOutputDto.setName(persona.getName());
        personaOutputDto.setUsuario(persona.getUsuario());
        personaOutputDto.setPassword(persona.getPassword());
        personaOutputDto.setName(persona.getName());
        personaOutputDto.setSurname(persona.getSurname());
        personaOutputDto.setCompanyEmail(persona.getCompanyEmail());
        personaOutputDto.setPersonalEmail(persona.getPersonalEmail());
        personaOutputDto.setCity(persona.getCity());
        personaOutputDto.setActive(persona.isActive());
        personaOutputDto.setCreatedDate(persona.getCreatedDate());
        personaOutputDto.setImagenUrl(persona.getImagenUrl());
        personaOutputDto.setTerminationDate(persona.getTerminationDate());

        return personaOutputDto;
    }
}


