package com.is4tech.exercise.controller;

import com.is4tech.exercise.model.Persona;
import com.is4tech.exercise.service.PersonaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/persona")
@SecurityRequirement(name = "bearerAuth") //nombre del esquema que se debe utilizar en los endpoints
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/saludo")
    public ResponseEntity<String> holaserver(){
        return ResponseEntity.ok("Hola Server");
    }

    @PostMapping()
    public ResponseEntity<List<Persona>> agregarPersona(@RequestBody Persona persona) {
        personaService.agregarPersona(persona);
        return ResponseEntity.status(200).body(personaService.listarPersonas());
    }

    @GetMapping()
    public ResponseEntity<List<Persona>> obtenerPersonas() {
        return ResponseEntity.status(200).body(personaService.listarPersonas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Persona>> obtenerPersona(@PathVariable("id") Long id) {
        return ResponseEntity.status(200).body(personaService.buscarPersona(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Persona>> eliminarPersona(@PathVariable("id") Long id) {
        personaService.borrarPersona(id);
        return ResponseEntity.status(200).body(personaService.buscarPersona(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Persona>> modificarPersona(@RequestBody Persona persona, @PathVariable("id") Long id) throws Exception {
        personaService.actualizarPersona(persona, id);
        return ResponseEntity.status(200).body(personaService.buscarPersona(id));
    }
}
