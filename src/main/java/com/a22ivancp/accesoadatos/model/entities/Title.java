package com.a22ivancp.accesoadatos.model.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTitle;
    private String abbreviation;
    private String name;
    private int duratiom;

    @ManyToMany
    private List<String> subjects;

}
