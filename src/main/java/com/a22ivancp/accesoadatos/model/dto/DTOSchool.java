package com.a22ivancp.accesoadatos.model.dto;

import com.a22ivancp.accesoadatos.model.entities.School;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DTOSchool implements DTO {
    private Integer idSchool;
    private StringProperty name;
    private StringProperty director;
    private StringProperty urlSchool;
    private StringProperty gmail;
    private IntegerProperty mobilePhoneNumber;
//    private IntegerProperty idDireccion;
//    private StringProperty country;
//    private StringProperty province;
//    private StringProperty city;
//    private StringProperty street;
//    private IntegerProperty cp;
//    private List<Student> listStudents;
//    private List<Title> listTitles;

    public DTOSchool() {
    }

    public DTOSchool(School school){
        idSchool =(school.getIdSchool());
        name = new SimpleStringProperty(school.getName());
        director =  new SimpleStringProperty(school.getDirector());
        urlSchool =  new SimpleStringProperty(school.getUrlSchool());
        gmail = new SimpleStringProperty(school.getGmail());
        mobilePhoneNumber = new SimpleIntegerProperty(school.getMobilePhoneNumber());
//        if (school.getDirection().getIdDirection()!=null) {
//            idDireccion = new SimpleIntegerProperty(school.getDirection().getIdDirection());
//            country = new SimpleStringProperty(school.getDirection().getCountry());
//            province = new SimpleStringProperty(school.getDirection().getProvince());
//            city = new SimpleStringProperty(school.getDirection().getCity());
//            street = new SimpleStringProperty(school.getDirection().getStreet());
//            cp = new SimpleIntegerProperty(school.getDirection().getCp());
//        }
//        listStudents = school.getEnrolled();
//        listTitles = school.getTitles();
    }

    @Override
    public Integer getId() {
        return idSchool;
    }

    public Integer getIdSchool() {
        return idSchool;
    }

//    public IntegerProperty idSchoolProperty() {
//        return idSchool;
//    }

//    public void setIdSchool(int idSchool) {
//        this.idSchool.set(idSchool);
//    }
    public void setIdSchool(int idSchool) {
        this.idSchool = (idSchool);
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

    public String getDirector() {
        return director.get();
    }

    public StringProperty directorProperty() {
        return director;
    }

    public void setDirector(String director) {
        this.director.set(director);
    }

    public String getUrlSchool() {
        return urlSchool.get();
    }

    public StringProperty urlSchoolProperty() {
        return urlSchool;
    }

    public void setUrlSchool(String urlSchool) {
        this.urlSchool.set(urlSchool);
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

    public int getMobilePhoneNumber() {
        return mobilePhoneNumber.get();
    }

    public IntegerProperty mobilePhoneNumberProperty() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(int mobilePhoneNumber) {
        this.mobilePhoneNumber.set(mobilePhoneNumber);
    }
}
