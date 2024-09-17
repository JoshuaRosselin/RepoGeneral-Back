package com.is4tech.exercise.service;

import com.is4tech.exercise.model.Persona;
import com.is4tech.exercise.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public void agregarPersona(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public List<Persona> listarPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public Optional<Persona> buscarPersona(Long id) {
        return personaRepository.findById(id);
    }

    @Override
    public void borrarPersona(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public void actualizarPersona(Persona persona, Long id) throws Exception {
        Optional<Persona> personaEncontrada = personaRepository.findById(id);
        if(personaEncontrada.isPresent()) {
            personaEncontrada.get().setNombre(persona.getNombre());
            personaRepository.save(personaEncontrada.get());
        }else{
            throw new Exception("Persona no encontrada");
        }
    }
}
