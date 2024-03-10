package com.a22ivancp.accesoadatos.model.dto;

import com.a22ivancp.accesoadatos.model.entities.Course;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DTOCourse implements DTO{
    private Integer id;
    private StringProperty nameSubject;
    private IntegerProperty course;

    public DTOCourse(Course c){
        id = c.getKey().hashCode();
        nameSubject = new SimpleStringProperty(c.getSubject().getName());
        course = new SimpleIntegerProperty(c.getCourse());
    }
    @Override
    public Integer getId() {
        return id;
    }

    public String getNameSubject() {
        return nameSubject.get();
    }

    public StringProperty nameSubjectProperty() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject.set(nameSubject);
    }

    public int getCourse() {
        return course.get();
    }

    public IntegerProperty courseProperty() {
        return course;
    }

    public void setCourse(int course) {
        this.course.set(course);
    }

    @Override
    public String toString() {
        return nameSubject.get() +
                ", course=" + course.get();
    }
}
