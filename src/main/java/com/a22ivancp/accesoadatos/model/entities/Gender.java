package com.a22ivancp.accesoadatos.model.entities;

import lombok.Getter;

@Getter
public enum Gender {
    MALE("HOMBRE"), FEMALE("MUJER"), NO_BINARY("NO-BINARY");

    private String name;

    private Gender(String nombre){
        this.name=nombre;
    }

    public static Gender detectGenere(String nombre){
        switch (nombre.toUpperCase()){
            case "HOMBRE": return Gender.MALE;
            case "MUJER": return Gender.FEMALE;
            case "NO-BINARY": return Gender.NO_BINARY;
            default: return null;
        }
    }

}
