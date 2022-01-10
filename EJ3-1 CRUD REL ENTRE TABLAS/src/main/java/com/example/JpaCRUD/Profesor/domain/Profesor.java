package com.example.JpaCRUD.Profesor.domain;

import com.example.JpaCRUD.Persona.domain.Persona;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@SuppressWarnings("SpellCheckingInspection")
@Entity
@Data
@NoArgsConstructor
public class Profesor {

    @Id
    @GeneratedValue
    @Column(name="ID_PROFESOR")
    Integer idProfesor;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_PERSONA")
    Persona persona;

    @Column(name="COMMENTS")
    String comments;

    @Column(name="BRANCH")
    String branch;

    /**id_profesor string [pk, increment]
    id_persona string [ref:- persona.id_persona] -- Relación OneToOne con la tabla persona.
    coments string
    branch string [not null] -- Materia principal que imparte. Por ejemplo: Front*/


}
