package com.example.JpaCRUD.Persona.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@SuppressWarnings("SpellCheckingInspection")
@Entity
@Data
@NoArgsConstructor
public class Persona {

    @Id
    @GeneratedValue
    @Column(name="ID_PERSONA")
    private int id;

    @Column(name="USUARIO")
    private String usuario;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="NAME")
    private String name;

    @Column(name="SURNAME")
    private String surname;

    @Column(name="COMPANY_EMAIL")
    private String companyEmail;

    @Column(name="PERSONAL_EMAIL")
    private String personalEmail;

    @Column(name="CITY")
    private String city;

    @Column(name="ACTIVE")
    private boolean active;

    @Column(name="CREATED_DATE")
    private Date createdDate;

    @Column(name="IMAGEN_URL")
    private String imagenUrl;

    @Column(name="TERMINATION_DATE")
    private Date terminationDate;


}
