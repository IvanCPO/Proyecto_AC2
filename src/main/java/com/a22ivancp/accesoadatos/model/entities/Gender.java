package com.a22ivancp.accesoadatos.model.entities;

public enum Gender {
    MALE("HOMBRE"), FEMALE("MUJER"), NO_BINARY("HELICOPTERO");
    private String nombre;
    private Gender(String nombre){
        this.nombre=nombre;
    }
    public static Gender detectGenere(String nombre){
        switch (nombre){
            case "HOMBRE": return Gender.MALE;
            case "MUJER": return Gender.FEMALE;
            case "HELICOPTERO": return Gender.NO_BINARY;
            default: return null;
        }
    }
}
