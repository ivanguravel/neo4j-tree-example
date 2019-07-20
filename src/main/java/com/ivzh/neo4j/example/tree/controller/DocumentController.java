package com.ivzh.neo4j.example.tree.controller;

import java.util.Map;

import com.ivzh.neo4j.example.tree.dtos.DocumentDto;
import com.ivzh.neo4j.example.tree.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/documents")
public class DocumentController {

	private final DocumentService documentService;

	@Autowired
	public DocumentController(DocumentService documentService) {
		this.documentService = documentService;
	}

	@GetMapping
	public DocumentDto get(@RequestParam(value = "id",required = false) Long id) {
		return documentService.convertAndGet(id);
	}

    @PostMapping
	public DocumentDto save(@RequestParam(value = "parentId",required = false) Long parentId,
								@RequestParam(value = "name") String name) {
		return documentService.save(parentId, name);
	}
}
