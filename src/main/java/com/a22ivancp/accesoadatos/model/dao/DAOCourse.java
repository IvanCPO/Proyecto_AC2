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
        em.persist(object);
    }

    @Override
    public void updateElement(Course object) {
        em.merge(object);
    }

    @Override
    public void removeElement(Course object) {
        em.remove(object);
    }

    @Override
    public void removeByID(int id) {
        List<Course> list = getAll();
        for (Course element : list){
            if (element.getKey().equals(id)){
                em.remove(element);
            }
        }
    }
}
