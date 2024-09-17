package com.is4tech.exercise.controller;


import com.is4tech.exercise.model.Departamento;
import com.is4tech.exercise.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public ResponseEntity<?> listarDepartamentos(){
        try{
            return ResponseEntity.ok(departamentoService.listarDepartamentos());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarDepartamentosId(@PathVariable Long id){
        try{
            return  ResponseEntity.ok(departamentoService.buscarDepartamentoId(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> guardarDepartamento(@RequestBody Departamento departamento){
        try{
            if (departamentoService.guardarDepartamento(departamento)){
                return ResponseEntity.ok().body("Departamento guardado");
            }else {
                return ResponseEntity.badRequest().body("Departamento no guardado");
            }

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public  ResponseEntity<?> editarDepartamento(@RequestBody Departamento departamentoNuevo, Long id){
        try {
            Departamento departamento = departamentoService.buscarDepartamentoId(id);
            departamento.setNombre(departamentoNuevo.getNombre());
            if (departamentoService.guardarDepartamento(departamento)){
                return ResponseEntity.ok().body("Departamento editado");
            }else {
                return ResponseEntity.badRequest().body("Departamento no editado");
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> eliminarDepartamento(Long id){
        try {
            Departamento departamento = departamentoService.buscarDepartamentoId(id);
            departamentoService.eliminarDepartamento(departamento);
            return ResponseEntity.ok().body("Departamento eliminado");

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }



}

