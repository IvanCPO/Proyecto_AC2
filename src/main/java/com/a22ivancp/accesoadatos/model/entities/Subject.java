package com.a22ivancp.accesoadatos.model.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSubject;
    private String name;

    @ManyToMany(mappedBy = "subjects")
    private List<Title> titles;
}
