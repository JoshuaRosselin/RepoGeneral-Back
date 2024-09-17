package com.is4tech.exercise.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "type_document")
public class TypeDocument implements Serializable {
    @Id
    @Column(name = "type_document_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTypeDocument;

    @Column(name = "name_document", nullable = false)
    private String nameDocument; 
}
