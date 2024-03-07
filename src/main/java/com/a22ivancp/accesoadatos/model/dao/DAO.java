package com.a22ivancp.accesoadatos.model.dao;

import java.util.List;

public interface DAO <T> {

    T getByID(int id);
    List<T> getAll();
    void addElement(T object);
    void updateElement(T object);
    void removeElement(T object);
    void removeByID(int id);

}
