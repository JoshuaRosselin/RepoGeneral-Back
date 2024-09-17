package com.is4tech.exercise.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Long idPersona;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "id_tipo_documento")
    private Long idTipoDocumento;

    @Column(name = "id_direccion")
    private Long idDireccion;
}
