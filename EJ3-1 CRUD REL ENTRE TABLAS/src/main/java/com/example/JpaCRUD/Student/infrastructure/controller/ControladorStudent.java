package com.example.JpaCRUD.Student.infrastructure.controller;

import com.example.JpaCRUD.Persona.domain.PersonaRepositorio;
import com.example.JpaCRUD.Student.application.IStudentService;
import com.example.JpaCRUD.Student.domain.Student;
import com.example.JpaCRUD.Student.infrastructure.controller.dto.input.StudentInputDto;
import com.example.JpaCRUD.Student.infrastructure.controller.dto.output.StudentOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SpellCheckingInspection")
@RestController
public class ControladorStudent {

    @Autowired
    IStudentService studentService;


    @GetMapping("student/id/{id}")
    public Object getStudentId(@PathVariable Integer id, @RequestParam(defaultValue = "simple") String outputType) throws Exception{

        Object student = new Object();

        if(outputType.matches("simple")) {
            student = studentService.getStudentById(id);
            return student;
        }
        if(outputType.matches("full")){
            student = studentService.getStudentYpersonById(id);
            return student;
        }

        return student;
    }

    @GetMapping("student/name/{student}")
    public List<StudentOutputDto> getStudentbyName(@PathVariable String student) throws Exception{

        return studentService.getStudentsByName(student);
    }

    @GetMapping("allstudents")
    public List<StudentOutputDto> getStudents(){

        List<StudentOutputDto> listaStudents = studentService.getAllStudents();

        return listaStudents;
    }

    @DeleteMapping("students/delete/{id}")
    public String deleteStudent(@PathVariable int id) throws Exception{
        studentService.del(id);
        return "El estudiante con el id "+ id + " ha sido eliminado";
    }

    @PutMapping("student/edit/{id}")
    public StudentOutputDto editStudent(@RequestBody StudentInputDto studentInputDto, @PathVariable int id) throws Exception {

        StudentOutputDto studentEditado = studentService.editStudent(studentInputDto,id);

        return studentEditado;
    }


    @PostMapping("addStudent")
    public StudentOutputDto addStudent(@RequestBody StudentInputDto studentInputDto) throws Exception{

        return studentService.add(studentInputDto);
    }

}
