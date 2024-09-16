package com.is4tech.exercise.service;

import com.is4tech.exercise.model.Pais;
import com.is4tech.exercise.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisService implements IPaisService {

    @Autowired
    private PaisRepository paisRepository;

    @Override
    public List<Pais> listarPaises() {
        return paisRepository.findAll();
    }

    @Override
    public Pais buscarPaisId(Long id) {
        return paisRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean guardarPais(Pais pais) {
        if(!verificarPaisDuplicado(pais)){
            paisRepository.save(pais);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void eliminarPais(Pais pais) {
        paisRepository.delete(pais);

    }

    @Override
    public Pais actualizarPais(Pais pais){
        Pais paisExistente = paisRepository.findById(pais.getId())
                .orElseThrow(() -> new RuntimeException("Pais no encontrado"));
        paisExistente.setNombre(pais.getNombre());
        return paisRepository.save(paisExistente);
    }

    @Override
    public Boolean verificarPaisDuplicado(Pais paisNuevo) {
        List<Pais> paises = listarPaises();
        Boolean flag = false;

        for (Pais pais : paises) {
            if(paisNuevo.getNombre().equalsIgnoreCase(pais.getNombre()) && !paisNuevo.getId().equals(pais.getId())){
                flag = true;
            }
        }

        return flag;
    }
}
