package com.example.JpaCRUD.Student.domain;

import com.example.JpaCRUD.Estudiante_Asignatura.domain.Estudiante_Asigntura_Repositorio;
import com.example.JpaCRUD.Estudiante_Asignatura.domain.Esudiante_Asignatura;
import com.example.JpaCRUD.Persona.domain.Persona;
import com.example.JpaCRUD.Profesor.domain.Profesor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("SpellCheckingInspection")

@Entity
@Data
@NoArgsConstructor
public class Student {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        @Column(name="ID_STUDENT")
        Integer idStudent;

        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "ID_PERSONA")
        Persona persona;

        @Column(name = "HORAS_POR_SEMANAS")
        int numHoursWeek;


        @Column(name = "COMENTARIOS")
        String comments;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "ID_PROFESOR")
        Profesor profesor;

        @ManyToMany
        @JoinTable(name = "ASIGNATURAS_ESTUDIANTES",
                joinColumns = { @JoinColumn(name = "FK_STUDENT") },
                inverseJoinColumns = { @JoinColumn(name = "FK_ESTUDIANTE_ASIGNATURA") })
        private Set<Esudiante_Asignatura> asignaturas = new HashSet<Esudiante_Asignatura>();


        @Column(name = "rama")
        String branch;

        /**id_student string [pk, increment]
         id_persona string [ref:-  persona.id_persona] -- Relación OneToOne con la tabla persona.
         num_hours_week int   [not null] -- Número de horas semanales del estudiante en formación
         coments string
         id_profesor string [ref: > profesor.id_profesor] -- Un estudiante solo puede tener un profesor.
         branch string [not null] -- Rama principal delestudiante (Front, Back, FullStack)*/

    }


