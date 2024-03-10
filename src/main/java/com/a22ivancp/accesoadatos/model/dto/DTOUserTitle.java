package com.a22ivancp.accesoadatos.model.dto;

import com.a22ivancp.accesoadatos.model.entities.KeyStudentTitle;
import com.a22ivancp.accesoadatos.model.entities.StudentTitles;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class DTOUserTitle implements DTO{

    private KeyStudentTitle key;
    private SimpleStringProperty title;
    private SimpleStringProperty yearStart;
    private SimpleStringProperty yearEnd;
    private SimpleBooleanProperty isNow;

    public DTOUserTitle(StudentTitles studentTitles) {
        this.key = studentTitles.getId();
        this.title = new SimpleStringProperty(studentTitles.getTitle().getName());
        this.yearStart = new SimpleStringProperty(studentTitles.getYearStart().toString());
        if (studentTitles.getYearEnd()==null)
            this.yearEnd = new SimpleStringProperty("---");
        else
            this.yearEnd = new SimpleStringProperty(studentTitles.getYearEnd().toString());
        this.isNow = new SimpleBooleanProperty(studentTitles.isNow());
    }

    @Override
    public Integer getId() {
        return 0;
    }

    public KeyStudentTitle getKey() {
        return key;
    }

    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public String getYearStart() {
        return yearStart.get();
    }

    public SimpleStringProperty yearStartProperty() {
        return yearStart;
    }

    public String getYearEnd() {
        return yearEnd.get();
    }

    public SimpleStringProperty yearEndProperty() {
        return yearEnd;
    }

    public boolean isIsNow() {
        return isNow.get();
    }

    public SimpleBooleanProperty isNowProperty() {
        return isNow;
    }

    @Override
    public String toString() {
        return "Title=" + title.get() +
                " [" + yearStart.get() +
                " - " + yearEnd.get() +
                "] --- cotinue? " + isNow.get();
    }
}
