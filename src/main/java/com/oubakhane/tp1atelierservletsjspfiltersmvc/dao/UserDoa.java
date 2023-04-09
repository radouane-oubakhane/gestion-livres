package com.oubakhane.tp1atelierservletsjspfiltersmvc.dao;

import com.oubakhane.tp1atelierservletsjspfiltersmvc.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

import java.util.List;

public class UserDoa implements Dao {
    private final EntityManagerFactory emf;

    public UserDoa(EntityManagerFactory emf) {
        this.emf = emf;
    }
    @Override
    public void add(Object o) {
        User user = (User) o;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public void update(Object o) {
        User user = (User) o;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Object o) {
        User user = (User) o;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
    }

    @Override
    public Object find(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(User.class, id);
    }

    public Object find(String login) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT user FROM User As user WHERE user.login = :login", User.class);
        query.setParameter("login", login);
        Object result = query.getSingleResult();
        em.getTransaction().commit();
        return result;
    }

    @Override
    public List findAll() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT u FROM User u");
        return query.getResultList();
    }
}
