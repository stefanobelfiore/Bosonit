package com.example.JpaCRUD.Student.infrastructure.controller.dto.output;

import lombok.Data;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("SpellCheckingInspection")
@RestController
@Data
public class StudentOutputDto {

    private Integer idStudent;
    private Integer idPersona;
    private Integer numHoursWeek;
    private String comments;
    private Integer idProfesor;
    private String branch;


}
