package com.ivzh.neo4j.example.tree.domain;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.*;

@NodeEntity(label = "Document")
public class Document {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Document() {
        // Empty constructor required as of Neo4j API 2.0.5
    };

    public Document(String name) {
        this.name = name;
    }

    @Relationship(type = "parent")
    private Document parent;

    @Relationship(type = "children", direction = Relationship.OUTGOING)
    public Set<Document> children = new HashSet<>();

    public void addChild(Document document) {
        children.add(document);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Document getParent() {
        return parent;
    }

    public Set<Document> getChildren() {
        return children;
    }

    public void setParent(Document parent) {
        this.parent = parent;
    }

    public void setChildren(Set<Document> children) {
        this.children = children;
    }
}
