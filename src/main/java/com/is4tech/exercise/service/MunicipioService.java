package com.is4tech.exercise.service;

import com.is4tech.exercise.model.Municipio;
import com.is4tech.exercise.repository.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MunicipioService {

    @Autowired
    private MunicipioRepository municipioRepository; // Inyección de dependencias

    public List<Municipio> getMunicipios() {
        return (List<Municipio>) municipioRepository.findAll();
    }

    public Optional<Municipio> getMunicipioId(Integer id) {
        return municipioRepository.findById(id);
    }

    public Municipio saveMunicipio(Municipio municipio) {
        return municipioRepository.save(municipio);
    }

    public void deleteMunicipio(Integer id) {
        municipioRepository.deleteById(id);
    }

    public void updateMunicipio(Municipio municipio, Integer id) throws Exception {
        if (!municipioRepository.existsById(id)) {
            throw new Exception("Municipio not found");
        }
        municipio.setId(id);
        municipioRepository.save(municipio);
    }
}
