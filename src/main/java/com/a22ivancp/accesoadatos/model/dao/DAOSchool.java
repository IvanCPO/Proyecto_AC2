package com.a22ivancp.accesoadatos.model.dao;

import com.a22ivancp.accesoadatos.model.JPAUtils;
import com.a22ivancp.accesoadatos.model.dto.DTOSchool;
import com.a22ivancp.accesoadatos.model.entities.School;
import jakarta.persistence.EntityManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class DAOSchool implements DAO<School> {
    private EntityManager em;
    public DAOSchool(){
        em = JPAUtils.getEntityManager();
    }
    @Override
    public School getByID(int id) {
        return em.find(School.class,id);
    }

    @Override
    public List<School> getAll() {
        return em.createQuery("SELECT s FROM School s", School.class).getResultList();
    }

    @Override
    public void addElement(School object) {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }

    @Override
    public void updateElement(School object) {
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
    }

    @Override
    public void removeElement(School object) {
        em.getTransaction().begin();
        em.remove(object);
        em.getTransaction().commit();
    }

    @Override
    public void removeByID(int id) {
        List<School> list = getAll();
        for (School element : list){
            if (element.getIdSchool().equals(id)){
                em.getTransaction().begin();
                em.remove(element);
                em.getTransaction().commit();
                break;
            }
        }
    }
    public ObservableList<DTOSchool> getAllDTOSchool(){
        List<School> schools = getAll();
        ObservableList<DTOSchool> list = FXCollections.observableArrayList();
        for (School school : schools){
            list.add(new DTOSchool(school));
        }
        return list;
    }
}
