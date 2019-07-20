package com.ivzh.neo4j.example.tree.dtos;

import java.util.List;

public class DocumentDto {

    private Long id;
    private String name;

    private List<DocumentDto> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DocumentDto> getChildren() {
        return children;
    }

    public void setChildren(List<DocumentDto> children) {
        this.children = children;
    }
}
