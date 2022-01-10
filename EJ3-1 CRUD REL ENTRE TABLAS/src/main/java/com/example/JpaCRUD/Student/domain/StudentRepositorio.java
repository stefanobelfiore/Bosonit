package com.example.JpaCRUD.Student.domain;

import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings("SpellCheckingInspection")

public interface StudentRepositorio extends JpaRepository<Student, Integer> {
}
