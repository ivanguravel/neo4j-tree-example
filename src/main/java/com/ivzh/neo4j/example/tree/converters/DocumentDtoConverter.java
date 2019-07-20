package com.ivzh.neo4j.example.tree.converters;

import com.ivzh.neo4j.example.tree.domain.Document;
import com.ivzh.neo4j.example.tree.dtos.DocumentDto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DocumentDtoConverter {

    private DocumentDtoConverter() {}

    public static DocumentDto convert(Document document) {
        DocumentDto dto = from(document);
        dto.setChildren(from(document.getChildren()));
        return dto;
    }

    public static DocumentDto from(Document document) {
        DocumentDto dto  = new DocumentDto();

        dto.setId(document.getId());
        dto.setName(document.getName());

        return dto;
    }

    private static List<DocumentDto> from(Set<Document> documents) {
        return documents.parallelStream().map(DocumentDtoConverter::from).collect(Collectors.toList());
    }
}
