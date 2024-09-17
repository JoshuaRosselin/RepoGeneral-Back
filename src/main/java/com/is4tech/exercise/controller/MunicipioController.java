package com.is4tech.exercise.controller;

import com.is4tech.exercise.model.Municipio;
import com.is4tech.exercise.service.MunicipioService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/municipio")
@SecurityRequirement(name = "bearerAuth") //nombre del esquema que se debe utilizar en los endpoints
public class MunicipioController {

    @Autowired
    private MunicipioService municipioService;

    @GetMapping("/list")
    public List<Municipio> getMunicipios() {
        return municipioService.getMunicipios();
    }

    @GetMapping("/listId/{municipioId}")
    public ResponseEntity<String> getMunicipioId(@PathVariable("municipioId") Integer id) {
        try{
            Optional<Municipio> municipio = municipioService.getMunicipioId(id);
            if (municipio.isPresent()) {
                return ResponseEntity.status(200).body("Municipio encontrado: " + municipio);
            }
            return ResponseEntity.status(404).body("Municipio no encontrado");
        }catch (Exception e){
            return ResponseEntity.status(500).body("Error al buscar municipio" + e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> createMunicipio(@RequestBody Municipio municipio) {
        try {
            Municipio createdMunicipio = municipioService.saveMunicipio(municipio);
            return ResponseEntity.status(201).body("Municipio agregado con exito" + createdMunicipio);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al agregar un municipio");
        }
    }


    @PutMapping("/update/{municipioId}")
    public ResponseEntity<String> updateMunicipio(@PathVariable("municipioId") Integer id, @RequestBody Municipio municipio) {
        try {
            municipioService.updateMunicipio(municipio, id);
            return ResponseEntity.status(201).body("Municipio actualizado con exito");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar municipio");
        }
    }

    @DeleteMapping("/delete/{municipioId}")
    public ResponseEntity<String> deleteMunicipio(@PathVariable("municipioId") Integer id) {
        try{
            if (municipioService.getMunicipioId(id).isPresent()){
                municipioService.deleteMunicipio(id);
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.status(404).body("Departamento no encontrado");
        }catch (Exception e){
            return ResponseEntity.status(500).body("Error al eliminar" + e.getMessage());
        }
    }
}
