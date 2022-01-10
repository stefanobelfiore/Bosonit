package com.example.JpaCRUD.Student.application;

import com.example.JpaCRUD.Student.domain.Student;
import com.example.JpaCRUD.Student.infrastructure.controller.dto.input.StudentInputDto;
import com.example.JpaCRUD.Student.infrastructure.controller.dto.output.StudentOutputDto;
import com.example.JpaCRUD.Student.infrastructure.controller.dto.output.StudentYpersonOutputDto;

import java.util.List;

@SuppressWarnings("SpellCheckingInspection")
public interface IStudentService {

    public StudentOutputDto add(StudentInputDto studentInputDto) throws Exception;
    public void del(Integer id) throws Exception;
    public StudentOutputDto getStudentById(Integer id) throws Exception;
    public StudentYpersonOutputDto getStudentYpersonById(Integer id) throws Exception;
    public List<StudentOutputDto> getStudentsByName(String name) throws Exception;
    public List<StudentOutputDto> getAllStudents();
    public StudentOutputDto editStudent(StudentInputDto studentInputDto, Integer id) throws Exception;


}
