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
public class KeyStudentTitle implements Serializable {
    @Column(name = "idStudent")
    private Integer idStudent;

    @Column(name = "idTitle")
    private Integer idTitle;

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != KeyStudentTitle.class)
            return false;
        if (this == o)
            return true;
        KeyStudentTitle key = (KeyStudentTitle) o;
        return Objects.equals(idStudent, key.idStudent) && Objects.equals(idTitle, key.idTitle);
    }

    @Override
    public int hashCode() {
        return idStudent * 3 + idTitle * 5 + 33;
    }
}
