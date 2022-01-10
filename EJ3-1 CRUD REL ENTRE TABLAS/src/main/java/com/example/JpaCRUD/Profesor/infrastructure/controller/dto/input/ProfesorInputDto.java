package com.example.JpaCRUD.Profesor.infrastructure.controller.dto.input;

import lombok.Data;

@SuppressWarnings("SpellCheckingInspection")
@Data
public class ProfesorInputDto {

    private Integer idPersona;
    private String comments;
    private String branch;

}
