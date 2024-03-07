package com.a22ivancp.accesoadatos.model.dao;

import com.a22ivancp.accesoadatos.model.JPAUtils;
import com.a22ivancp.accesoadatos.model.entities.Student;
import com.a22ivancp.accesoadatos.model.entities.StudentTitles;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DAOStudent implements DAO<Student> {
    private EntityManager em;
    public DAOStudent(){
        em = JPAUtils.getEntityManager();
    }
    @Override
    public Student getByID(int id) {
        return em.find(Student.class,id);
    }

    @Override
    public List<Student> getAll() {
        return em.createQuery("SELECT * FROM Student", Student.class).getResultList();
    }

    @Override
    public void addElement(Student object) {
        em.persist(object);
    }

    @Override
    public void updateElement(Student object) {
        em.merge(object);
    }

    @Override
    public void removeElement(Student object) {
        em.remove(object);
    }

    @Override
    public void removeByID(int id) {
        List<Student> list = getAll();
        for (Student element : list){
            if (element.getIdStudent().equals(id)){
                em.remove(element);
            }
        }
    }
}
