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
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSubject;
    @Column(length = 70)
    private String name;

    //Proporciona una lista de titulos que tienen esta asignatura y en que curso esta
    @OneToMany ( mappedBy = "subject" )
    private List<Course> courses;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (idSubject!=null)
            sb.append("["+idSubject+"]   ");
        sb.append(name);
        if (courses!=null)
            sb.append("\nLista Titulos_Cursos_Asisgnatura: "+courses);
        return sb.toString();
    }
}
