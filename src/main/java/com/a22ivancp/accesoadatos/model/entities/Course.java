package com.a22ivancp.accesoadatos.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Course {
    @EmbeddedId
    private KeyCourse key;

    @ManyToOne
    @MapsId("idTitle")
    @JoinColumn(name = "idTitle")
    private Title title;

    @Column(name = "course", insertable=false, updatable=false)
    private Integer course;

    @ManyToOne
    @MapsId("idSubject")
    @JoinColumn(name = "idSubject")
    private Subject subject;

}