package com.jee.JPA_demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Collection;

public class ActionsBD {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager em = entityManagerFactory.createEntityManager();

    public Collection<UsersEntity> getUtilisateurs() {
        Query q = em.createQuery("select u from UsersEntity u");
        return q.getResultList();
    }

    public Collection<EmployesEntity> getListeEmployes() {
        Query q = em.createQuery("select e from EmployesEntity e");
        return q.getResultList();
    }

    public void supprimerEmploye(String id) {
        int idEmp = Integer.parseInt(id);
        Query q = em.createQuery("delete from EmployesEntity e where e.id = :emplId");
        q.setParameter("emplId", idEmp);
        q.executeUpdate();
    }

}
