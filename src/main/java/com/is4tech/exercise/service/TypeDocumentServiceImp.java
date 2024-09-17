package com.is4tech.exercise.service;

import com.is4tech.exercise.entity.TypeDocument;
import com.is4tech.exercise.repository.TypeDocumentRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeDocumentServiceImp implements TypeDocumentService {

    @Autowired
    private TypeDocumentRepository typeDocumentRepository;

    @Override
    public TypeDocument addTypeDocument(TypeDocument typeDocument) {
        return typeDocumentRepository.save(typeDocument);
    }

    @Override
    public List<TypeDocument> listTypeDocuments() {
        return typeDocumentRepository.findAll();
    }

    @Override
    public Optional<TypeDocument> getTypeDocumentById(Long id) {
        return typeDocumentRepository.findById(id);
    }

    @Override
    public void updateTypeDocument(Long id, TypeDocument typeDocument) {
        Optional<TypeDocument> existingTypeDocument = typeDocumentRepository.findById(id);
        if (existingTypeDocument.isPresent()) {
            TypeDocument updatedDocument = existingTypeDocument.get();
            updatedDocument.setNameDocument(typeDocument.getNameDocument());
            typeDocumentRepository.save(updatedDocument);
        }
    }

    @Override
    public void deleteTypeDocument(Long id) {
        typeDocumentRepository.deleteById(id);
    }
}
