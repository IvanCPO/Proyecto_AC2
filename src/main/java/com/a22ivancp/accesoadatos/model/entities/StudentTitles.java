package com.a22ivancp.accesoadatos.model.entities;

import jakarta.persistence.*;


@Entity
public class StudentTitles {
    @EmbeddedId
    private KeyStudentTitle id;
    @ManyToOne
    @MapsId("idStudent")
    @JoinColumn( name = "idStudent")
    private Student student;
    @ManyToOne
    @MapsId("idTitle")
    @JoinColumn( name = "idTitle")
    private Title title;
    private Integer yearStart;
    private Integer yearEnd;
}
