package com.a22ivancp.accesoadatos.model.dao;

import com.a22ivancp.accesoadatos.model.JPAUtils;
import com.a22ivancp.accesoadatos.model.entities.Direction;
import com.a22ivancp.accesoadatos.model.entities.School;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DAODirection implements DAO<Direction> {
    private EntityManager em;
    public DAODirection(){
        em = JPAUtils.getEntityManager();
    }
    @Override
    public Direction getByID(int id) {
        return em.find(Direction.class,id);
    }

    @Override
    public List<Direction> getAll() {
        return em.createQuery("SELECT * FROM Direction", Direction.class).getResultList();
    }

    @Override
    public void addElement(Direction object) {
        em.persist(object);
    }

    @Override
    public void updateElement(Direction object) {
        em.merge(object);
    }

    @Override
    public void removeElement(Direction object) {
        em.remove(object);
    }

    @Override
    public void removeByID(int id) {
        List<Direction> list = getAll();
        for (Direction element : list){
            if (element.getIdDirection().equals(id)){
                em.remove(element);
            }
        }
    }
}
