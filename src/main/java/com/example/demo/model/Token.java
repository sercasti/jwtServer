package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tokens")
public class Token {

    @Id
    private String id;    
    private String name;
    private String description;
    private String category;
    
    @PersistenceCreator
    public Token(String id, String name, String description, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public Token(String name, String description, String category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Token [id=" + id + ", name=" + name + ", description=" + description + ", category=" + category + "]";
    }
}