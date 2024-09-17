package com.is4tech.exercise.services;

import com.is4tech.exercise.entities.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
    void agregarPersona(Persona persona);
    List<Persona> listarPersonas();
    Optional<Persona> buscarPersona(Long id);
    void borrarPersona(Long id);
    void actualizarPersona(Persona persona, Long id) throws Exception;
}
