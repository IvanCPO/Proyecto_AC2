package com.a22ivancp.accesoadatos.model.dao;

import com.a22ivancp.accesoadatos.model.JPAUtils;
import com.a22ivancp.accesoadatos.model.entities.School;
import com.a22ivancp.accesoadatos.model.entities.Student;
import jakarta.persistence.EntityManager;

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
        return em.createQuery("SELECT * FROM School", School.class).getResultList();
    }

    @Override
    public void addElement(School object) {
        em.persist(object);
    }

    @Override
    public void updateElement(School object) {
        em.merge(object);
    }

    @Override
    public void removeElement(School object) {
        em.remove(object);
    }

    @Override
    public void removeByID(int id) {
        List<School> list = getAll();
        for (School element : list){
            if (element.getIdSchool().equals(id)){
                em.remove(element);
            }
        }
    }
}
