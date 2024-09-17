package com.is4tech.exercise.controller;

import com.is4tech.exercise.model.TypeDocument;
import com.is4tech.exercise.service.TypeDocumentService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/typeDocument")
public class TypeDocumentController {

    @Autowired
    private TypeDocumentService typeDocumentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> addDocument(@RequestBody TypeDocument typeDocument) {
        try {
            System.out.print("**************************" + typeDocument);
            TypeDocument savedTypeDocument = typeDocumentService.addTypeDocument(typeDocument); 
            System.out.print("**************************" + savedTypeDocument);           
            return new ResponseEntity<>(savedTypeDocument, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al guardar el documento: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<?> listTypeDocuments() {
        try {
            return new ResponseEntity<>(typeDocumentService.listTypeDocuments(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener la lista de documentos: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTypeDocumentById(@PathVariable Long id) {
        try {
            Optional<TypeDocument> typeDocument = typeDocumentService.getTypeDocumentById(id);
            if (typeDocument.isPresent()) {
                return new ResponseEntity<>(typeDocument.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Documento no encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener el documento: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> updateTypeDocument(@PathVariable Long id, @RequestBody TypeDocument typeDocument) {
        try {
            typeDocumentService.updateTypeDocument(id, typeDocument);
            return new ResponseEntity<>("Documento actualizado correctamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el documento: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("typeDocument/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteTypeDocument(@PathVariable Long id) {
        try {
            typeDocumentService.deleteTypeDocument(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el documento: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
