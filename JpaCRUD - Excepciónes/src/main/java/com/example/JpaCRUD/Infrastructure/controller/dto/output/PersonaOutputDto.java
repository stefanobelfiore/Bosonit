package com.example.JpaCRUD.Infrastructure.controller.dto.output;

import com.example.JpaCRUD.Persona;
import lombok.Data;

import java.util.Date;
import java.util.List;

@SuppressWarnings("SpellCheckingInspection")
@Data
public class PersonaOutputDto {


    private int id;
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
