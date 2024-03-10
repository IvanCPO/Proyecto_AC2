package com.a22ivancp.accesoadatos.model.dao;

import com.a22ivancp.accesoadatos.model.JPAUtils;
import com.a22ivancp.accesoadatos.model.dto.DTOStudent;
import com.a22ivancp.accesoadatos.model.dto.DTOUserTitle;
import com.a22ivancp.accesoadatos.model.entities.Student;
import com.a22ivancp.accesoadatos.model.entities.StudentTitles;
import jakarta.persistence.EntityManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
        return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    @Override
    public void addElement(Student object) {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }

    @Override
    public void updateElement(Student object) {
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
    }

    @Override
    public void removeElement(Student object) {
        em.getTransaction().begin();
        em.remove(object);
        em.getTransaction().commit();
    }

    @Override
    public void removeByID(int id) {
        List<Student> list = getAll();
        for (Student element : list){
            if (element.getIdStudent().equals(id)){
                em.getTransaction().begin();
                em.remove(element);
                em.getTransaction().commit();
                break;
            }
        }
    }
    public ObservableList<DTOStudent> getAllDTOStudents(){
        List<Student> students = getAll();
        ObservableList<DTOStudent> list = FXCollections.observableArrayList();
        for (Student student : students){
            list.add(new DTOStudent(student));
        }
        return list;
    }
    public ObservableList<DTOUserTitle> getAllDTOUserTitles(Student student){
        ObservableList<DTOUserTitle> list = FXCollections.observableArrayList();
        for (StudentTitles studentTitle : student.getTitles()){
            list.add(new DTOUserTitle(studentTitle));
        }
        return list;
    }

}
