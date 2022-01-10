package com.example.JpaCRUD.Persona.domain;

import com.example.JpaCRUD.Persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings("SpellCheckingInspection")
public interface PersonaRepositorio extends JpaRepository<Persona, Integer> {
}
