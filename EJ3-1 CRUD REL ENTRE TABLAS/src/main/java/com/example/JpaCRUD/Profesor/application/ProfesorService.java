package com.example.JpaCRUD.Profesor.application;

import com.example.JpaCRUD.Persona.domain.PersonaRepositorio;
import com.example.JpaCRUD.Profesor.application.mappers.ProfesorMapper;
import com.example.JpaCRUD.Profesor.domain.Profesor;
import com.example.JpaCRUD.Profesor.domain.ProfesorRepositorio;
import com.example.JpaCRUD.Profesor.infrastructure.controller.dto.input.ProfesorInputDto;
import com.example.JpaCRUD.Profesor.infrastructure.controller.dto.output.ProfesorOutputDto;
import com.example.JpaCRUD.Profesor.infrastructure.controller.dto.output.ProfesorYpersonOutputDto;
import com.example.JpaCRUD.Student.domain.StudentRepositorio;
import com.example.JpaCRUD.exception.NotFoundException;
import com.example.JpaCRUD.exception.UnprocesableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("SpellCheckingInspection")
@Component
public class ProfesorService implements IProfesorService{
    @Autowired
    StudentRepositorio studentRepositorio;

    @Autowired
    ProfesorMapper profesorMapper;

    @Autowired
    PersonaRepositorio personaRepositorio;

    @Autowired
    ProfesorRepositorio profesorRepositorio;


    @Override
    public ProfesorOutputDto add(ProfesorInputDto profesorInputDto) throws Exception{

        Profesor profesor = new Profesor();

        profesor.setPersona(personaRepositorio.findById(profesorInputDto.getIdPersona()).orElseThrow( () -> new NotFoundException("Persona no econtrada")));
        profesor.setComments(profesorInputDto.getComments());
        profesor.setBranch(profesorInputDto.getBranch());

        checkConditions(profesor);
        profesorRepositorio.save(profesor);

        ProfesorOutputDto profesorOutputDto= new ProfesorOutputDto();

        profesorOutputDto.setIdProfesor(profesor.getIdProfesor());
        profesorOutputDto.setIdPersona(profesor.getPersona().getId());
        profesorOutputDto.setComments(profesor.getComments());
        profesorOutputDto.setBranch(profesor.getBranch());

        return profesorOutputDto;
    }

    @Override
    public void del(Integer id) throws Exception {
        Profesor profesor = profesorRepositorio.findById(id).orElseThrow(()->new NotFoundException("No se ha podidio borrar el profesor, el "+id+" no existe"));
        profesorRepositorio.delete(profesor);
    }


    @Override
    public ProfesorOutputDto getProfesorById(Integer id) throws Exception {

        Profesor profesor = profesorRepositorio.findById(id).orElseThrow(()->new NotFoundException("Id numero "+id+" no existe"));

        ProfesorOutputDto profesorOutputDto= new ProfesorOutputDto();

        profesorOutputDto.setIdProfesor(profesor.getIdProfesor());
        profesorOutputDto.setIdPersona(profesor.getPersona().getId());
        profesorOutputDto.setComments(profesor.getComments());
        profesorOutputDto.setBranch(profesor.getBranch());

        return profesorOutputDto;
    }

    @Override
    public ProfesorYpersonOutputDto getProfesorYpersonById(Integer id) throws Exception {

        Profesor profesor = profesorRepositorio.findById(id).orElseThrow(()->new NotFoundException("Id numero "+id+" no existe"));

        ProfesorYpersonOutputDto profesorYpersonOutputDto = new ProfesorYpersonOutputDto();

        profesorYpersonOutputDto.setIdProfesor(profesor.getIdProfesor());
        profesorYpersonOutputDto.setComments(profesor.getComments());
        profesorYpersonOutputDto.setBranch(profesor.getBranch());
        profesorYpersonOutputDto.setIdPersona(profesor.getPersona().getId());
        profesorYpersonOutputDto.setUsuario(profesor.getPersona().getUsuario());
        profesorYpersonOutputDto.setPassword(profesor.getPersona().getPassword());
        profesorYpersonOutputDto.setName(profesor.getPersona().getName());
        profesorYpersonOutputDto.setSurname(profesor.getPersona().getSurname());
        profesorYpersonOutputDto.setCompanyEmail(profesor.getPersona().getCompanyEmail());
        profesorYpersonOutputDto.setPersonalEmail(profesor.getPersona().getPersonalEmail());
        profesorYpersonOutputDto.setCity(profesor.getPersona().getCity());
        profesorYpersonOutputDto.setActive(profesor.getPersona().isActive());
        profesorYpersonOutputDto.setCreatedDate(profesor.getPersona().getCreatedDate());
        profesorYpersonOutputDto.setImagenUrl(profesor.getPersona().getImagenUrl());
        profesorYpersonOutputDto.setTerminationDate(profesor.getPersona().getTerminationDate());

        return profesorYpersonOutputDto;
    }

    @Override
    public List<ProfesorOutputDto> getProfesoresByName(String name) throws Exception {
        List<ProfesorOutputDto> listaProfesores = profesorRepositorio.findAll().stream()
                .filter(names ->names.getPersona().getName().matches(name))
                .map(obj ->profesorMapper.toDTO(obj)).collect(Collectors.toList());

        return listaProfesores;
    }

    @Override
    public List<ProfesorOutputDto> getAllProfesores() {

        List<ProfesorOutputDto> listaProfesores = profesorRepositorio.findAll().stream().map(obj -> profesorMapper.toDTO(obj)).collect(Collectors.toList());

        return listaProfesores;
    }

    @Override
    public ProfesorOutputDto editProfesor(ProfesorInputDto profesorInputDto, Integer id) throws Exception {

        Profesor profesor = profesorRepositorio.findById(id).orElseThrow(()->new NotFoundException("No se ha podidio editar el profesor, el "+id+" no existe"));

        Profesor profesorEditado = profesorMapper.toEntity(profesorInputDto);
        profesorEditado.setIdProfesor(profesor.getIdProfesor());

        checkConditions(profesorEditado);
        profesorRepositorio.save(profesorEditado);

        ProfesorOutputDto profesorOutputDto = profesorMapper.toDTO(profesorEditado);

        return profesorOutputDto;
    }


    public void checkConditions(Profesor profesor) throws Exception {
        if (profesor.getPersona()==null)
            throw new UnprocesableException("El campo id persona no puede ser nulo");

        if(profesor.getComments() == null )
            throw new UnprocesableException("El campo comments no puede ser nulo");

        if (profesor.getBranch() == null)
            throw new UnprocesableException("Falta la rama, ese campo no puede ser nulo");

    }
}
