package com.is4tech.exercise.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "direccion")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "direccion_id")
    private int idDireccion;

    private String calle;

    @Column(name = "number_home")
    private String numberHome;

    @ManyToOne
    @JoinColumn(name = "id_municipio", referencedColumnName = "municipio_id")
    private Municipio municipio;
}
