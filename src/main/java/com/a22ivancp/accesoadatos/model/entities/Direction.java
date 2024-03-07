package com.a22ivancp.accesoadatos.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Direction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDirection;
    private String country;
    private String province;
    private String city;
    private String street;
    private String door;
    private Integer cp;
}
