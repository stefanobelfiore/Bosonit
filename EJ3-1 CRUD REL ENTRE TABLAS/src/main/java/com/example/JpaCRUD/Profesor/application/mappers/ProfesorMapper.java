package com.example.JpaCRUD.Profesor.application.mappers;

import com.example.JpaCRUD.Persona.domain.PersonaRepositorio;
import com.example.JpaCRUD.Profesor.domain.Profesor;
import com.example.JpaCRUD.Profesor.infrastructure.controller.dto.input.ProfesorInputDto;
import com.example.JpaCRUD.Profesor.infrastructure.controller.dto.output.ProfesorOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@SuppressWarnings("SpellCheckingInspection")
@Component
public class ProfesorMapper {

    @Autowired
    PersonaRepositorio personaRepositorio;

    public ProfesorOutputDto toDTO(Profesor profesor){

        ProfesorOutputDto profesorOutputDto = new ProfesorOutputDto();

        profesorOutputDto.setIdProfesor(profesor.getIdProfesor());
        profesorOutputDto.setIdPersona(profesor.getPersona().getId());
        profesorOutputDto.setComments(profesor.getComments());
        profesorOutputDto.setBranch(profesor.getBranch());
        return profesorOutputDto;
    }


    public Profesor toEntity(ProfesorInputDto profesorInputDto) throws Exception{

        Profesor profesor = new Profesor();

        if(profesorInputDto.getIdPersona() != null){
            profesor.setPersona(personaRepositorio.findById(profesorInputDto.getIdPersona()).orElseThrow( () -> new Exception(("Persona no econtrada"))));
        }

        if(profesorInputDto.getComments() != null){
            profesor.setComments(profesorInputDto.getComments());
        }

        if(profesorInputDto.getComments() != null){
            profesor.setBranch(profesorInputDto.getBranch());
        }


        return profesor;
    }

}
