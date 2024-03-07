package com.a22ivancp.accesoadatos.model.dao;

import com.a22ivancp.accesoadatos.model.JPAUtils;
import com.a22ivancp.accesoadatos.model.entities.Subject;
import com.a22ivancp.accesoadatos.model.entities.Title;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DAOSubject implements DAO<Subject> {
    private EntityManager em;
    public DAOSubject(){
        em = JPAUtils.getEntityManager();
    }
    @Override
    public Subject getByID(int id) {
        return em.find(Subject.class,id);
    }

    @Override
    public List<Subject> getAll() {
        return em.createQuery("SELECT * FROM Subject", Subject.class).getResultList();
    }

    @Override
    public void addElement(Subject object) {
        em.persist(object);
    }

    @Override
    public void updateElement(Subject object) {
        em.merge(object);
    }

    @Override
    public void removeElement(Subject object) {
        em.remove(object);
    }

    @Override
    public void removeByID(int id) {
        List<Subject> list = getAll();
        for (Subject subject : list){
            if (subject.getIdSubject().equals(id)){
                em.remove(subject);
            }
        }
    }
}
