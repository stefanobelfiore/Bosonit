package com.example.JpaCRUD.Profesor.infrastructure.controller.dto.output;

import lombok.Data;

@SuppressWarnings("SpellCheckingInspection")
@Data
public class ProfesorOutputDto {

    private Integer idProfesor;
    private Integer idPersona;
    private String comments;
    private String branch;

}
