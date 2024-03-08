package com.a22ivancp.accesoadatos.model.dao;

import com.a22ivancp.accesoadatos.model.JPAUtils;
import com.a22ivancp.accesoadatos.model.entities.Course;
import com.a22ivancp.accesoadatos.model.entities.School;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DAOCourse implements DAO<Course>{
    private EntityManager em;
    public DAOCourse(){
        em = JPAUtils.getEntityManager();
    }
    @Override
    public Course getByID(int id) {
        return em.find(Course.class,id);
    }

    @Override
    public List<Course> getAll() {
        return em.createQuery("SELECT * FROM Course", Course.class).getResultList();
    }

    @Override
    public void addElement(Course object) {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }

    @Override
    public void updateElement(Course object) {
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
    }

    @Override
    public void removeElement(Course object) {
        em.getTransaction().begin();
        em.remove(object);
        em.getTransaction().commit();
    }

    @Override
    public void removeByID(int id) {
        List<Course> list = getAll();
        for (Course element : list){
            if (element.getKey().equals(id)){
                em.getTransaction().begin();
                em.remove(element);
                em.getTransaction().commit();
                break;
            }
        }
    }
}
