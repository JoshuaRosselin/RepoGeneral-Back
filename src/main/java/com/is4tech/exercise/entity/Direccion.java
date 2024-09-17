package com.is4tech.exercise.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "direccion", schema = "public")
public class Direccion {

    @Id
    @Column(name = "direccionId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer direccionId;

    @Column
    private String calle;

    @Column
    private String numberHome;

   // @ManyToOne
    //@JoinColumn(name = "municipio_id", nullable = false)
    private Integer idMunicipio;

}
