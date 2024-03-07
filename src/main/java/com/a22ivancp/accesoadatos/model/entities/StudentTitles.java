package com.a22ivancp.accesoadatos.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    @Column(nullable = false)
    private Integer yearStart;
    @Column(nullable = true)
    private Integer yearEnd;
    private boolean isNow;
}
