package com.example.JpaCRUD.Student.infrastructure.controller.dto.input;

import lombok.Data;

@SuppressWarnings("SpellCheckingInspection")
@Data
public class StudentInputDto {

    private Integer idPersona;
    private Integer numHoursWeek;
    private String comments;
    private Integer idProfesor;
    private String branch;

}
