package com.a22ivancp.accesoadatos.model.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
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
@Embeddable
public class KeyCourse implements Serializable {
    @Column(name = "idTitle")
    private Integer idTitle;

    @Column(name = "idSubject")
    private Integer idSubject;

    @Column(name = "course")
    private Integer course;

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != KeyCourse.class)
            return false;
        if (this == o)
            return true;
        KeyCourse key = (KeyCourse) o;
        return Objects.equals(idTitle, key.idTitle) && Objects.equals(course, key.course) && Objects.equals(idSubject, key.idSubject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTitle, course, idSubject);
    }
}
