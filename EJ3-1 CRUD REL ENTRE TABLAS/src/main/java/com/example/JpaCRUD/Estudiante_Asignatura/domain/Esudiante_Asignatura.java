package com.example.JpaCRUD.Estudiante_Asignatura.domain;

import com.example.JpaCRUD.Student.domain.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("SpellCheckingInspection")

@Entity
@Data
@NoArgsConstructor
public class Esudiante_Asignatura {

    @Id
    @GeneratedValue
    @Column(name="ID_ESTUDIANTE_ASIGNATURA")
    Integer idEstudianteAsignatura;

    @ManyToOne
    @JoinColumn(name="ID_STUDENT")
    Student student;

    @ManyToMany(mappedBy="asignaturas")
    private Set<Student> students = new HashSet<Student>();


    @Column(name="ASIGNATURA")
    String asignatura;

    @Column(name="COMMENTS")
    String comments;

    @Column(name="INITIAL_DATE")
    Date initialDate;

    @Column(name="FINISH_DATE")
    Date finishDate;
    /**  id_asignatura String [pk, increment]
     id_student string [ref: > student.id_student] -- Un estudiante puede tener N asignaturas
     asignatura string  -- Ejemplo: HTML, Angular, SpringBoot...
     coments string
     initial_date date [not null], -- Fecha en que estudiante empezó a estudiar la asignatura
     finish_date date  -- Fecha en que estudiante termina de estudiar la asignatura
     */

}
