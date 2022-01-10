package com.example.JpaCRUD.Profesor.domain;

import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings("SpellCheckingInspection")
public interface ProfesorRepositorio extends JpaRepository<Profesor,Integer> {
}
