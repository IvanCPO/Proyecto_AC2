package com.a22ivancp.accesoadatos.model.dto;

import com.a22ivancp.accesoadatos.model.entities.Gender;
import com.a22ivancp.accesoadatos.model.entities.Student;
import javafx.beans.property.*;

import java.time.LocalDate;
public class DTOStudent implements DTO{
    private Integer idStudent;
    private StringProperty name;
    private StringProperty surname;
    private StringProperty dni;
    private ObjectProperty<Gender> gender;
    private ObjectProperty<LocalDate> dateNac;
    private StringProperty gmail;
    private IntegerProperty number;
//    private byte[] picture;
//    private Integer idDirection;
//    private String country;
//    private String province;
//    private String city;
//    private String street;
//    private String door;
//    private Integer cp;

    public DTOStudent(Student student) {
        this.idStudent = student.getIdStudent();
        this.name = new SimpleStringProperty(student.getName());
        this.surname = new SimpleStringProperty(student.getSurname());
        this.dni = new SimpleStringProperty(student.getDni());
        this.gender = new SimpleObjectProperty<Gender>(student.getGender());
        this.dateNac = new SimpleObjectProperty<LocalDate>(student.getDateNac());
        this.gmail = new SimpleStringProperty(student.getGmail());
        this.number = new SimpleIntegerProperty(student.getNumber());
//        this.picture = student.getPicture();
//        this.idDirection = student.getDirection().getIdDirection();
//        this.country = student.getDirection().getCountry();
//        this.province = student.getDirection().getProvince();
//        this.city = student.getDirection().getCity();
//        this.street = student.getDirection().getStreet();
//        this.door = student.getDirection().getDoor();
//        this.cp = student.getDirection().getCp();
    }
    public DTOStudent(){}


    @Override
    public Integer getId() {
        return idStudent;
    }
    public Integer getIdStudent() {
        return idStudent;
    }


    public void setIdStudent(int idStudent) {
        this.idStudent = (idStudent);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSurname() {
        return surname.get();
    }

    public StringProperty surnameProperty() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public String getDni() {
        return dni.get();
    }

    public StringProperty dniProperty() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni.set(dni);
    }

    public Gender getGender() {
        return gender.get();
    }

    public ObjectProperty<Gender> genderProperty() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender.set(gender);
    }

    public LocalDate getDateNac() {
        return dateNac.get();
    }

    public ObjectProperty<LocalDate> dateNacProperty() {
        return dateNac;
    }

    public void setDateNac(LocalDate dateNac) {
        this.dateNac.set(dateNac);
    }

    public String getGmail() {
        return gmail.get();
    }

    public StringProperty gmailProperty() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail.set(gmail);
    }

    public int getNumber() {
        return number.get();
    }

    public IntegerProperty numberProperty() {
        return number;
    }

    public void setNumber(int number) {
        this.number.set(number);
    }
}
