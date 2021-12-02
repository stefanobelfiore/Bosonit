package com.example.JpaCRUD;

import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings("SpellCheckingInspection")
public interface PersonaRepositorio extends JpaRepository<Persona, Integer> {
}
