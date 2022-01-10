package com.example.JpaCRUD.Profesor.application;

import com.example.JpaCRUD.Persona.infrastructure.controller.dto.input.PersonaInputDto;
import com.example.JpaCRUD.Persona.infrastructure.controller.dto.output.PersonaOutputDto;
import com.example.JpaCRUD.Profesor.domain.Profesor;
import com.example.JpaCRUD.Profesor.infrastructure.controller.dto.input.ProfesorInputDto;
import com.example.JpaCRUD.Profesor.infrastructure.controller.dto.output.ProfesorOutputDto;
import com.example.JpaCRUD.Profesor.infrastructure.controller.dto.output.ProfesorYpersonOutputDto;
import com.example.JpaCRUD.Student.infrastructure.controller.dto.output.StudentYpersonOutputDto;

import java.util.List;

@SuppressWarnings("SpellCheckingInspection")
public interface IProfesorService {

    public ProfesorOutputDto add(ProfesorInputDto profesorInputDto) throws Exception;
    public void del(Integer id) throws Exception;
    public ProfesorOutputDto getProfesorById(Integer id) throws Exception;
    public ProfesorYpersonOutputDto getProfesorYpersonById(Integer id) throws Exception;
    public List<ProfesorOutputDto> getProfesoresByName(String name) throws Exception;
    public List<ProfesorOutputDto> getAllProfesores();
    public ProfesorOutputDto editProfesor(ProfesorInputDto profesorInputDto, Integer id) throws Exception;

}
