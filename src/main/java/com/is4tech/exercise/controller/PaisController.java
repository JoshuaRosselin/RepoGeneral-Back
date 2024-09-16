package com.is4tech.exercise.controller;

import com.is4tech.exercise.model.Pais;
import com.is4tech.exercise.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping
    public ResponseEntity<?> listarPaises(){
        try {
            return ResponseEntity.ok(paisService.listarPaises());
        }catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarPaisesPorId(@PathVariable  Long id){
        try {
            return ResponseEntity.ok(paisService.buscarPaisId(id));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> guardarPais(@RequestBody Pais pais){
        try{
            if(paisService.guardarPais(pais)){
               return ResponseEntity.ok().body("Pais guardado");
            }else{
                return ResponseEntity.ok().body("Pais no guardado");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> editarPais(@RequestBody Pais paisNuevo, Long id){
        try {
            Pais pais = paisService.buscarPaisId(id);
            pais.setNombre(paisNuevo.getNombre());
            if(paisService.guardarPais(pais)){
                return ResponseEntity.ok().body("Pais editado");
            }else{
                return ResponseEntity.badRequest().body("Pais no editado");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> eliminarPais(Long id){
        try{
            Pais pais = paisService.buscarPaisId(id);
            paisService.eliminarPais(pais);
            return ResponseEntity.ok().body("Pais eliminado");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
