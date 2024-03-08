package com.a22ivancp.accesoadatos.model.dto;

import com.a22ivancp.accesoadatos.model.entities.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DTOStudent {
    private Integer idStudent;
    private String name;
    private String surname;
    private String dni;
    private Gender gender;
    private LocalDate dateNac;
    private String gmail;
    private int number;
    private byte[] picture;
    private String country;
    private String province;
    private String city;
    private String street;
    private String door;
    private Integer cp;

}
