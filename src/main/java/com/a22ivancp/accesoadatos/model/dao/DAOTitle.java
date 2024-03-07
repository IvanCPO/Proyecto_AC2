package com.a22ivancp.accesoadatos.model.dao;

import com.a22ivancp.accesoadatos.model.JPAUtils;
import com.a22ivancp.accesoadatos.model.entities.Title;
import jakarta.persistence.EntityManager;
import javafx.scene.layout.TilePane;

import java.util.List;

public class DAOTitle implements DAO<Title>{
    private EntityManager em;
    public DAOTitle(){
        em = JPAUtils.getEntityManager();
    }
    @Override
    public Title getByID(int id) {
        return em.find(Title.class,id);
    }

    @Override
    public List<Title> getAll() {
        return em.createQuery("SELECT * FROM Title", Title.class).getResultList();
    }

    @Override
    public void addElement(Title object) {
        em.persist(object);
    }

    @Override
    public void updateElement(Title object) {
        em.merge(object);
    }

    @Override
    public void removeElement(Title object) {
        em.remove(object);
    }

    @Override
    public void removeByID(int id) {
        List<Title> list = getAll();
        for (Title title : list){
            if (title.getIdTitle().equals(id)){
                em.remove(title);
            }
        }
    }
}
