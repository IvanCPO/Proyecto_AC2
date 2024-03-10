package com.a22ivancp.accesoadatos.model.dto;

import com.a22ivancp.accesoadatos.model.entities.Title;
import javafx.beans.property.SimpleStringProperty;

public class DTOTitle implements DTO{
    private Integer idTitle;
    private SimpleStringProperty abrev;
    private SimpleStringProperty name;
    public DTOTitle() {

    }

    public DTOTitle(Title title) {
        this.idTitle =(title.getIdTitle());
        this.abrev = new SimpleStringProperty(title.getAbbreviation());
        this.name = new SimpleStringProperty(title.getName());
    }

    @Override
    public Integer getId() {
        return idTitle;
    }

    public Integer getIdTitle() {
        return idTitle;
    }

    public void setIdTitle(int idTitle) {
        this.idTitle = (idTitle);
    }

    public String getAbrev() {
        return abrev.get();
    }

    public SimpleStringProperty abrevProperty() {
        return abrev;
    }

    public void setAbrev(String abrev) {
        this.abrev.set(abrev);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    @Override
    public String toString() {
        return "[" + abrev.get() +
                "] " + name.get();
    }
}
