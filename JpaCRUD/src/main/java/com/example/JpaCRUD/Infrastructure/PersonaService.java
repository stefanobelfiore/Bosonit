package com.example.JpaCRUD.Infrastructure;

import com.example.JpaCRUD.Infrastructure.controller.dto.PersonaMapper;
import com.example.JpaCRUD.Infrastructure.controller.dto.input.PersonaInputDto;
import com.example.JpaCRUD.Infrastructure.controller.dto.output.PersonaOutputDto;
import com.example.JpaCRUD.Persona;
import com.example.JpaCRUD.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@SuppressWarnings("SpellCheckingInspection")
public class PersonaService implements IPersonaService{

    @Autowired
    PersonaRepositorio personaRepositorio;

    @Autowired
    PersonaMapper personaMapper;

    @Override
    public Persona add(Persona persona) throws Exception{

        checkConditions(persona);
        personaRepositorio.save(persona);

        return persona;
    }

    @Override
    public void del(Integer id) throws Exception {
        Persona persona = personaRepositorio.findById(id).orElseThrow(()->new Exception("Id no encontrado"));
        personaRepositorio.delete(persona);
    }


    @Override
    public PersonaOutputDto getPersonasById(Integer id) throws Exception {

        Persona persona = personaRepositorio.findById(id).orElseThrow(()->new Exception("Id no encontrado"));

        PersonaOutputDto personaOutputDto= new PersonaOutputDto();

        personaOutputDto.setId(persona.getId());
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

    @Override
    public List<PersonaOutputDto> getPersonasByName(String name) throws Exception {
        List<PersonaOutputDto> listaPersonas = personaRepositorio.findAll().stream()
                .filter(namep ->namep.getName().matches(name))
                .map(obj ->personaMapper.toDTO(obj)).collect(Collectors.toList());

        return listaPersonas;
    }

    @Override
    public List<PersonaOutputDto> getAllPersonas() {

        List<PersonaOutputDto> listaPersonas = personaRepositorio.findAll().stream().map(obj -> personaMapper.toDTO(obj)).collect(Collectors.toList());

        return listaPersonas;
    }

    @Override
    public PersonaOutputDto editPersona(PersonaInputDto personaInputDto, Integer id) throws Exception {

        Persona persona = personaRepositorio.findById(id).orElseThrow(()->new Exception("Id no encontrado"));

        Persona personaEditada = personaMapper.toEntity(personaInputDto);
        personaEditada.setId(persona.getId());
        personaRepositorio.save(personaEditada);

        PersonaOutputDto personaOutputDto = personaMapper.toDTO(personaEditada);

        return personaOutputDto;
    }


    public void checkConditions(Persona persona) throws Exception {
        if (persona.getUsuario()==null)
            throw new Exception("El campo Usuario no puede ser nulo");

        if(persona.getUsuario().length() > 10 || persona.getUsuario().length() < 6 )
            throw new Exception("El campo  Usuario tiene que tener una longitud entre 6 y 10 carácteres");

        if (persona.getPassword() == null)
            throw new Exception("El campo Password no puede ser nulo");

        if(persona.getName() == null)
            throw new Exception("El campo Name no puede se nulo");

        if (persona.getCompanyEmail() == null)
            throw new Exception("El campo Company email no puede ser nulo");

        if (persona.getPersonalEmail() == null)
            throw new Exception("El campo Personal email no puede ser nulo");

        if(persona.getCity() == null)
            throw new Exception("El campo City no puede ser nulo");

        if(persona.getCreatedDate() == null)
            throw new Exception("El campo Created date no puede ser nulo");


    }


}



