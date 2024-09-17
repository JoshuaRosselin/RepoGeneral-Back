package com.is4tech.exercise.repository;

import com.is4tech.exercise.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
