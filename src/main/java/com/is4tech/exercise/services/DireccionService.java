package com.is4tech.exercise.services;

import com.is4tech.exercise.entity.Direccion;
import com.is4tech.exercise.repository.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class DireccionService {

    @Autowired
    DireccionRepository direccionRepository;

    public ArrayList<Direccion> getDireccion(){
        return (ArrayList<Direccion>) direccionRepository.findAll();
    }

    public Direccion saveDirection(Direccion direccion){
        return direccionRepository.save(direccion);
    }

    public Optional<Direccion> getDirectionById(Long idDireccion){
        return direccionRepository.findById(idDireccion);
    }


    public Direccion updateDirecctionById(Direccion request, Long idDireccion){
        Direccion direccion = direccionRepository.findById(idDireccion).get();

        direccion.setCalle(request.getCalle());
        direccion.setIdMunicipio(request.getIdMunicipio());
        direccion.setNumberHome(request.getNumberHome());

        return direccion;
    }

    public Boolean deleteDireccion(Long idDireccion){
        try{
            direccionRepository.deleteById(idDireccion);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
