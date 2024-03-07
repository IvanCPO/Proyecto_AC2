package com.a22ivancp.accesoadatos.model.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 4)
    private Integer idStudent;
    @Column(length = 20)
    private String name;
    @Column(length = 100)
    private String surname;
    @Column(length = 60)
    private String gmail;
    @Lob
    private byte[] picture;
    @Column(length = 9)
    private int number;
    @Column(length = 9)
    private String dni;
    @Enumerated(EnumType.STRING)
    @Column(length = 9)
    private Gender gender;
    private LocalDate dateNac;
    @OneToOne
    @JoinColumn(name = "idDireccion",nullable = true)
    private Direction direction;

    @OneToMany(mappedBy = "student")
    private List<StudentTitles> titles;

}

