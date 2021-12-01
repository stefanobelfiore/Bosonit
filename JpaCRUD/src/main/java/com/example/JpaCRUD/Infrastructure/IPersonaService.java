package com.example.JpaCRUD.Infrastructure;

import com.example.JpaCRUD.Infrastructure.controller.dto.input.PersonaInputDto;
import com.example.JpaCRUD.Infrastructure.controller.dto.output.PersonaOutputDto;
import com.example.JpaCRUD.Persona;

import java.util.List;

@SuppressWarnings("SpellCheckingInspection")
public interface IPersonaService {
    public Persona add(Persona persona) throws Exception;
    public void del(Integer id) throws Exception;
    public PersonaOutputDto getPersonasById(Integer id) throws Exception;
    public List<PersonaOutputDto> getPersonasByName(String name) throws Exception;
    public List<PersonaOutputDto> getAllPersonas();
    public PersonaOutputDto editPersona(PersonaInputDto personaInputDto, Integer id) throws Exception;

}
