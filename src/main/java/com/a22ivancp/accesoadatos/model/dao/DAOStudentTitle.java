package com.a22ivancp.accesoadatos.model.dao;

import com.a22ivancp.accesoadatos.model.JPAUtils;
import com.a22ivancp.accesoadatos.model.entities.StudentTitles;
import com.a22ivancp.accesoadatos.model.entities.Subject;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DAOStudentTitle implements DAO<StudentTitles> {
    private EntityManager em;
    public DAOStudentTitle(){
        em = JPAUtils.getEntityManager();
    }
    @Override
    public StudentTitles getByID(int id) {
        return em.find(StudentTitles.class,id);
    }

    @Override
    public List<StudentTitles> getAll() {
        return em.createQuery("SELECT * FROM StudentTitles", StudentTitles.class).getResultList();
    }

    @Override
    public void addElement(StudentTitles object) {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }

    @Override
    public void updateElement(StudentTitles object) {
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
    }

    @Override
    public void removeElement(StudentTitles object) {
        em.getTransaction().begin();
        em.remove(object);
        em.getTransaction().commit();
    }

    @Override
    public void removeByID(int id) {
        List<StudentTitles> list = getAll();
        for (StudentTitles element : list){
            if (element.getId().equals(id)){
                em.getTransaction().begin();
                em.remove(element);
                em.getTransaction().commit();
                break;
            }
        }
    }
}
