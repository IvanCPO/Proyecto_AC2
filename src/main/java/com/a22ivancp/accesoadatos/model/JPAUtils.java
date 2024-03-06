package com.a22ivancp.accesoadatos.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
public class JPAUtils {
    private static EntityManagerFactory ENTITY_MANAGER_FACTORY;
    private JPAUtils(){}
    private static void generateFactory(){
        if (ENTITY_MANAGER_FACTORY==null)
            synchronized (JPAUtils.class){
                if (ENTITY_MANAGER_FACTORY==null)
                    ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("HIJODEPUTA");
            }
    }
    public static EntityManager getEntityManager(){
        generateFactory();
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }
}