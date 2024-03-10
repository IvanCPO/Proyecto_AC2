package com.a22ivancp.accesoadatos.model.dao;

import com.a22ivancp.accesoadatos.model.JPAUtils;
import com.a22ivancp.accesoadatos.model.entities.Direction;
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
        return em.createQuery("SELECT d FROM Direction d", Direction.class).getResultList();
    }

    @Override
    public void addElement(Direction object) {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }

    @Override
    public void updateElement(Direction object) {
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
    }

    @Override
    public void removeElement(Direction object) {
        em.getTransaction().begin();
        em.remove(object);
        em.getTransaction().commit();
    }

    @Override
    public void removeByID(int id) {
        List<Direction> list = getAll();
        for (Direction element : list){
            if (element.getIdDirection().equals(id)){
                em.getTransaction().begin();
                em.remove(element);
                em.getTransaction().commit();
                break;
            }
        }
    }
}
