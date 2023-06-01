package com.example.BibliotecaBackend1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;
    private String namebook;
    private String authorbook;
    private Integer editionbook;
    private LocalDate publishyear;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamebook() {
        return namebook;
    }

    public void setNamebook(String namebook) {
        this.namebook = namebook;
    }

    public String getAuthorbook() {
        return authorbook;
    }

    public void setAuthorbook(String authorbook) {
        this.authorbook = authorbook;
    }

    public Integer getEditionbook() {
        return editionbook;
    }

    public void setEditionbook(Integer editionbook) {
        this.editionbook = editionbook;
    }

    public LocalDate getPublishyear() {
        return publishyear;
    }

    public void setPublishyear(LocalDate publishyear) {
        this.publishyear = publishyear;
    }
}
