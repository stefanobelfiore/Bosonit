package com.example.JpaCRUD.Persona.infrastructure.controller.dto.input;

import lombok.Data;

import java.util.Date;

@SuppressWarnings("SpellCheckingInspection")
@Data
public class PersonaInputDto {

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
