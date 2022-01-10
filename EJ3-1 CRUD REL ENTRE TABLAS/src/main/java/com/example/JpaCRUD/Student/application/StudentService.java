package com.example.JpaCRUD.Student.application;

import com.example.JpaCRUD.Persona.domain.PersonaRepositorio;
import com.example.JpaCRUD.Profesor.domain.ProfesorRepositorio;
import com.example.JpaCRUD.Student.application.mappers.StudentMapper;
import com.example.JpaCRUD.Student.domain.StudentRepositorio;
import com.example.JpaCRUD.Student.domain.Student;
import com.example.JpaCRUD.Student.infrastructure.controller.dto.input.StudentInputDto;
import com.example.JpaCRUD.Student.infrastructure.controller.dto.output.StudentOutputDto;
import com.example.JpaCRUD.Student.infrastructure.controller.dto.output.StudentYpersonOutputDto;
import com.example.JpaCRUD.exception.NotFoundException;
import com.example.JpaCRUD.exception.UnprocesableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("SpellCheckingInspection")
@Service
public class StudentService implements IStudentService{

    @Autowired
    StudentRepositorio studentRepositorio;

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    PersonaRepositorio personaRepositorio;

    @Autowired
    ProfesorRepositorio profesorRepositorio;


    @Override
    public StudentOutputDto add(StudentInputDto studentInputDto) throws Exception{

        System.out.println(studentRepositorio.findAll().stream().filter(obj -> obj.getPersona().getId() == studentInputDto.getIdPersona()).findFirst());
        studentRepositorio.findAll().stream().filter(obj -> obj.getPersona().getId() == studentInputDto.getIdPersona()).findFirst().map(obj ->studentMapper.toDTO(obj)).orElseThrow(()->new UnprocesableException("Este id Persona ya tiene un estudiante asociado"));

        Student student = new Student();

        student.setPersona(personaRepositorio.findById(studentInputDto.getIdPersona()).orElseThrow( () -> new NotFoundException("Persona no econtrada")));
        student.setNumHoursWeek(studentInputDto.getNumHoursWeek());
        student.setComments(studentInputDto.getComments());
        //student.setProfesor(profesorRepositorio.findById(studentInputDto.getIdProfesor()).orElseThrow(()-> new NotFoundException("Profesor no encontrado")));
        student.setBranch(studentInputDto.getBranch());

        checkConditions(student);
        studentRepositorio.save(student);

        StudentOutputDto studentOutputDto= new StudentOutputDto();

        studentOutputDto.setIdStudent(student.getIdStudent());
        studentOutputDto.setIdPersona(student.getPersona().getId());
        studentOutputDto.setNumHoursWeek(student.getNumHoursWeek());
        studentOutputDto.setComments(student.getComments());
        //studentOutputDto.setIdProfesor(student.getProfesor().getIdProfesor());
        studentOutputDto.setBranch(student.getBranch());

        return studentOutputDto;
    }

    @Override
    public void del(Integer id) throws Exception {
        Student student = studentRepositorio.findById(id).orElseThrow(()->new NotFoundException("No se ha podidio borrar el estudiante, el "+id+" no existe"));
        studentRepositorio.delete(student);
    }


    @Override
    public StudentOutputDto getStudentById(Integer id) throws Exception {

        Student student = studentRepositorio.findById(id).orElseThrow(()->new NotFoundException("Id numero "+id+" no existe"));

        StudentOutputDto studentOutputDto= new StudentOutputDto();

        studentOutputDto.setIdStudent(student.getIdStudent());
        studentOutputDto.setIdPersona(student.getPersona().getId());
        studentOutputDto.setNumHoursWeek(student.getNumHoursWeek());
        studentOutputDto.setComments(student.getComments());
        //studentOutputDto.setId_profesor(student.getProfesor().getIdProfesor());
        studentOutputDto.setBranch(student.getBranch());


        return studentOutputDto;
    }

    @Override
    public StudentYpersonOutputDto getStudentYpersonById(Integer id) throws Exception {

        Student student = studentRepositorio.findById(id).orElseThrow(()->new NotFoundException("Id numero "+id+" no existe"));

        StudentYpersonOutputDto studentYpersonOutputDto = new StudentYpersonOutputDto();

        studentYpersonOutputDto.setIdStudent(student.getIdStudent());
        studentYpersonOutputDto.setNumHoursWeek(student.getNumHoursWeek());
        studentYpersonOutputDto.setComments(student.getComments());
        studentYpersonOutputDto.setBranch(student.getBranch());
        studentYpersonOutputDto.setIdPersona(student.getPersona().getId());
        studentYpersonOutputDto.setUsuario(student.getPersona().getUsuario());
        studentYpersonOutputDto.setPassword(student.getPersona().getPassword());
        studentYpersonOutputDto.setName(student.getPersona().getName());
        studentYpersonOutputDto.setSurname(student.getPersona().getSurname());
        studentYpersonOutputDto.setCompanyEmail(student.getPersona().getCompanyEmail());
        studentYpersonOutputDto.setPersonalEmail(student.getPersona().getPersonalEmail());
        studentYpersonOutputDto.setCity(student.getPersona().getCity());
        studentYpersonOutputDto.setActive(student.getPersona().isActive());
        studentYpersonOutputDto.setCreatedDate(student.getPersona().getCreatedDate());
        studentYpersonOutputDto.setImagenUrl(student.getPersona().getImagenUrl());
        studentYpersonOutputDto.setTerminationDate(student.getPersona().getTerminationDate());

        return studentYpersonOutputDto;
    }

    @Override
    public List<StudentOutputDto> getStudentsByName(String name) throws Exception {
        List<StudentOutputDto> listaStudents = studentRepositorio.findAll().stream()
                .filter(names ->names.getPersona().getName().matches(name))
                .map(obj ->studentMapper.toDTO(obj)).collect(Collectors.toList());

        return listaStudents;
    }

    @Override
    public List<StudentOutputDto> getAllStudents() {

        List<StudentOutputDto> listaStudents = studentRepositorio.findAll().stream().map(obj -> studentMapper.toDTO(obj)).collect(Collectors.toList());

        return listaStudents;
    }

    @Override
    public StudentOutputDto editStudent(StudentInputDto studentInputDto, Integer id) throws Exception {

        Student student = studentRepositorio.findById(id).orElseThrow(()->new NotFoundException("No se ha podidio editar el estudiante, el "+id+" no existe"));

        Student studentEditado = studentMapper.toEntity(studentInputDto);
        studentEditado.setIdStudent(student.getIdStudent());

        checkConditions(studentEditado);
        studentRepositorio.save(studentEditado);

        StudentOutputDto studentOutputDto = studentMapper.toDTO(studentEditado);

        return studentOutputDto;
    }


    public void checkConditions(Student student) throws Exception {
        if (student.getPersona()==null)
            throw new UnprocesableException("El campo id persona no puede ser nulo");

        if(student.getNumHoursWeek() == 0 )
            throw new UnprocesableException("El campo  horas por semana no puede ser nulo");

        if (student.getComments() == null)
            throw new UnprocesableException("El campo Comments no puede ser nulo");

        /**if(student.getProfesor().getId_profesor() == null)
            throw new UnprocesableException("El campo Name no puede se nulo");*/

        if (student.getBranch() == null)
            throw new UnprocesableException("Falta la rama, ese campo no puede ser nulo");



    }

}
