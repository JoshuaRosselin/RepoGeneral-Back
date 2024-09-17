package com.is4tech.exercise.repository;

import com.is4tech.exercise.model.Municipio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipioRepository extends CrudRepository<Municipio, Integer> {

}
