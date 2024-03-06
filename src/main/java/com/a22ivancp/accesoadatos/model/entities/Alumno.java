package com.a22ivancp.accesoadatos.model.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

    @Entity
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 4)
    private int idAlumno;
    private String nombre;
    private String apellido;
    private Genero genero;
    private LocalDate fechaNac;
    private Direccion direccion;
    private Centro centro;
    private Titulo tituloActual;
    private List<Titulo> titulos;

    public Alumno() {
    }

    public Alumno(int idAlumno, String nombre, String apellido, Genero genero, LocalDate fechaNac, Direccion direccion, Centro centro, Titulo tituloActual, List<Titulo> titulos) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.fechaNac = fechaNac;
        this.direccion = direccion;
        this.centro = centro;
        this.tituloActual = tituloActual;
        this.titulos = titulos;
    }

    public Alumno(String nombre, String apellido, Genero genero, LocalDate fechaNac, Direccion direccion, Centro centro, Titulo tituloActual) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.fechaNac = fechaNac;
        this.direccion = direccion;
        this.centro = centro;
        this.tituloActual = tituloActual;
    }

    public Alumno(String nombre, String apellido, Genero genero, LocalDate fechaNac, Direccion direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.fechaNac = fechaNac;
        this.direccion = direccion;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Centro getCentro() {
        return centro;
    }

    public void setCentro(Centro centro) {
        this.centro = centro;
    }

    public Titulo getTituloActual() {
        return tituloActual;
    }

    public void setTituloActual(Titulo tituloActual) {
        this.tituloActual = tituloActual;
    }

    public List<Titulo> getTitulos() {
        return titulos;
    }

    public void setTitulos(List<Titulo> titulos) {
        this.titulos = titulos;
    }

    @Override
    public String toString() {
        return "[" + idAlumno +
                "] " + nombre +
                " " + apellido + ':' +
                " genero=" + genero +
                ", cumpleaños=" + fechaNac +
                ", direccion=" + direccion +
                ", centro=" + centro +
                ", titulo=" + tituloActual;
    }
}

