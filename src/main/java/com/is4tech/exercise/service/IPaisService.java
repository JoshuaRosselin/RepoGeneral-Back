package com.is4tech.exercise.service;

import com.is4tech.exercise.model.Pais;

import java.util.List;

public interface IPaisService {
    public List<Pais> listarPaises();

    public Pais buscarPaisId(Long id);

    public Boolean guardarPais(Pais pais);

    public void eliminarPais(Pais pais);

    public Pais actualizarPais(Pais pais);

    public Boolean verificarPaisDuplicado(Pais paisNuevo);
}
