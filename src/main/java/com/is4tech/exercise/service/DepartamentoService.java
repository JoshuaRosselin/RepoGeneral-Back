package com.is4tech.exercise.service;


import com.is4tech.exercise.model.Departamento;
import com.is4tech.exercise.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService implements IDepartamentosService{

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Override
    public List<Departamento> listarDepartamentos() {
        return departamentoRepository.findAll();
    }

    @Override
    public Departamento buscarDepartamentoId(Long id){
        return  departamentoRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean guardarDepartamento( Departamento departamento){
        if (!verificarDepartamento(departamento)){
            departamentoRepository.save(departamento);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void eliminarDepartamento(Departamento departamento){
        departamentoRepository.delete(departamento);
    }

    @Override
    public Departamento actualizarDepartamento(Departamento departamento){
        Departamento depapartamentoExistente = departamentoRepository.findById(departamento.getId())
                .orElseThrow(() -> new RuntimeException("Pais no encontrado"));
        depapartamentoExistente.setNombre(departamento.getNombre());
        return departamentoRepository.save(depapartamentoExistente);
    }

    @Override
    public Boolean verificarDepartamento(Departamento departamentoNuevo){
        List<Departamento> departamentos = listarDepartamentos();
        Boolean flag = false;

        for (Departamento departamento : departamentos){
            if (departamentoNuevo.getNombre().equalsIgnoreCase(departamento.getNombre()) && !departamentoNuevo.getId().equals(departamento.getId())){
                flag = true;
            }
        }
        return flag;
    }


}
