package com.example.JpaCRUD.Infrastructure.controller.dto;

import com.example.JpaCRUD.Infrastructure.controller.dto.input.PersonaInputDto;
import com.example.JpaCRUD.Infrastructure.controller.dto.output.PersonaOutputDto;
import com.example.JpaCRUD.Persona;
import org.springframework.stereotype.Component;


@Component
public  class  PersonaMapper {

   public PersonaOutputDto toDTO(Persona persona){
        PersonaOutputDto personaOutputDto = new PersonaOutputDto();
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

    public Persona toEntity(PersonaInputDto personaInputDto){

        Persona persona = new Persona();

         if(personaInputDto.getUsuario() != null){
              persona.setUsuario(personaInputDto.getUsuario());
         }
         if(personaInputDto.getPassword() != null){
              persona.setPassword(personaInputDto.getPassword());
         }
         if(personaInputDto.getName() != null){
              persona.setName(personaInputDto.getName());
         }
         if(personaInputDto.getSurname() != null){
              persona.setSurname(personaInputDto.getSurname());
         }
         if(personaInputDto.getCompanyEmail() != null){
              persona.setCompanyEmail(personaInputDto.getCompanyEmail());
         }
         if(personaInputDto.getPersonalEmail() != null){
              persona.setPersonalEmail(personaInputDto.getPersonalEmail());
         }
         if(personaInputDto.getCity() != null){
              persona.setCity(personaInputDto.getCity());
         }
         if(personaInputDto.isActive()){
              persona.setActive(personaInputDto.isActive());
         }
         if(personaInputDto.getCreatedDate() != null){
              persona.setCreatedDate(personaInputDto.getCreatedDate());
         }
         if(personaInputDto.getImagenUrl() != null){
              persona.setImagenUrl(personaInputDto.getImagenUrl());
         }
         if(personaInputDto.getTerminationDate() != null){
              persona.setTerminationDate(personaInputDto.getTerminationDate());
         }
        return persona;
    }


}
