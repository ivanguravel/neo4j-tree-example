package com.ivzh.neo4j.example.tree.services;

import com.ivzh.neo4j.example.tree.converters.DocumentDtoConverter;
import com.ivzh.neo4j.example.tree.domain.Document;
import com.ivzh.neo4j.example.tree.dtos.DocumentDto;
import com.ivzh.neo4j.example.tree.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class DocumentService {

	private final DocumentRepository repository;

	@Autowired
	public DocumentService(DocumentRepository repository) {
		this.repository = repository;
	}

	public DocumentDto convertAndGet(Long id) {
		Document document = findById(id);
		return DocumentDtoConverter.convert(document);
	}

    @Transactional(readOnly = true)
    public Document findById(Long id) {
		Optional<Document> byId = repository.findById(id);
		Document result = byId
				.orElseThrow(() -> new IllegalArgumentException(String.format("can't find document by id %s", id)));
		System.out.println(result.getChildren().size());
		return result;
    }

	@Transactional
    public DocumentDto save(Long parentId, String name) {
		DocumentDto dto = new DocumentDto();
		dto.setName(name);

		Document forSave = new Document(name);
		if (parentId != null) {
			Document document = findById(parentId);
			forSave.setParent(document);
			document.addChild(forSave);
			dto.setId(repository.save(forSave).getId());
			repository.save(document);
		} else {
			dto.setId(repository.save(forSave).getId());
		}
		return dto;
	}
}
