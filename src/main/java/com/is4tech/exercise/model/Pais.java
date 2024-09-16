package com.is4tech.exercise.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "pais")
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pais_id")
    private Long id;
    private String nombre;
}
