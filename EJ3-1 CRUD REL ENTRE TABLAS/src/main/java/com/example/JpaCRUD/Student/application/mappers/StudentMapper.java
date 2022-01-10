package com.example.JpaCRUD.Student.application.mappers;


import com.example.JpaCRUD.Persona.domain.PersonaRepositorio;
import com.example.JpaCRUD.Student.domain.Student;
import com.example.JpaCRUD.Student.infrastructure.controller.dto.input.StudentInputDto;
import com.example.JpaCRUD.Student.infrastructure.controller.dto.output.StudentOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@SuppressWarnings("SpellCheckingInspection")
@Component
public class StudentMapper {

    @Autowired
    PersonaRepositorio personaRepositorio;

    public StudentOutputDto toDTO(Student student){
        StudentOutputDto studentOutputDto = new StudentOutputDto();
        studentOutputDto.setIdStudent(student.getIdStudent());
        studentOutputDto.setIdPersona(student.getPersona().getId());
        studentOutputDto.setNumHoursWeek(student.getNumHoursWeek());
        studentOutputDto.setComments(student.getComments());
        //studentOutputDto.setIdProfesor(student.getProfesor().getIdProfesor());
        studentOutputDto.setBranch(student.getBranch());
        return studentOutputDto;
    }


    public Student toEntity(StudentInputDto studentInputDto) throws Exception{

        Student student = new Student();

        if(studentInputDto.getIdPersona() != null){
            student.setPersona(personaRepositorio.findById(studentInputDto.getIdPersona()).orElseThrow( () -> new Exception(("Persona no econtrada"))));
        }

        if(studentInputDto.getNumHoursWeek() != null){
            student.setNumHoursWeek(studentInputDto.getNumHoursWeek());
        }

        if(studentInputDto.getComments() != null){
            student.setComments(studentInputDto.getComments());
        }
        /**if(studentInputDto.getIdProfesor() != null){
            student.getProfesor().setIdProfesor(studentInputDto.getIdProfesor());
        }*/
        if(studentInputDto.getBranch() != null){
            student.setBranch(studentInputDto.getBranch());
        }

        return student;
    }


}
