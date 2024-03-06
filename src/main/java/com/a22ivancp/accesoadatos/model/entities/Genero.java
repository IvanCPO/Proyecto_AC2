package com.a22ivancp.accesoadatos.model.entities;

public enum Genero {
    MALE("HOMBRE"), FEMALE("MUJER"), NO_BINARY("HELICOPTERO");
    private String nombre;
    private Genero(String nombre){
        this.nombre=nombre;
    }
    public static Genero detectGenere(String nombre){
        switch (nombre){
            case "HOMBRE": return Genero.MALE;
            case "MUJER": return Genero.FEMALE;
            case "HELICOPTERO": return Genero.NO_BINARY;
            default: return null;
        }
    }
}
