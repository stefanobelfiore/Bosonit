package com.example.JpaCRUD.Profesor.infrastructure.controller.dto.output;

import lombok.Data;

import java.util.Date;

@SuppressWarnings("SpellCheckingInspection")
@Data
public class ProfesorYpersonOutputDto {

    private Integer idProfesor;
    private String comments;
    private String branch;
    private Integer idPersona;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String companyEmail;
    private String personalEmail;
    private String city;
    private boolean active;
    private Date createdDate;
    private String imagenUrl;
    private Date terminationDate;

}
