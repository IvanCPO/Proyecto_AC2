package com.a22ivancp.accesoadatos.model.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSchool;
    private String name;
    private String director;
    private String urlSchool;
    private String gmail;
    private int mobilePhoneNumber;
    @ManyToMany
    @JoinTable (name = "Matriculados",
    joinColumns = @JoinColumn(name = "idCentro"),
    inverseJoinColumns = @JoinColumn(name = "idAlumno"))
    private List<Student> enrolled;
    @ManyToMany
    @JoinTable(name = "School_Module",
    joinColumns = @JoinColumn(name = "idSchool"),
    inverseJoinColumns = @JoinColumn(name = "idTitle"))
    private List<Title> titles;
}
