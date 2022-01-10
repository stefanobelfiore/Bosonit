package com.example.JpaCRUD.Persona.application;

import com.example.JpaCRUD.Persona.infrastructure.controller.dto.input.PersonaInputDto;
import com.example.JpaCRUD.Persona.infrastructure.controller.dto.output.PersonaOutputDto;
import com.example.JpaCRUD.Persona.domain.Persona;

import java.util.List;

@SuppressWarnings("SpellCheckingInspection")
public interface IPersonaService {
    public PersonaOutputDto add(PersonaInputDto personaInputDto) throws Exception;
    public void del(Integer id) throws Exception;
    public PersonaOutputDto getPersonasById(Integer id) throws Exception;
    public List<PersonaOutputDto> getPersonasByName(String name) throws Exception;
    public List<PersonaOutputDto> getAllPersonas();
    public PersonaOutputDto editPersona(PersonaInputDto personaInputDto, Integer id) throws Exception;

}
