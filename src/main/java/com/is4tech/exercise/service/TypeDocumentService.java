package com.is4tech.exercise.service;

import com.is4tech.exercise.model.TypeDocument;
import java.util.List;
import java.util.Optional;

public interface TypeDocumentService {

    TypeDocument addTypeDocument(TypeDocument typeDocument);

    List<TypeDocument> listTypeDocuments();

    Optional<TypeDocument> getTypeDocumentById(Long id);

    void updateTypeDocument(Long id, TypeDocument typeDocument);

    void deleteTypeDocument(Long id);
}
