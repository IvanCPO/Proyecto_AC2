package com.a22ivancp.accesoadatos.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTitle;
    @Column (length = 10)
    private String abbreviation;
    @Column (length = 150)
    private String name;

    @Column(length = 2)
    private Integer duration;

    //Lista para almacenar los cursos del alumno, acompañado con con sus respectivas asignaturas
    @OneToMany ( mappedBy = "title" )
    private List<Course> courses;

    //Proporciona una lista de estudiantes graduados en el titulo o que lo estan obteniendo
    @OneToMany(mappedBy = "title")
    private List<StudentTitles> students;

    public Title(String abbreviation, String name, Integer duration, List<Course> courses, List<StudentTitles> students) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.duration = duration;
        this.courses = courses;
        this.students = students;
    }

    public Title(String abbreviation, String name, Integer duration) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.duration = duration;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (idTitle!=null)
            sb.append("["+idTitle+"]   ");
        sb.append(name+"  ( "+abbreviation+" ):\tDuracion = "+duration+" anhos\n");
        if (courses!=null)
            sb.append("Lista Titulo_Cursos_Asisgnaturas: "+courses);
        if (students!=null)
            sb.append("Lista Estudiante_Graduados: "+students);
        return sb.toString();
    }
}
