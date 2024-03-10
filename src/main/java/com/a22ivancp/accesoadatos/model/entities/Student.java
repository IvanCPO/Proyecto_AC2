package com.a22ivancp.accesoadatos.model.entities;


import jakarta.persistence.*;
import javafx.scene.image.Image;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.*;
import java.nio.file.Files;
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
    @Basic(fetch = FetchType.LAZY)
    private byte[] picture;

    @Column(length = 9)
    private Integer number;

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

    public void setPicture(String directionFile) {
        try {
            File file = new File(directionFile);

            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];

            try {
                for (int readNum; (readNum = fis.read(buf)) != -1; ) {
                    bos.write(buf, 0, readNum); // Escribir el archivo de imagen en ByteArrayOutputStream
                }
            } finally {
                if (fis != null) {
                    fis.close();
                }
            }

            byte[] bytes = bos.toByteArray();
            picture= bytes;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

