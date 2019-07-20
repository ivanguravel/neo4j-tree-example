package com.ivzh.neo4j.example.tree.repositories;

import com.ivzh.neo4j.example.tree.domain.Document;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface DocumentRepository extends Neo4jRepository<Document, Long> {
}
