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
    private int duration;

    @ManyToMany
    @JoinTable(name = "Title_Subjects",
    joinColumns = @JoinColumn(name = "idTitle"),
    inverseJoinColumns = @JoinColumn(name = "idSubject"))
    private List<Subject> subjects;
//
//    @OneToMany(mappedBy = "title")
//    private List<StudentTitles> students;

}
