package com.a22ivancp.accesoadatos.model.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

    @Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 4)
    private Integer idStudent;
    private String name;
    private String surname;
    private String gmail;
    private int number;
    @Enumerated
    private Gender gender;
    private LocalDate dateNac;
    @OneToOne
    @JoinColumn(name = "idDireccion")
    private Direction direction;
//    @ManyToOne
//    @JoinColumn(name = "IdTitle")
//    private Title actualTitle;
//    @ManyToMany
//    @JoinTable(name = "StudentTitles",
//    joinColumns = @JoinColumn(name = "idStudent"),
//    inverseJoinColumns = @JoinColumn(name = "idTitles"))
//    private List<Title> titles;

    @OneToMany(mappedBy = "student")
    private List<StudentTitles> titles;

}

