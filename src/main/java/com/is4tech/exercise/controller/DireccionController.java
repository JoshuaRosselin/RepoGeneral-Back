package com.is4tech.exercise.controller;

import com.is4tech.exercise.entity.Direccion;
import com.is4tech.exercise.services.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/direction")
public class DireccionController {

    @Autowired
    DireccionService direccionService;

    @GetMapping("/getDireccion")
    public ArrayList<Direccion> getDireccion(){
        return this.direccionService.getDireccion();
    }

    @PostMapping("/postDireccion")
    public Direccion saveUser(@RequestBody Direccion direccion){
        return  this.saveUser(direccion);
    }

    @GetMapping(path = "/{idDireccion}")
    public Optional<Direccion> getDireccionById(@PathVariable("idDireccion") Long idDireccion){
        return  this.direccionService.getDirectionById(idDireccion);
    }

    @PutMapping(path = "/{idDireccion}")
    public Direccion updateDirectionById(@RequestBody Direccion request, @PathVariable("idDireccion") Long idDireccion ){
        return this.direccionService.updateDirecctionById(request, idDireccion);
    }

    @DeleteMapping(path = "/{direccionId}")
    public String  deleteById(@PathVariable("direccionId") Long direccionId){
        boolean ok = this.direccionService.deleteDireccion(direccionId);
        if (ok){
            return "Direccion con el id"+ direccionId +"deleted";
        }else{
            return "Tuvimos un error al momento de eliminar por Id";
        }
    }
}
