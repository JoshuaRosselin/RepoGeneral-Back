package com.is4tech.exercise.service;

import com.is4tech.exercise.model.Departamento;

import java.util.List;

public interface IDepartamentosService {
    public List<Departamento> listarDepartamentos();

    public Departamento buscarDepartamentoId(Long id);

    public Boolean guardarDepartamento(Departamento departamento);

    public void eliminarDepartamento(Departamento departamento);

    public Departamento actualizarDepartamento(Departamento departamento);

    public Boolean verificarDepartamento(Departamento departamentoNuevo);

}
