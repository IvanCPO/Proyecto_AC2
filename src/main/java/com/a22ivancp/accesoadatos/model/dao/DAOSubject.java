package com.a22ivancp.accesoadatos.model.dao;

import com.a22ivancp.accesoadatos.model.JPAUtils;
import com.a22ivancp.accesoadatos.model.entities.Subject;
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
        return em.createQuery("SELECT s FROM Subject s", Subject.class).getResultList();
    }

    @Override
    public void addElement(Subject object) {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }

    @Override
    public void updateElement(Subject object) {
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
    }

    @Override
    public void removeElement(Subject object) {
        em.getTransaction().begin();
        em.remove(object);
        em.getTransaction().commit();
    }

    @Override
    public void removeByID(int id) {
        List<Subject> list = getAll();
        for (Subject subject : list){
            if (subject.getIdSubject().equals(id)){
                em.getTransaction().begin();
                em.remove(subject);
                em.getTransaction().commit();
                break;
            }
        }
    }
}
